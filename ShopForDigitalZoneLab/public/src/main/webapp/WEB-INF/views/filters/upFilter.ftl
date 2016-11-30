<div class="women">
    <a href="#"><h4>Enthecwear - <span>${goodsSize!0}</span></h4></a>
    <ul class="w_nav">
        <#if currentCategory??>
        <li>Sort : </li>
        <li><a class="active" href="#">popular</a></li> |
        <li><a href="#">new </a></li> |
        <li><a href="/catalog/${currentCategory.name}?sort=high">price: High Low</a></li> |
        <li><a href="/catalog/${currentCategory.name}?sort=low">price: Low High </a></li>
        </#if>
        <div class="clear"></div>
    </ul>
    <div class="clearfix"></div>
</div>