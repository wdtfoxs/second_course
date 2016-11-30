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
                <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                    Авторизуйтесь, чтобы сделать заказ.
                </@sec.authorize>
                <@sec.authorize access="isAuthenticated()">
                    <div class="loadmore-products">
                        <a href="/order">Place Order</a>
                    </div>
                </@sec.authorize>
            </div>
            <div class="similar-products-right">
                <!-- start content_slider -->
                <!--- start-rate---->
                <script src="/resources/js/jstarbox.js"></script>
                <link rel="stylesheet" href="/resources/css/jstarbox.css" type="text/css" media="screen"
                      charset="utf-8"/>
                <!---//End-rate---->
                <div id="owl-demo" class="owl-carousel">
                    <#if (Session.cart.getGoodsId)??>
                        <#list Session.cart.goods?keys as gId>
                            <div class="item" id="${gId}">
                                <div class="product-grid fade sproduct-grid">
                                    <div class="product-pic">
                                        <#if (Session.cart.getGood(gId).image)?? && (Session.cart.getGood(gId).image.smallImage)??>
                                            <a href="/good/${gId}"><img
                                                    src="/resources/images/${Session.cart.getGood(gId).image.smallImage}"
                                                    title="product-name"/></a>
                                        <#else >
                                            <a href="/good/${gId}"><img src="/resources/images/noImageProduct.png"
                                                                        title="product-name"/></a>
                                        </#if>
                                        <div align="center"><span class="total1" id="${gId}"><button id="minus"
                                                                                                     data-id="${gId}"
                                                                                                     class="btn btn-default btn-xs">
                                            <
                                        </button><a id="num_${gId}">${Session.cart.getCount(gId)}</a><button id="plus"
                                                                                                             data-id="${gId}"
                                                                                                             class="btn btn-default btn-xs">
                                            >
                                        </button></span></div>
                                        <p>
                                            <a href="/good/${gId}">
                                            ${Session.cart.getGood(gId).name}</a>
                                            <span>${Session.cart.getGood(gId).description}</span>
                                        </p>
                                    </div>
                                    <div class="product-info">
                                        <div class="product-info-cust">
                                            <a href="/good/${gId}">Details</a>
                                        </div>
                                        <div class="product-info-price">
                                            <a href="#">&#163; ${Session.cart.getGood(gId).price}</a>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <div class="close1" id="delFromCart" data-id="${gId}"></div>
                                </div>
                            </div>
                        </#list>
                    <#else >
                        Корзина пуста.
                    </#if>
                </div>
                <!----//End-img-cursual---->
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
</#macro>