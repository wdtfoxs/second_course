<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/template.ftl"/>
<@mainTemplate title="Регистрация"/>
<#macro m_body>
<!-- content -->
<div class="container">
    <div class="main">
        <!-- start registration -->
        <div class="registration">
            <div class="registration_left">
                <h2>new user? <span> create an account </span></h2>
                <div class="registration_form">
                    <!-- Form -->
                    <@form.form commandName="regForm" id="registration_form" action="/reg" acceptCharset="UTF-8" method="post">
                    <#--<form id="registration_form" action="contact.php" method="post">-->
                        <div>
                            <label>
                                <@form.input path="login" placeholder="login:"/>
                                <@form.errors path="login" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.input path="firstName" placeholder="first name:"/>
                                <@form.errors path="firstName" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.input path="lastName" placeholder="last name:"/>
                                <@form.errors path="lastName" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.input path="otch" placeholder="otchestvo:"/>
                                <@form.errors path="otch" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.input path="address" placeholder="address:"/>
                                <@form.errors path="address" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.input path="email" placeholder="email address:"/>
                                <@form.errors path="email" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.password path="password" placeholder="password"/>
                                <@form.errors path="password" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <label>
                                <@form.password path="confirmPassword" placeholder="retype password"/>
                                <@form.errors path="confirmPassword" cssStyle="color: red;" />
                            </label>
                        </div>
                        <div>
                            <input type="submit" value="create an account" id="register-submit">
                        </div>
                        </form>
                    </@form.form>
                    <!-- /Form -->
                </div>
            </div>
            <div class="registration_left">
                <h2>existing user</h2>
                <div class="registration_form">
                    <#if error?has_content>
                        <div style="color: red;">Error! Please, check your email and password!</div>
                    </#if>
                    <!-- Form -->
                    <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                        <div>
                            <label>
                                <input placeholder="login:" type="text" name="j_username">
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="password" type="password" name="j_password">
                            </label>
                        </div>
                        <div id="wdtf">
                            <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                            <label for="remember_me" class="inline">Remember me</label>
                        </div>
                        <div>
                            <input type="submit" value="sign in">
                        </div>
                        <#--<div class="forget">-->
                            <#--<a href="#">forgot your password</a>-->
                        <#--</div>-->
                    </form>
                    <!-- /Form -->
                </div>
            </div>
            <#--<div class="text" id="wdtf">fewf;ew</div>-->
            <script>$("#wdtf").text{

            };</script>
        </div>
        <!-- end registration -->
    </div>
</div>

</#macro>