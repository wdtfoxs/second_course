<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<!---start-wrap---->
<!---start-header---->
<div class="header">
    <div class="top-header">
        <div class="wrap">
            <div class="top-header-left">
                <ul>
                    <!---cart-tonggle-script---->
                    <script type="text/javascript">
                        $(function () {
                            var $cart = $('#cart');
                            $('#clickme').click(function (e) {
                                e.stopPropagation();
                                if ($cart.is(":hidden")) {
                                    $cart.slideDown("slow");
                                } else {
                                    $cart.slideUp("slow");
                                }
                            });
                            $(document.body).click(function () {
                                if ($cart.not(":hidden")) {
                                    $cart.slideUp("slow");
                                }
                            });
                        });
                    </script>
                    <!---//cart-tonggle-script---->
                    <li><a class="cart" href="/cart"><span id="clickme"> </span></a></li>
                    <!---start-cart-bag---->
                    <!---start-cart-bag---->
                    <li><a class="info" href="#"><span> </span></a></li>
                </ul>
            </div>
            <div class="top-header-center">
                <div class="top-header-center-alert-left">
                    <h3>FREE DELIVERY</h3>
                </div>
                <div class="top-header-center-alert-right">
                    <div class="vticker">
                        <ul>
                            <li>Applies to orders of $50 or more. <label>Returns are always free.</label></li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
            <div class="top-header-right">
                <ul>
                    <li><a href="/login">Login</a><span> </span></li>
                    <li><a href="/reg">Join</a></li>
                </ul>
            </div>
        </@sec.authorize>
        <@sec.authorize access="isAuthenticated()">
            <div class="top-header-right">
                <ul>
                    <li><a href="/logout">Logout</a><span> </span></li>
                    <li><a href="/cabinet">Hi, <@sec.authentication property="principal.user.name"/>!</a></li>
                </ul>
            </div>
        </@sec.authorize>

            <div class="clear"></div>
        </div>
    </div>
    <!----start-mid-head---->
    <div class="mid-header">
        <div class="wrap">
            <div class="mid-grid-left">
                <form>
                    <input type="text" placeholder="What Are You Looking for?"/>
                </form>
            </div>
            <div class="mid-grid-right">
                <a class="logo" href="/"><span> </span></a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!----//End-mid-head---->
    <!----start-bottom-header---->
<#include "menu.ftl">
</div>