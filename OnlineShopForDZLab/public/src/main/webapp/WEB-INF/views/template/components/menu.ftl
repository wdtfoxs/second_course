<div class="header-bottom">
    <div class="wrap">
        <!-- start header menu -->
        <ul class="megamenu skyblue">
        <#if listCategories??>
            <#list listCategories as category>
                <li class="grid"><a class="color8" href="/catalog/${category.name}">${category.name}</a></li>
            </#list>
        <#else >
            <li class="active grid"><a class="color8" href="">Категории товаров в обработке, скоро появятся</a></li>
        </#if>
        </ul>
    </div>
</div>