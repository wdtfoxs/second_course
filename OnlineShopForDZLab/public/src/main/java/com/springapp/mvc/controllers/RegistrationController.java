package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategories;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @IncludeCategories
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    @IncludeCategories
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registrationPage";
        }
        if (!registrationFormBean.getPassword().equals(registrationFormBean.getConfirmPassword())) {
            return "registration/registrationPage";
        }
        if (!userService.exsistEmail(registrationFormBean.getEmail())){
            return "registration/registrationPage";
        }
        User user = new User();
        user.setName(registrationFormBean.getFirstName());
        user.setSurname(registrationFormBean.getLastName());
        user.setHashPassword(registrationFormBean.getPassword());
        user.setEmail(registrationFormBean.getEmail());
        userService.addUser(user);
        return "registration/resultReg";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp(){
        String key = request.getParameter("key");
        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);
        if (key.equals(user.getKey())){
            user.setEnabled(true);
            userService.updateUser(user);
        }
        return "registration/active";
    }
}
