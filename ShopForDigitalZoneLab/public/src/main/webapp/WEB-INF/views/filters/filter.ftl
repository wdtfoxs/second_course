<div class="w_sidebar">
    <br>
    <h3>filter by categories</h3>
    <section class="sky-form">
        <div class="row1 scroll-pane">
            <div class="col col-4">
                <#if additionalCategory??>
                    <#if currentCategory?? && currentCategory.name != "all">
                        <h5><a href="/catalog/${currentCategory.parent.name}">Назад к "${currentCategory.parent.name}"</a></h5>
                    </#if>
                    <#list additionalCategory as c >
                        <li><a href="/catalog/${c.name}">${c.name}</a></li>
                    </#list>
                <#else >
                    <#if currentCategory?? && currentCategory.name != "all">
                        <h5><a href="/catalog/${currentCategory.parent.name}">Назад к "${currentCategory.parent.name}"</a></h5>
                    <#else >
                        <h5><a href="/catalog/all">Назад к "all"</a></h5>
                    </#if>
                </#if>
            </div>
        </div>
    </section>
    <section class="sky-form">
        <h4>brand</h4>
        <div class="row1 scroll-pane">
            <div class="col col-4">
                <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>shree</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Anouk</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>biba</label>
            </div>
            <div class="col col-4">
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>vishud</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>amari</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>shree</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Anouk</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>biba</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>shree</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Anouk</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>biba</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>shree</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Anouk</label>
                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>biba</label>
            </div>
        </div>
    </section>
    <section class="sky-form">
        <h4>colour</h4>
        <ul class="w_nav2">
            <li><a class="color1" href="#"></a></li>
            <li><a class="color2" href="#"></a></li>
            <li><a class="color3" href="#"></a></li>
            <li><a class="color4" href="#"></a></li>
            <li><a class="color5" href="#"></a></li>
            <li><a class="color6" href="#"></a></li>
            <li><a class="color7" href="#"></a></li>
            <li><a class="color8" href="#"></a></li>
            <li><a class="color9" href="#"></a></li>
            <li><a class="color10" href="#"></a></li>
            <li><a class="color12" href="#"></a></li>
            <li><a class="color13" href="#"></a></li>
            <li><a class="color14" href="#"></a></li>
            <li><a class="color15" href="#"></a></li>
            <li><a class="color5" href="#"></a></li>
            <li><a class="color6" href="#"></a></li>
            <li><a class="color7" href="#"></a></li>
            <li><a class="color8" href="#"></a></li>
            <li><a class="color9" href="#"></a></li>
            <li><a class="color10" href="#"></a></li>
        </ul>
    </section>
    <section class="sky-form">
        <h4>discount</h4>
        <div class="row1 scroll-pane">
            <div class="col col-4">
                <label class="radio"><input type="radio" name="radio" checked=""><i></i>60 % and above</label>
                <label class="radio"><input type="radio" name="radio"><i></i>50 % and above</label>
                <label class="radio"><input type="radio" name="radio"><i></i>40 % and above</label>
            </div>
            <div class="col col-4">
                <label class="radio"><input type="radio" name="radio"><i></i>30 % and above</label>
                <label class="radio"><input type="radio" name="radio"><i></i>20 % and above</label>
                <label class="radio"><input type="radio" name="radio"><i></i>10 % and above</label>
            </div>
        </div>
    </section>
</div>
