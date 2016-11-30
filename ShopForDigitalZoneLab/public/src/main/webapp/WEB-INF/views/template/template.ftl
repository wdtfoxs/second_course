<#macro mainTemplate title="HomePage" styles=[] scripts=[] >
<!DOCTYPE HTML>
<html>
<head>
    <title>${title}</title>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (necessary JavaScript plugins) -->
    <script type='text/javascript' src="/resources/js/jquery-2.2.3.js"></script>
    <!-- Custom Theme files -->
    <link href="/resources/css/style.css" rel='stylesheet' type='text/css'/>
    <!-- Custom Theme files -->
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
    <#if title == "Товар" >
        <link href="/resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all"/>
        <link rel="stylesheet" href="/resources/css/etalage.css">
        <script type="text/javascript" src="/resources/js/megamenu.js"></script>
        <script>$(document).ready(function () {
            $(".megamenu").megamenu();
        });</script>
        <script src="/resources/js/jquery.etalage.min.js"></script>
        <script src="/resources/js/menu_jquery.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 300,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>
    <#else>
        <link href="/resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="/resources/js/megamenu.js"></script>
        <script>$(document).ready(function () {
            $(".megamenu").megamenu();
        });</script>
        <script src="/resources/js/menu_jquery.js"></script>
        <script src="/resources/js/simpleCart.min.js"></script>
    </#if>
    <#list scripts as js>
        <script src="/resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
    <#include "components/header.ftl"/>
<@m_body/>
<#include "components/footer.ftl"/>
</body>
</html>
</#macro>