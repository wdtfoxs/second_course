<#include "../template/template.ftl"/>
<@mainTemplate title="Корзина" scripts=["js/own/catalog.js"]/>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#macro m_body>
<div class="container">
    <div class="check">
        <div class="col-md-3 cart-total">
            <a class="continue" href="/catalog/all">Continue to basket</a>
            <div class="price-details">
                <h3>Order Details</h3>
                <#if (Session.cart.goods)??>
                    <#list Session.cart.goods?keys as gId>
                        <span id="${gId}">${Session.cart.getGood(gId).name}</span>
                        <span class="total1" id="${gId}">${Session.cart.getCount(gId)}</span>
                    </#list>
                <#else>
                    Вы пока не добавили товары.
                </#if>
                <div class="clearfix"></div>
            </div>
            <ul class="total_price">
                <li class="last_price"> <h4>TOTAL</h4></li>
                <li class="last_price"><span id="simpleCart_quantity"
                                             class="simpleCart_quantity">0</span></li>
                <div class="clearfix"> </div>
            </ul>


            <div class="clearfix"></div>

        </div>

        <div class="col-md-offset-1 col-md-6 cart-items">
    <@sec.authorize access="isAuthenticated()">
        <#if (Session.cart.getGoodsId)??>
            <div class="registration_right">
                <h2>Заполните поля данными для оформления заказа</h2>
                <div class="registration_form">
                    <!-- Form -->
                    <form  action="/order/reserve" method="post">
                        <div>
                            <label>
                                <input placeholder="surname" type="text" name="surname" value="<@sec.authentication property = "principal.user.surname"/>" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="name" type="text" name="name" value="<@sec.authentication property = "principal.user.name"/>" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="middleName" type="text" name="middleName" value="<@sec.authentication property = "principal.user.otch"/>" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="address" type="text" name="address" value="<@sec.authentication property = "principal.user.address"/>" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="email:" type="email" value="<@sec.authentication property = "principal.user.email"/>" name="email" required>
                            </label>
                        </div>
                        <div>
                            <label>
                                <input placeholder="+7 (XXX) XXX XX XX" type="tel" pattern="[+]{1}7[0-9]{10}" name="telephone">
                            </label>
                        </div>
                        <div>
                            <input type="submit" value="Оформить">
                        </div>
                    </form>
                    <!-- /Form -->
                </div>
            </div>
        <#else>
            Невозможно оформить заказ без товаров.
        </#if>
    </@sec.authorize>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
</#macro>