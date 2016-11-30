<#include "template/template.ftl"/>
<@mainTemplate title="Логин"/>
<#macro m_body>
<div class="content login-box">
    <div class="login-main">
        <div class="wrap">
            <h1>LOGIN OR CREATE AN ACCOUNT</h1>
            <div class="login-left">
                <h3>NEW CUSTOMERS</h3>
                <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
                <a class="acount-btn" href="/reg">Creat an Account</a>
            </div>
            <div class="login-right">
                <h3>REGISTERED CUSTOMERS</h3>
                <p>If you have an account with us, please log in.</p>
                <#if error?has_content>
                    <div style="color: red;">Error! Please, check your email and password!</div>
                </#if>
                <form action="/j_spring_security_check" method="post">
                    <div>
                        <span>Email Address<label>*</label></span>
                        <input type="text" name="j_username">
                    </div>
                    <div>
                        <span>Password<label>*</label></span>
                        <input type="text" name="j_password">
                    </div>
                    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Remember me</label>
                    <br>
                    <input type="submit" value="Login" />
                </form>
            </div>
            <div class="clear"> </div>
        </div>
    </div>
</div>
</#macro>