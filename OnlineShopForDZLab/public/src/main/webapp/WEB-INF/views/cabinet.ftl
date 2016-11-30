<#include "template/template.ftl"/>
<@mainTemplate title="Личный кабинет"/>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<style>
    h4, h6{
        text-decoration: underline;
    }
</style>
<#macro m_body>
<div class="login-main">
    <div class="product-reviwes">
        <div class="wrap">
            <div class="similar-products-left">
                <div class="w_sidebar">
                    <div class="w_nav1">
                        <h4>Личный кабинет</h4>
                        <br>
                        <div class="cart-total">
                            <div class="price-details">
                                <span><h4>Your name:</h4></span>
                                <span class="title1"><h5><@sec.authentication property = "principal.user.name"/></h5></span>
                                <span><h4>Your surname:</h4></span>
                                <span class="title1"><h5><@sec.authentication property = "principal.user.surname"/></h5></span>
                                <span><h4>Your e-mail:</h4></span>
                                <span class="title1"><h5><@sec.authentication property = "principal.user.email"/></h5></span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="similar-products-right">
                <div id="owl-demo" class="owl-carousel">
                    <#if userOrders?? >
                        <#list userOrders as order>
                            <#if order.status == false>
                                <h6>Заказ, находящийся в обработке</h6>
                                <h7>Заказ оформлен на</h7>
                                <br>
                                Фамилия: ${order.surname}<br>
                                Имя: ${order.name}<br>
                                Отчество: ${order.otch}<br>
                                Адрес доставки: ${order.address}<br>
                                Телефон для связи: ${order.telephone}<br>
                                <details>
                                    <summary>Показать товары</summary>
                                    <#list order.goods as g>
                                        <div class="item">
                                            <div class="product-grid fade sproduct-grid">
                                                <div class="product-pic">
                                                    <#if (g.image)?? && (g.image.smallImage)??>
                                                        <a href="/good/${g.id}"><img
                                                                src="/resources/images/${g.image.smallImage}"
                                                                title="product-name"/></a>
                                                    <#else >
                                                        <a href="/good/${g.id}"><img
                                                                src="/resources/images/noImageProduct.png"
                                                                title="product-name"/></a>
                                                    </#if>
                                                    <p>
                                                        <a href="/good/${g.id}">
                                                        ${g.name}</a>
                                                        <span>${g.description}</span>
                                                    </p>
                                                </div>
                                                <div class="product-info">
                                                    <div class="product-info-cust">
                                                        <a href="/good/${g.id}">Details</a>
                                                    </div>
                                                    <div class="product-info-price">
                                                        <a href="#">&#163; ${g.price}</a>
                                                    </div>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </details>
                                <br>
                                <form action="/order/make/${order.id}" method="post">
                                    <button type="submit" class="btn btn-success btn-block btn-sm">Подтвердить заказ
                                    </button>
                                </form>
                                <br>
                                <form action="/order/cancel/${order.id}" method="post">
                                    <button type="submit" class="btn btn-danger btn-block btn-sm">Отменить заказ
                                    </button>
                                </form>
                                <br>
                            </#if>
                        </#list>
                        <#list userOrders as order>
                            <#if order.status>
                                <h6>Заказ от ${(order.date?date)!} </h6>
                                <details>
                                    <summary>Показать заказ</summary>
                                    <h7>Заказ был оформлен на</h7>
                                    <br>
                                    Фамилия: ${order.surname}<br>
                                    Имя: ${order.name}<br>
                                    Отчество: ${order.otch}<br>
                                    Адрес доставки: ${order.address}<br>
                                    Телефон для связи: ${order.telephone}<br>
                                    <details>
                                        <summary>Показать товары</summary>

                                        <#list order.goods as g>
                                        <div class="item">
                                            <div class="product-grid fade sproduct-grid">
                                                <div class="product-pic">
                                                    <#if (g.image)?? && (g.image.smallImage)??>
                                                        <a href="/good/${g.id}"><img
                                                                src="/resources/images/${g.image.smallImage}"
                                                                title="product-name"/></a>
                                                    <#else >
                                                        <a href="/good/${g.id}"><img
                                                                src="/resources/images/noImageProduct.png"
                                                                title="product-name"/></a>
                                                    </#if>
                                                    <p>
                                                        <a href="/good/${g.id}">
                                                        ${g.name}</a>
                                                        <span>${g.description}</span>
                                                    </p>
                                                </div>
                                                <div class="product-info">
                                                    <div class="product-info-cust">
                                                        <a href="/good/${g.id}">Details</a>
                                                    </div>
                                                    <div class="product-info-price">
                                                        <a href="#">&#163; ${g.price}</a>
                                                    </div>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                        </#list>
                                    </details>
                                    <br>
                                </details>
                            </#if>
                        </#list>
                    <#else >
                        Вы пока ничего не покупали.
                    </#if>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<br>
</#macro>