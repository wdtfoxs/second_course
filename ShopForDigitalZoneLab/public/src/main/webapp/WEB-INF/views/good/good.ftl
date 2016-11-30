<#include "../template/template.ftl">
<@mainTemplate title="Товар" scripts=["js/own/catalog.js"]/>
<#macro m_body>
    <#assign noImage = "noImage.png"/>
<div class="container">
    <div class="women_main">
        <!-- start content -->
        <div class="row single">
            <div class="col-md-9 det">
                <div class="single_left">
                    <div class="grid images_3_of_2">
                        <ul id="etalage">
                            <#if (good.image)??>
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image"
                                             src="/resources/images/${good.image.image_1!"noImage.png"}"
                                             class="img-responsive"/>
                                        <img class="etalage_source_image"
                                             src="/resources/images/${good.image.image_1!"noImage.png"}"
                                             class="img-responsive" title=""/>
                                    </a>
                                </li>
                                <li>
                                    <img class="etalage_thumb_image"
                                         src="/resources/images/${good.image.image_2!"noImage.png"}"
                                         class="img-responsive"/>
                                    <img class="etalage_source_image"
                                         src="/resources/images/${good.image.image_2!"noImage.png"}"
                                         class="img-responsive" title=""/>
                                </li>
                                <li>
                                    <img class="etalage_thumb_image"
                                         src="/resources/images/${good.image.image_3!"noImage.png"}"
                                         class="img-responsive"/>
                                    <img class="etalage_source_image"
                                         src="/resources/images/${good.image.image_3!"noImage.png"}"
                                         class="img-responsive"/>
                                </li>
                                <li>
                                    <img class="etalage_thumb_image"
                                         src="/resources/images/${good.image.image_4!"noImage.png"}"
                                         class="img-responsive"/>
                                    <img class="etalage_source_image"
                                         src="/resources/images/${good.image.image_4!"noImage.png"}"
                                         class="img-responsive"/>
                                </li>
                            <#else>
                                <#assign noImage = "noImage.png">
                                <#list 0..3 as i>
                                    <li>
                                        <img class="etalage_thumb_image" src="/resources/images/${noImage}"
                                             class="img-responsive"/>
                                        <img class="etalage_source_image" src="/resources/images/${noImage}"
                                             class="img-responsive"/>
                                    </li>
                                </#list>
                            </#if>

                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="desc1 span_3_of_2">
                        <h3>${good.name}</h3>
                        <span class="brand">Brand: <a href="#">Sed do eiusmod </a></span>
                        <br>
                        <span class="code">Description: ${good.description}</span>
                        <div class="price">
                            <span class="text">Price:</span>
                            <span class="price-new">$${good.price}</span>
                        </div>
                        <div class="det_nav1">
                            <h4>Select a size :</h4>
                            <div class=" sky-form col col-4">
                                <ul>
                                    <li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>L</label>
                                    </li>
                                    <li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>S</label>
                                    </li>
                                    <li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>M</label>
                                    </li>
                                    <li><label class="checkbox"><input type="checkbox" name="checkbox"><i></i>XL</label>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="btn_form">
                            <a id="addToCart" data-id="${good.id}" href="/cart">add to cart</a>
                            <div id="add_cart_${good.id}"></div>
                        </div>
                        <a href="#"><span>login to save in wishlist </span></a>

                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="single-bottom1">
                    <h6>Details</h6>
                    <p class="prod-desc">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
                        euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
                        quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
                        consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie
                        consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio
                        dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla
                        facilisi. Nam liber tempor cum soluta nobis eleifend option</p>
                </div>
                <div class="single-bottom2">
                    <h6>Related Products</h6>
                    <div class="product">
                        <div class="product-desc">
                            <div class="product-img">
                                <img src="/resources/images/w8.jpg" class="img-responsive " alt=""/>
                            </div>
                            <div class="prod1-desc">
                                <h5><a class="product_link" href="#">Excepteur sint</a></h5>
                                <p class="product_descr"> Vivamus ante lorem, eleifend nec interdum non, ullamcorper et
                                    arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
                                    inceptos himenaeos. </p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="product_price">
                            <span class="price-access">$597.51</span>
                            <button class="button1"><span>Add to cart</span></button>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="product">
                        <div class="product-desc">
                            <div class="product-img">
                                <img src="/resources/images/w10.jpg" class="img-responsive " alt=""/>
                            </div>
                            <div class="prod1-desc">
                                <h5><a class="product_link" href="#">Excepteur sint</a></h5>
                                <p class="product_descr"> Vivamus ante lorem, eleifend nec interdum non, ullamcorper et
                                    arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
                                    inceptos himenaeos. </p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="product_price">
                            <span class="price-access">$597.51</span>
                            <button class="button1"><span>Add to cart</span></button>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <#include "../filters/filter.ftl"/>
            </div>
            <div class="clearfix"></div>
        </div>
        <!-- end content -->
    </div>
</div>
</#macro>
