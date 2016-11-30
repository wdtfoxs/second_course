<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!-- header_top -->
<div class="top_bg" xmlns="http://www.w3.org/1999/html">
    <div class="container">
        <div class="header_top">
            <div class="top_right">
                <ul>
                    <li><a href="#">help</a></li>
                    |
                    <li><a href="contact.html">Contact</a></li>
                    |
                    <li><a href="#">Delivery information</a></li>
                </ul>
            </div>
            <div class="top_left">
                <h2><span></span> Call us : 032 2352 782</h2>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- header -->
<div class="header_bg">
    <div class="container">
        <div class="header">
            <div class="head-t">
                <div class="logo">
                    <a href="/"><img src="/resources/images/logo.png" class="img-responsive" alt=""/> </a>
                </div>
                <!-- start header_right -->
                <div class="header_right">
                    <div class="rgt-bottom">
                    <@sec.authorize ifAllGranted="ROLE_ANONYMOUS">
                        <div class="log">
                            <div class="login">
                                <div id="loginContainer"><a id="loginButton"><span>Login</span></a>
                                    <div id="loginBox">
                                        <form id="loginForm" action="/j_spring_security_check" method="post">
                                            <fieldset id="body">
                                                <fieldset>
                                                    <label for="email">Login</label>
                                                    <input type="text" name="j_username" id="email">
                                                </fieldset>
                                                <fieldset>
                                                    <label for="password">Password</label>
                                                    <input type="password" name="j_password" id="password">
                                                </fieldset>
                                                <input type="submit" id="login" value="Sign in">
                                                <label for="checkbox"> <input type="checkbox"
                                                                              name="_spring_security_remember_me"
                                                                              id="checkbox"> <i>Remember me</i></label>
                                            </fieldset>
                                        <#--<span><a href="#">Forgot your password?</a></span>-->
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="reg">
                            <a href="/reg">REGISTER</a>
                        </div>
                    </@sec.authorize>
                    <@sec.authorize access="isAuthenticated()">
                        <div class="log">
                            <div class="login">
                                <div id="loginContainer"><a href="/logout" <span>Logout</span></a></div>
                            </div>
                        </div>
                        <div class="log">
                            <a href="/cabinet"><@sec.authentication property="principal.username"/></a>
                        </div>
                    </@sec.authorize>
                        <div class="cart box_1">
                            <a href="/cart">
                                <h3>
                                    <#if cartTotal??>
                                        <span class="cart_total">$${cartTotal}</span>
                                        (<span id="cart_quantity">${cartCount}</span>
                                    <#else >
                                        <span class="cart_total">$0</span>
                                        (<span id="cart_quantity">0</span>
                                    </#if>
                                    items)<img src="/resources/images/bag.png" alt=""></h3>
                            </a>
                            <p><a href="javascript:;" class="simpleCart_empty">(empty card)</a></p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="create_btn">
                            <a href="/cart">CHECKOUT</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="search">
                        <form>
                            <input type="text" value="" placeholder="search...">
                            <input type="submit" value="">
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <#include "menu.ftl">
        </div>
    </div>
</div>