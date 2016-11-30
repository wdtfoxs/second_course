<#include "template/template.ftl">
<@mainTemplate title="Каталог" scripts=["js/own/catalog.js"]/>
<#macro m_body>
<div class="content product-box-main">
    <div class="wrap">
        <div class="content-left">
            <#include "filters/filter.ftl"/>
        </div>
    <div class="content-right product-box">
        <#include "filters/upFilter.ftl"/>
    <div class="product-grids">
        <!--- start-rate---->
        <script src="/resources/js/jstarbox.js"></script>
        <link rel="stylesheet" href="/resources/css/jstarbox.css" type="text/css" media="screen"
              charset="utf-8"/>
        <script type="text/javascript">
            jQuery(function () {
                jQuery('.starbox').each(function () {
                    var starbox = jQuery(this);
                    starbox.starbox({
                        average: starbox.attr('data-start-value'),
                        changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                        ghosting: starbox.hasClass('ghosting'),
                        autoUpdateAverage: starbox.hasClass('autoupdate'),
                        buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                        stars: starbox.attr('data-star-count') || 5
                    }).bind('starbox-value-changed', function (event, value) {
                        if (starbox.hasClass('random')) {
                            var val = Math.random();
                            starbox.next().text(' ' + val);
                            return val;
                        }
                    })
                });
            });
        </script>
        <!---//End-rate---->
        <#if goods??>
            <#list goods as g>
                <#if (g_index+1) % 3 != 0>
                    <div class="product-grid fade">
                        <div class="product-grid-head">
                            <ul class="grid-social">
                                <li><div id="add_cart_${g.id}"></div></li>
                                <div class="clear"></div>
                            </ul>
                            <div class="block">
                                <div class="starbox small ghosting"></div>
                                <span> (46)</span>
                            </div>
                        </div>
                        <div class="product-pic">
                            <#if g.image?? && g.image.smallImage??>
                                <a href="/good/${g.id}"><img src="/resources/images/${g.image.smallImage}"
                                                             title="product-name"/></a>
                            <#else>
                                <a href="/good/${g.id}"><img src="/resources/images/noImageProduct.png"
                                                             title="product-name"/></a>
                            </#if>
                            <p>
                                <a href="/good/${g.id}">${g.name}</a>
                                <span>${g.description}</span>
                            </p>
                        </div>
                        <div class="product-info">
                            <div class="product-info-cust">
                                <a href="/good/${g.id}">Details</a>
                            </div>
                            <div class="product-info-price">
                                <a href="/good/${g.id}">&#163; ${g.price}</a>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="more-product-info" id="addToCart" data-id="${g.id}">
                            <span> </span>
                        </div>
                    </div>
                <#else >
                    <div class="product-grid fade last-grid">
                        <div class="product-grid-head">
                            <ul class="grid-social">
                                <li><div id="add_cart_${g.id}"></div></li>
                                <div class="clear"></div>
                            </ul>
                            <div class="block">
                                <div class="starbox small ghosting"></div>
                                <span> (46)</span>
                            </div>
                        </div>
                        <div class="product-pic">
                            <#if g.image?? && g.image.smallImage??>
                                <a href="/good/${g.id}"><img src="/resources/images/${g.image.smallImage}"
                                                             title="product-name"/></a>
                            <#else>
                                <a href="/good/${g.id}"><img src="/resources/images/noImageProduct.png"
                                                             title="product-name"/></a>
                            </#if>
                            <p>
                                <a href="/good/${g.id}">${g.name}</a>
                                <span>${g.description}</span>
                            </p>
                        </div>
                        <div class="product-info">
                            <div class="product-info-cust">
                                <a href="/good/${g.id}">Details</a>
                            </div>
                            <div class="product-info-price">
                                <a href="/good/${g.id}">&#163; ${g.price}</a>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="more-product-info" id="addToCart" data-id="${g.id}">
                            <span> </span>
                        </div>
                    </div>
                </#if>
            </#list>
            <div class="clear"></div>
        </div>
            <#--<div class="loadmore-products">-->
                <#--<a href="#">Loadmore</a>-->
            <#--</div>-->
        <#else>
            Извините, в данный момент товары по данной категории отсутсвуют.
        </div>
        </#if>
    </div>
    <div class="clear"></div>
</div>
</div>
</#macro>
