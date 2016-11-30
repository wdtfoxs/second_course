<#include "../template/template.ftl"/>
<@mainTemplate title="Логин"/>
<#macro m_body>
<!-- content -->
<div class="container">
    <div class="main">
        <!-- start registration -->
        <div class="registration">
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
                        <div>
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
        </div>
    </div>
</div>

</#macro>