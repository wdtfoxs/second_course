<#include "template/template.ftl">
<@mainTemplate title="Товар" scripts=["js/own/catalog.js"]/>
<#macro m_body>
<div class="content details-page">
    <!---start-product-details--->
    <div class="product-details">
        <div class="wrap">
            <ul class="product-head">
                <li><a href="/">Home</a></li>
                <div class="clear"></div>
            </ul>
            <!----details-product-slider--->
            <!-- Include the Etalage files -->
            <link rel="stylesheet" href="/resources/css/etalage.css">
            <script src="/resources/js/jquery.etalage.min.js"></script>
            <!-- Include the Etalage files -->
            <script>
                jQuery(document).ready(function ($) {

                    $('#etalage').etalage({
                        thumb_image_width: 300,
                        thumb_image_height: 400,
                        source_image_width: 900,
                        source_image_height: 1000,
                        show_hint: true,
                        click_callback: function (image_anchor, instance_id) {
                            alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                        }
                    });
                    // This is for the dropdown list example:
                    $('.dropdownlist').change(function () {
                        etalage_show($(this).find('option:selected').attr('class'));
                    });

                });
            </script>
            <!----//details-product-slider--->
            <div class="details-left">
                <div class="details-left-slider">
                    <ul id="etalage">
                        <#assign noImage = "noImage.png">
                        <#if (good.image.image_1)??>
                            <#assign img = good.image.image_1>
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${img}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${img}"/>
                            </li>
                        <#else >
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${noImage}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${noImage}"/>
                            </li>
                        </#if >
                        <#if (good.image.image_2)??>
                            <#assign img = good.image.image_2>
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${img}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${img}"/>
                            </li>
                        <#else >
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${noImage}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${noImage}"/>
                            </li>
                        </#if >
                        <#if (good.image.image_3)??>
                            <#assign img = good.image.image_3>
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${img}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${img}"/>
                            </li>
                        <#else >
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${noImage}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${noImage}"/>
                            </li>
                        </#if >
                        <#if (good.image.image_4)??>
                            <#assign img = good.image.image_4>
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${img}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${img}"/>
                            </li>
                        <#else >
                            <li>
                                <img class="etalage_thumb_image" src="/resources/images/product-slide/${noImage}"/>
                                <img class="etalage_source_image" src="/resources/images/product-slide/${noImage}"/>
                            </li>
                        </#if >
                    </ul>
                </div>
                <div class="details-left-info">
                    <div class="details-right-head">
                        <h1>${good.name}</h1>
                        <ul class="pro-rate">
                            <li><a class="product-rate" href="#"> <label> </label></a> <span> </span></li>
                            <li><a href="#">0 Review(s) Add Review</a></li>
                        </ul>
                        <p class="product-detail-info">${good.description}</p>
                        <a class="learn-more" href="#"><h3>MORE DETAILS</h3></a>
                        <div class="product-more-details">
                            <ul class="price-avl">
                                <li class="price"><span>$${(good.price)+13}</span><label>$${good.price}</label></li>
                                <li class="stock"><i>In stock</i></li>
                                <div class="clear"></div>
                            </ul>
                            <ul class="product-colors">
                                <h3>available Colors ::</h3>
                                <li><a class="color1" href="#"><span> </span></a></li>
                                <li><a class="color2" href="#"><span> </span></a></li>
                                <li><a class="color3" href="#"><span> </span></a></li>
                                <li><a class="color4" href="#"><span> </span></a></li>
                                <li><a class="color5" href="#"><span> </span></a></li>
                                <li><a class="color6" href="#"><span> </span></a></li>
                                <li><a class="color7" href="#"><span> </span></a></li>
                                <li><a class="color8" href="#"><span> </span></a></li>
                                <div class="clear"></div>
                            </ul>
                            <ul class="prosuct-qty">
                                <span>Quantity:</span>
                                <select>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                </select>
                            </ul>
                            <input type="button" value="add to cart" data-id="${good.id}" id="addToCart"/>
                            <br>
                            <div id="add_cart_${good.id}"></div>
                            <br>
                            <ul class="product-share">
                                <h3>All so Share On</h3>
                                <ul>
                                    <li><a class="share-face" href="#"><span> </span> </a></li>
                                    <li><a class="share-twitter" href="#"><span> </span> </a></li>
                                    <li><a class="share-google" href="#"><span> </span> </a></li>
                                    <li><a class="share-rss" href="#"><span> </span> </a></li>
                                    <div class="clear"></div>
                                </ul>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="details-right">
                <a href="/catalog/all">SEE MORE</a>
            </div>
            <div class="clear"></div>
        </div>
        <!----product-rewies---->
        <div class="clear"></div>
        <!--//vertical Tabs-->
        <!----//product-rewies---->
        <!---//End-product-details--->
    </div>
</div>
<!---- start-bottom-grids---->
</#macro>
