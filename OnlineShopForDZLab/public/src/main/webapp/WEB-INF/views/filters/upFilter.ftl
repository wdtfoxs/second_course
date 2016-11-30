<#--<div class="women">-->
<#--<a href="#"><h4>Enthecwear - <span>${goodsSize!0}</span></h4></a>-->
<#--<ul class="w_nav">-->
<#--<#if currentCategory??>-->
<#--<li>Sort : </li>-->
<#--<li><a class="active" href="#">popular</a></li> |-->
<#--<li><a href="#">new </a></li> |-->
<#--<li><a href="/catalog/${currentCategory}?sort=high">price: High Low</a></li> |-->
<#--<li><a href="/catalog/${currentCategory}?sort=low">price: Low High </a></li>-->
<#--</#if>-->
<#--<div class="clear"></div>-->
<#--</ul>-->
<#--<div class="clearfix"></div>-->
<#--</div>-->

<#--/////////////////////////////////////////////////////////////////////////////////////////////////-->

<div class="product-box-head">
    <div class="product-box-head-left">
        <h3>Products <span>(${goodsSize!0})</span></h3>
    </div>
    <div class="product-box-head-right">
        <ul>
        <#if currentCategory??>
            <li><span>Sort ::</span><a href="#"> </a></li>
            <li><label> </label> <a href="#"> Popular</a></li>
            <li><label> </label> <a href="#"> New</a></li>
            <li><label> </label> <a href="#"> Discount</a></li>
            <li><span>Price ::</span><a href="/catalog/${currentCategory.name}?sort=low">Low High</a> or <a
                    href="${currentCategory.name}?sort=high">High Low</a></li>

        </#if>
        </ul>
    </div>
    <div class="clear"></div>
</div>