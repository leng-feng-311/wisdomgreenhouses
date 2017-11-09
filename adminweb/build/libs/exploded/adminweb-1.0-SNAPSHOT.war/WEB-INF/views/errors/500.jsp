<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>智慧移动大棚管理平台</title>
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->
    <link href="../../../static/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="../../../static/css/custom/style.css" rel="stylesheet" type="text/css">
    <!-- font CSS -->
    <!-- font-awesome icons -->
    <link href="../../../static/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->
    <!-- js-->
    <script src="../../../static/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="../../../static/js/modernizr.custom.js"></script>
    <!--animate-->
    <link href="../../../static/css/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="../../../static/js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <!--//end-animate-->
    <!-- Metis Menu -->
    <script src="../../../static/js/metisMenu.min.js"></script>
    <script src="../../../static/js/custom.js"></script>
    <!--//Metis Menu -->
</head>
<body class="cbp-spmenu-push cbp-spmenu-push-toright">
<div class="main-content">

    <div class=" sidebar" role="navigation">
        <div class="navbar-collapse"></div>
        <div class="sticky-header header-section ">
            <div>
                <div class="header-left">
                    <div class="logo"><a href="#" class="fl logo block mt20 ml50"><img
                            src="../../../static/images/logo/logo.png"></a></div>
                    <div class="clearfix"></div>
                </div>
                <div class="header-right">
                    <div class='profile_details'>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- main content start-->
        <div id="page-wrapper" style="min-height: 205px;">
            <div class="main-page">

                <div class="forms">

                    <div class="row">
                        <div class="col-md-6 validation-grids validation-grids-right">
                            <div class="widget-shadow " data-example-id="basic-forms">
                               ${errormsg}
                                <a href="./../" ><span
                                        class="glyphicon glyphicon-log-out"></span>重新登录请点击这里</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- main content end-->


    <!--footer-->
    <div class="footer">
        <div class="container">
            <span class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：宏锋信息科技有限公司<b>&nbsp;4006-612-966</b></span>
            <span class="pull-right">HONGFENG Group 版权所有</span>
        </div>
    </div>
    <!--//footer-->
</div>
</body>
</html>