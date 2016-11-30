<#include "../template/template.ftl">
<@mainTemplate title="Каталог" scripts=["js/own/catalog.js"]/>
<#macro m_body>
<div class="container">
    <div class="women_main">
        <!-- start sidebar -->
        <div class="col-md-3 s-d">
            <#include "../filters/filter.ftl"/>
        </div>
        <!-- start content -->
        <div class="col-md-9 w_content">
            <#include "../filters/upFilter.ftl"/>
            <!-- grids_of_4 -->
            <div class="grids_of_4">
            <#if goods??>
                <#list goods as g>
                <#if g_index != 0 && ((g_index) % 4) == 0>
                    <div class="clearfix"></div>
                    </div>
                    <div class="grids_of_4">
                </#if>
                    <div class="grid1_of_4">
                        <div class="content_box">
                            <#if g.image??>
                                <a href="/good/${g.id}"><img src="/resources/images/${g.image.image_1}" class="img-responsive" alt=""/></a>
                            <#else>
                                <a href="/good/${g.id}"><img src="/resources/images/noImage.png" class="img-responsive" alt=""/></a>
                            </#if>
                            <h4><a href="/good/${g.id}"> ${g.name}</a></h4>
                            <div class="grid_1 simpleCart_shelfItem">
                                <div class="item_add"><span class="item_price"><h6>$${g.price}</h6></span></div>
                                <div class="item_add"><span class="item_price"><a id="addToCart" data-id="${g.id}" href="/cart">add to cart</a></span></div>
                                <div id="add_cart_${g.id}"></div>
                            </div>
                        </div>
                    </div>
                </#list>
                <#if (goods?size) % 4 != 0>
                    <div class="clearfix"></div>
                    </div>
                </#if>
            <#else>
            Извините, в данный момент товары по данной категории отсутсвуют.
            </div>
            </#if>
        </div>
        <div class="clearfix"></div>
        <!-- end content -->
    </div>
</div>
</#macro>
