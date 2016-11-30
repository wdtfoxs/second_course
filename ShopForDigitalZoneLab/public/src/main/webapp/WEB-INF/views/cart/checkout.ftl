<#include "../template/template.ftl"/>
<@mainTemplate title="Корзина" scripts=["js/own/catalog.js"]/>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#macro m_body>
<div class="container">
    <div class="check">
        <div class="col-md-3 cart-total">
            <a class="continue" href="/catalog/all">Continue to basket</a>
            <div class="price-details">
                <h3>Price Details</h3>
                <#if (Session.cart.goods)??>
                <span><h5>Name product</h5></span>
                <span class="total1"><h5>Count of product</h5></span>
                <br>
                    <#list Session.cart.goods?keys as gId>
                        <span id="${gId}">${Session.cart.getGood(gId).name}</span>
                        <span class="total1" id="${gId}"><button id="minus" data-id="${gId}" class="btn btn-default btn-xs"><</button><a id="num_${gId}">${Session.cart.getCount(gId)}</a><button id="plus" data-id="${gId}" class="btn btn-default btn-xs">></button></span>
                    <br>
                    </#list>
                <#else>
                Вы пока не добавили товары.
                </#if>
                <div class="clearfix"></div>
            </div>
            <ul class="total_price">
                <li class="last_price"> <h4>TOTAL</h4></li>
                <li class="last_price"> <#if cartTotal??>
                    <span class="cart_total">$${cartTotal}</span>
                <#else >
                    <span class="cart_total">$0</span>
                </#if></li>
                <div class="clearfix"> </div>
            </ul>


            <div class="clearfix"></div>
        <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
        Авторизуйтесь, чтобы сделать заказ.
        </@sec.authorize>
        <@sec.authorize access="isAuthenticated()">
            <a class="order" href="/order">Place Order</a>
        </@sec.authorize>
        </div>

        <div class="col-md-9 cart-items">
            <#if (Session.cart.getGoodsId)??>
                <h1>My Shopping Bag (${Session.cart.size})</h1>
            <#list Session.cart.goods?keys as gId>
                <div class="cart-header" id="${gId}">
                    <div class="close1" id="delFromCart" data-id = "${gId}"> </div>
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <#if (Session.cart.getGood(gId).image)??>
                                <img src="/resources/images/${Session.cart.getGood(gId).image.image_1}" class="img-responsive" alt=""/>
                                <#else>
                                    <img src="/resources/images/noImage.png" class="img-responsive" alt=""/>
                            </#if>
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="/good/${gId}">${Session.cart.getGood(gId).name}</a><span>Model No: 3578</span></h3>
                            <ul class="qty">
                                <#--<li><p>Size : 5</p></li>-->
                                <#--<li><p>Qty : 1</p></li>-->
                                <li><p>Price : ${Session.cart.getGood(gId).price}</p></li>
                            </ul>

                            <#--<div class="delivery">-->
                                <#--<div >Delete from cart</div><img src="/resources/images/bag.png" alt="">-->
                                <#--<div class="clearfix"></div>-->
                            <#--</div>-->
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </#list>
        <#else>
            <h1>My Shopping Bag (0)</h1>
        Корзина пуста.
        </#if>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
</#macro>