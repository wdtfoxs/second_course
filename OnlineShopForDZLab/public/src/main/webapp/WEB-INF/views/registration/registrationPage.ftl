<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl"/>
<@mainTemplate title="Регистрация"/>
<#macro m_body>
<div class="content login-box">
    <div class="login-main">
        <div class="wrap">
            <h1>CREATE AN ACCOUNT</h1>
            <div class="register-grids">
                <@form.form commandName="regForm" id="registration_form" action="/reg" acceptCharset="UTF-8" method="post">
                    <div class="register-top-grid">
                        <h3>PERSONAL INFORMATION</h3>
                        <div>
                            <span>First Name<label>*</label></span>
                            <@form.input path="firstName"/>
                            <@form.errors path="firstName" cssStyle="color: red;" />
                        </div>
                        <div>
                            <span>Last Name<label>*</label></span>
                            <@form.input path="lastName"/>
                            <@form.errors path="lastName" cssStyle="color: red;" />
                        </div>
                        <div>
                            <span>Email Address<label>*</label></span>
                            <@form.input path="email"/>
                            <@form.errors path="email" cssStyle="color: red;" />
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                    <div class="register-bottom-grid">
                        <h3>LOGIN INFORMATION</h3>
                        <div>
                            <span>Password<label>*</label></span>
                            <@form.input path="password"/>
                            <@form.errors path="password" cssStyle="color: red;" />
                        </div>
                        <div>
                            <span>Confirm Password<label>*</label></span>
                            <@form.input path="confirmPassword"/>
                            <@form.errors path="confirmPassword" cssStyle="color: red;" />
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                    <input type="submit" value="submit"/>
                </@form.form>
            </div>
        </div>
    </div>
</div>
</#macro>