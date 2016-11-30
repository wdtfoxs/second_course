<div class="content-left-top-brands">
    <h3>Categories</h3>
    <ul>
    <#if additionalCategory??>
        <#if currentCategory?? && currentCategory.name != "all">
            <li><a href="/catalog/${currentCategory.parent.name}">Назад к "${currentCategory.parent.name}"</a></li>
        </#if>
        <#list additionalCategory as c >
            <li><a href="/catalog/${c.name}">${c.name}</a></li>
        </#list>
    <#else >
        <#if currentCategory?? && currentCategory.name != "all">
            <li><a href="/catalog/${currentCategory.parent.name}">Назад к "${currentCategory.parent.name}"</a></li>
        <#else >
            <li><a href="/catalog/all">Назад к "all"</a></li>
        </#if>
    </#if>
    </ul>
</div>
<div class="content-left-top-grid">
    <div class="content-left-price-selection content-left-top-brands-prices">
        <h4>Select Price:</h4>
        <div class="price-selection-tree">
									<span class="col_checkbox">
										<input id="10" class="css-checkbox10" type="checkbox">
										<label class="normal"><i for="10" name="demo_lbl_10" class="css-label10"> </i>
                                            400</label>
									</span>
									<span class="col_checkbox">
										<input id="11" class="css-checkbox11" type="checkbox">
										<label class="active1"><i for="11" name="demo_lbl_11" class="css-label11"> </i>350</label>
									</span>
									<span class="col_checkbox">
										<input id="12" class="css-checkbox12" type="checkbox">
										<label class="normal"><i for="12" name="demo_lbl_12" class="css-label12"> </i>
                                            300</label>
									</span>
									<span class="col_checkbox">
										<input id="13" class="css-checkbox13" type="checkbox">
										<label class="normal"><i for="13" name="demo_lbl_13" class="css-label13"> </i>250</label>
									</span>
									<span class="col_checkbox">
										<input id="14" class="css-checkbox14" type="checkbox">
										<label class="normal"><i for="14" name="demo_lbl_14" class="css-label14"> </i>
                                            200</label>
									</span>
									<span class="col_checkbox">
										<input id="15" class="css-checkbox15" type="checkbox">
										<label class="normal"><i for="15" name="demo_lbl_15" class="css-label15"> </i>150</label>
									</span>
        </div>

    </div>
</div>