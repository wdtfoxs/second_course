<#include "template/template.ftl"/>
<@mainTemplate title="Главная"/>
<#macro m_body>
<div class="img-slider">
    <div class="wrap">
        <ul id="jquery-demo">
            <li>
                <a href="/good/1">
                    <img src="/resources/images/slide-1.jpg" alt="" />
                </a>
                <div class="slider-detils">
                    <h3>MENS FOOT BALL <label>BOOTS</label></h3>
                    <span>Stay true to your team all day, every day, game day.</span>
                    <a class="slide-btn" href="/good/1"> Shop Now</a>
                </div>
            </li>
            <li>
                <a href="/good/2">
                    <img src="/resources/images/slide-4.jpg" alt="" />
                </a>
                <div class="slider-detils">
                    <h3>MENS FOOT BALL <label>BOOTS</label></h3>
                    <span>Stay true to your team all day, every day, game day.</span>
                    <a class="slide-btn" href="/good/2"> Shop Now</a>
                </div>
            </li>
            <li>
                <a href="/good/3">
                    <img src="/resources/images/slide-1.jpg" alt="" />
                </a>
                <div class="slider-detils">
                    <h3>MENS FOOT BALL <label>BOOTS</label></h3>
                    <span>Stay true to your team all day, every day, game day.</span>
                    <a class="slide-btn" href="/good/3"> Shop Now</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="clear"> </div>
