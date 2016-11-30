<#include "template/template.ftl"/>
<@mainTemplate title="Корзина" scripts=["js/own/catalog.js"]/>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#macro m_body>
<div class="login-main">
    <div class="product-reviwes">
        <div class="wrap">
            <div class="similar-products-left">
                <div class="price-details">
                    TOTAL
                    <br>
                    <br>
                    <#if (Session.cart.goods)??>
                        <#if cartTotal??>
                            Вы купили товаров на сумму
                            <span class="cart_total">$${cartTotal}</span>
                        <#else >
                            <span class="cart_total">$0</span>
                        </#if>
                        <div class="clearfix"></div>
                    <#else>
                        Вы пока не добавили товары.
                    </#if>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
                <br>
            </div>
            <div class="similar-products-right">
                <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                    Для оформления заказа нужно авторизоваться.
                </@sec.authorize>
                <@sec.authorize access="isAuthenticated()">
                    <#if (Session.cart.getGoodsId)??>
                        <div class="wrap">
                            <h1>Заполните поля данными для оформления заказа</h1>
                            <div class="register-grids">
                                <form action="/order/reserve" method="post">
                                    <div class="register-top-grid">
                                        <div>
                                            <span>Surname<label>*</label></span>
                                            <input type="text" name="surname"
                                                   value="<@sec.authentication property = "principal.user.surname"/>"
                                                   required>
                                        </div>
                                        <div>
                                            <span>Name<label>*</label></span>
                                            <input type="text" name="name"
                                                   value="<@sec.authentication property = "principal.user.name"/>"
                                                   required>
                                        </div>
                                        <div>
                                            <span>Middle Name<label>*</label></span>
                                            <input type="text" name="middleName" required>
                                        </div>
                                        <div>
                                            <span>Address<label>*</label></span>
                                            <input type="text" name="address" required>
                                        </div>
                                        <div>
                                            <span>Email Address<label>*</label></span>
                                            <input type="text"
                                                   value="<@sec.authentication property = "principal.user.email"/>"
                                                   name="email" required>
                                        </div>
                                        <div>
                                            <span>Mobile Phone<label></label></span>
                                            <input type="text" pattern="[+]{1}7[0-9]{10}"
                                                   name="telephone">
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <div class="clear"></div>
                                    <input type="submit" value="submit"/>
                                </form>
                            </div>
                        </div>
                    <#else>
                        Невозможно оформить заказ без товаров.
                    </#if>
                </@sec.authorize>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
</#macro>