<#include "../template/template.ftl"/>
<@mainTemplate title="Личный кабинет"/>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<style>
    h7 {
        text-decoration: underline; /* Подчеркивание заголовка */
    }
</style>
<#macro m_body>
<div class="container">
    <div class="women_main">
        <div class="col-md-3 s-d">
            <div class="w_sidebar">
                <div class="w_nav1">
                    <h4>Личный кабинет</h4>
                    <br>
                    <div class="cart-total">
                        <div class="price-details">
                            <span><h4>Login:</h4></span>
                            <span class="title"><h5><@sec.authentication property = "principal.user.login"/></h5></span>
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
        <div class="col-md-9 w_content">
            <div class="single-bottom2">
                <#if userOrders?? >
                    <#list userOrders as order>
                        <#if order.status == false>
                        <h6>Заказ, находящийся в обработке</h6>
                            <h7>Заказ оформлен на </h7>
                        <br>
                            Фамилия: ${order.surname}<br>
                            Имя: ${order.name}<br>
                            Отчество: ${order.otch}<br>
                            Адрес доставки: ${order.address}<br>
                            Телефон для связи: ${order.telephone}<br>
                        <details>
                            <summary>Показать товары</summary>
                            <#list order.goods as g>
                                <div class="product">
                                    <div class="product-desc">
                                        <div class="product-img">
                                <#if g.image??>
                                            <img src="/resources/images/${g.image.image_1}" class="img-responsive " alt="" href="/good/${g.id}"/>
                                <#else>
                                    <img src="/resources/images/noImage.png" class="img-responsive " alt="" href="/good/${g.id}"/>
                                </#if>
                                        </div>
                                        <div class="prod1-desc">
                                            <h5><a class="product_link" href="#">${g.name}</a></h5>
                                            <p class="product_descr"> ${g.description}</p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="product_price">
                                        <span class="price-access">$${g.price}</span>
                                        <a href="/good/${g.id}">
                                            <button class="button1"><span>Show good</span></button>
                                        </a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </#list>
                        </details>
                            <br>
                            <form action="/order/make/${order.id}" method="post">
                                <button type="submit" class="btn btn-success btn-block btn-sm">Подтвердить заказ</button>
                            </form>
                            <br>
                            <form action="/order/cancel/${order.id}" method="post">
                                <button type="submit" class="btn btn-danger btn-block btn-sm">Отменить заказ</button>
                            </form>
                            <br>
                        </#if>
                    </#list>
                    <#list userOrders as order>
                        <#if order.status>
                            <h6>Заказ от ${order.date}</h6>
                        <details>
                            <summary>Показать заказ</summary>
                            <h7>Заказ был оформлен на </h7>
                            <br>
                            Фамилия: ${order.surname}<br>
                            Имя: ${order.name}<br>
                            Отчество: ${order.otch}<br>
                            Адрес доставки: ${order.address}<br>
                            Телефон для связи: ${order.telephone}<br>
                        <details>
                            <summary>Показать товары</summary>

                            <#list order.goods as g>
                                <div class="product">
                                    <div class="product-desc">
                                        <div class="product-img">
                                            <#if g.image??>
                                                <img src="/resources/images/${g.image.image_1}" class="img-responsive " alt="" href="/good/${g.id}"/>
                                            <#else>
                                                <img src="/resources/images/noImage.png" class="img-responsive " alt="" href="/good/${g.id}"/>
                                            </#if>
                                        </div>
                                        <div class="prod1-desc">
                                            <h5><a class="product_link" href="#">${g.name}</a></h5>
                                            <p class="product_descr"> ${g.description}</p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="product_price">
                                        <span class="price-access">$${g.price}</span>
                                        <a href="/good/${g.id}">
                                            <button class="button1"><span>Show good</span></button>
                                        </a>
                                    </div>
                                    <div class="clearfix"></div>
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
    </div>
</div>
<div class="clearfix"></div>
<br>
</#macro>