<!----//End-image-slider---->
<!--- start-content---->
<div class="content">
    <div class="wrap">
        <div class="content-left">
            <div class="content-left-top-grid">
                <div class="content-left-price-selection">
                    <h4>Select Price:</h4>
                    <div class="price-selection-tree">
									<span class="col_checkbox">
										<input id="10" class="css-checkbox10" type="checkbox">
										<label class="normal"><i for="10" name="demo_lbl_10"  class="css-label10"> </i> 400</label>
									</span>
									<span class="col_checkbox">
										<input id="11" class="css-checkbox11" type="checkbox">
										<label class="active1"><i for="11" name="demo_lbl_11"  class="css-label11"> </i>350</label>
									</span>
									<span class="col_checkbox">
										<input id="12" class="css-checkbox12" type="checkbox">
										<label class="normal"><i for="12" name="demo_lbl_12"  class="css-label12"> </i> 300</label>
									</span>
									<span class="col_checkbox">
										<input id="13" class="css-checkbox13" type="checkbox">
										<label class="normal"><i for="13" name="demo_lbl_13"  class="css-label13"> </i>250</label>
									</span>
									<span class="col_checkbox">
										<input id="14" class="css-checkbox14" type="checkbox">
										<label class="normal"><i for="14" name="demo_lbl_14"  class="css-label14"> </i> 200</label>
									</span>
									<span class="col_checkbox">
										<input id="15" class="css-checkbox15" type="checkbox">
										<label class="normal"><i for="15" name="demo_lbl_15"  class="css-label15"> </i>150</label>
									</span>
                    </div>
                </div>
            </div>
            <div class="content-left-bottom-grid">
                <h4>Boys Football:</h4>
                <div class="content-left-bottom-grids">
                    <div class="content-left-bottom-grid1">
                        <img src="/resources/images/foot-ball.jpg" title="football" />
                        <h5><a href="#">Nike Strike PL Hi-Vis</a></h5>
                        <span> Football</span>
                        <label>&#163; 375</label>
                    </div>
                    <div class="content-left-bottom-grid1">
                        <img src="/resources/images/jarse.jpg" title="jarse" />
                        <h5><a href="#">Nike Strike PL Hi-Vis</a></h5>
                        <span> Football</span>
                        <label>&#163; 375</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-right">
            <div class="product-grids">
                <!--- start-rate---->
                <script src="/resources/js/jstarbox.js"></script>
                <link rel="stylesheet" href="/resources/css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
                <script type="text/javascript">
                    jQuery(function() {
                        jQuery('.starbox').each(function() {
                            var starbox = jQuery(this);
                            starbox.starbox({
                                average: starbox.attr('data-start-value'),
                                changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                                ghosting: starbox.hasClass('ghosting'),
                                autoUpdateAverage: starbox.hasClass('autoupdate'),
                                buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                                stars: starbox.attr('data-star-count') || 5
                            }).bind('starbox-value-changed', function(event, value) {
                                if(starbox.hasClass('random')) {
                                    var val = Math.random();
                                    starbox.next().text(' '+val);
                                    return val;
                                }
                            })
                        });
                    });
                </script>
                <!---//End-rate---->
                <!---caption-script---->
                <!---//caption-script---->
                <div class="product-grid fade">
                    <div class="product-grid-head">
                        <ul class="grid-social">
                            <li><a class="facebook" href="#"><span> </span></a></li>
                            <li><a class="twitter" href="#"><span> </span></a></li>
                            <li><a class="googlep" href="#"><span> </span></a></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="block">
                            <div class="starbox small ghosting"> </div> <span> (46)</span>
                        </div>
                    </div>
                    <div class="product-pic">
                        <a href="/good/2"><img src="/resources/images/product2.jpg" title="product-name" /></a>
                        <p>
                            <a href="/good/2"><small>Nike</small> HYPERVENOM <small>Phantom</small> FG</a>
                            <span>Men's Firm-Ground Football Boot</span>
                        </p>
                    </div>
                    <div class="product-info">
                        <div class="product-info-cust">
                            <a href="/good/2">Details</a>
                        </div>
                        <div class="product-info-price">
                            <a href="/good/2">&#163; 380</a>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="more-product-info">
                        <span> </span>
                    </div>
                </div>
                <div class="product-grid fade">
                    <div class="product-grid-head">
                        <ul class="grid-social">
                            <li><a class="facebook" href="#"><span> </span></a></li>
                            <li><a class="twitter" href="#"><span> </span></a></li>
                            <li><a class="googlep" href="#"><span> </span></a></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="block">
                            <div class="starbox small ghosting"> </div> <span> (46)</span>
                        </div>
                    </div>
                    <div class="product-pic">
                        <a href="/good/1"><img src="/resources/images/product1.jpg" title="product-name" /></a>
                        <p>
                            <a href="/good/1"><small>Nike</small> HYPERVENOM <small>Phantom</small> FG</a>
                            <span>Men's Firm-Ground Football Boot</span>
                        </p>
                    </div>
                    <div class="product-info">
                        <div class="product-info-cust">
                            <a href="/good/1">Details</a>
                        </div>
                        <div class="product-info-price">
                            <a href="/good/1">&#163; 375</a>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="more-product-info">
                        <span> </span>
                    </div>
                </div>
                <div class="product-grid fade last-grid">
                    <div class="product-grid-head">
                        <ul class="grid-social">
                            <li><a class="facebook" href="#"><span> </span></a></li>
                            <li><a class="twitter" href="#"><span> </span></a></li>
                            <li><a class="googlep" href="#"><span> </span></a></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="block">
                            <div class="starbox small ghosting"> </div> <span> (46)</span>
                        </div>
                    </div>
                    <div class="product-pic">
                        <a href="/good/3"><img src="/resources/images/product3.jpg" title="product-name" /></a>
                        <p>
                            <a href="/good/3"><small>Nike</small> HYPERVENOM <small>Phantom</small> FG</a>
                            <span>Men's Firm-Ground Football Boot</span>
                        </p>
                    </div>
                    <div class="product-info">
                        <div class="product-info-cust">
                            <a href="/good/3">Details</a>
                        </div>
                        <div class="product-info-price">
                            <a href="/good/3">&#163; 350</a>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="more-product-info">
                        <span> </span>
                    </div>
                </div>
                <div class="product-grid fade">
                    <div class="product-grid-head">
                        <ul class="grid-social">
                            <li><a class="facebook" href="#"><span> </span></a></li>
                            <li><a class="twitter" href="#"><span> </span></a></li>
                            <li><a class="googlep" href="#"><span> </span></a></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="block">
                            <div class="starbox small ghosting"> </div> <span> (46)</span>
                        </div>
                    </div>
                    <div class="product-pic">
                        <a href="/good/4"><img src="/resources/images/product4.jpg" title="product-name" /></a>
                        <p>
                            <a href="/good/4"><small>Nike</small> HYPERVENOM <small>Phantom</small> FG</a>
                            <span>Men's Firm-Ground Football Boot</span>
                        </p>
                    </div>
                    <div class="product-info">
                        <div class="product-info-cust">
                            <a href="/good/4">Details</a>
                        </div>
                        <div class="product-info-price">
                            <a href="/good/4">&#163; 370</a>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="more-product-info">
                        <span> </span>
                    </div>
                </div>
                <div class="product-grid fade">
                    <div class="product-grid-head">
                        <ul class="grid-social">
                            <li><a class="facebook" href="#"><span> </span></a></li>
                            <li><a class="twitter" href="#"><span> </span></a></li>
                            <li><a class="googlep" href="#"><span> </span></a></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="block">
                            <div class="starbox small ghosting"> </div> <span> (46)</span>
                        </div>
                    </div>
                    <div class="product-pic">
                        <a href="/good/5"><img src="/resources/images/product5.jpg" title="product-name" /></a>
                        <p>
                            <a href="/good/5"><small>Nike</small> HYPERVENOM <small>Phantom</small> FG</a>
                            <span>Men's Firm-Ground Football Boot</span>
                        </p>
                    </div>
                    <div class="product-info">
                        <div class="product-info-cust">
                            <a href="/good/5">Details</a>
                        </div>
                        <div class="product-info-price">
                            <a href="/good/5">&#163; 355</a>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="more-product-info">
                        <span> </span>
                    </div>
                </div>
                <div class="product-grid fade last-grid">
                    <div class="product-grid-head">
                        <ul class="grid-social">
                            <li><a class="facebook" href="#"><span> </span></a></li>
                            <li><a class="twitter" href="#"><span> </span></a></li>
                            <li><a class="googlep" href="#"><span> </span></a></li>
                            <div class="clear"> </div>
                        </ul>
                        <div class="block">
                            <div class="starbox small ghosting"> </div> <span> (46)</span>
                        </div>
                    </div>
                    <div class="product-pic">
                        <a href="/good/6"><img src="/resources/images/product6.jpg" title="product-name" /></a>
                        <p>
                            <a href="/good/6"><small>Nike</small> HYPERVENOM <small>Phantom</small> FG</a>
                            <span>Men's Firm-Ground Football Boot</span>
                        </p>
                    </div>
                    <div class="product-info">
                        <div class="product-info-cust">
                            <a href="/good/6">Details</a>
                        </div>
                        <div class="product-info-price">
                            <a href="/good/6">&#163; 390</a>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="more-product-info">
                        <span> </span>
                    </div>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <div class="clear"> </div>
    </div>
</div>
</#macro>