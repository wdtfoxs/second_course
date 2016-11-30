<!-- start header menu -->
<ul class="megamenu skyblue">
    <li class="active grid"><a class="color1" href="/">Home</a></li>
    <#if listCategories??>
            <#list listCategories as category>
                <li class="grid"><a class="color${category_index+2}" href="/catalog/${category.name}">${category.name}</a></li>
             </#list>
    <#else >
        <li class="active grid"><a class="color8" href="">Категории товаров в обработке, скоро появятся</a></li>
    </#if>
</ul>