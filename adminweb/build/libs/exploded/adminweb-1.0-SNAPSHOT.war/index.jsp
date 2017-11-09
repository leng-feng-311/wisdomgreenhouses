<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>智慧移动大棚管理平台</title>
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="">
    <!-- Bootstrap Core CSS -->
    <link href="./static/css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <%--jquery--%>
    <link href="./static/css/jquery/animate.css" rel="stylesheet" type="text/css" media="all">
    <!-- Custom CSS -->
    <link href="./static/css/custom/style.css" rel="stylesheet" type="text/css">
    <!-- font CSS -->
    <!-- font-awesome icons -->
    <link href="./static/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->

    <!-- js-->
    <script src="./static/js/jquery/jquery-1.11.1.min.js"></script>
</head>
<style type="text/css">
    .cbp-spmenu-push div#page-wrapper {
        background-color: #FFFFFF;
    }

    .form-body {
        background-color: #ebebeb;
    }
</style>
<body class="cbp-spmenu-push cbp-spmenu-push-toright">
<div class="main-content">

    <div class=" sidebar" role="navigation">
        <div class="navbar-collapse"></div>
        <div class="sticky-header header-section ">
            <div>
                <div class="header-left">
                    <div class="logo"><a href="#" class="fl logo block mt20 ml50"><img
                            src="./static/images/logo/logo.png"></a></div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!-- main content start-->
        <div id="page-wrapper" style="min-height: 205px;">
            <div class="main-page">
                <div class="forms">
                    <div class="row">
                        <div class="col-md-6 validation-grids validation-grids-right">
                            <div class="widget-shadow " data-example-id="basic-forms">
                                <div class="form-title">
                                    <h4>登录</h4>
                                </div>
                                <div class="form-body">
                                    <form class="form-horizontal" action="./login/loginCheck.html" method="post">
                                        <div class="form-group">
                                            <label for="userName" class="col-sm-2 control-label">用户名</label>
                                            <div class="col-sm-9"><input type="text" class="form-control"
                                                                         name="userName"
                                                                         id="userName" placeholder=""></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="password" class="col-sm-2 control-label">密码</label>
                                            <div class="col-sm-9"><input type="password" class="form-control"
                                                                         name="password" id="password" placeholder="">
                                            </div>
                                        </div>
                                        <%--<div class="form-group">--%>
                                            <%--<div class="col-sm-offset-2 col-sm-10">--%>
                                                <%--<div class="checkbox">--%>
                                                    <%--<label> <input type="checkbox">记住密码</label>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                        <div class="col-sm-offset-2">
                                            <button type="submit" class="btn btn-default" onclick="return login()">登录
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div align="center">
                                <br/><br/><br/><br/><br/>
                                <h4>建议使用<a
                                        href="http://sw.bos.baidu.com/sw-search-sp/software/c3bb031659744/360aqllq_8.1.1.230.exe">360浏览器</a>、<a
                                        href="http://sw.bos.baidu.com/sw-search-sp/software/5cbc7a59a322c/ChromeStandalone_53.0.2785.143_Setup.exe">谷歌浏览器</a>或<a
                                        href="http://sw.bos.baidu.com/sw-search-sp/software/774ee5fe262e3/BOIE9_ZHCN_BO0085_WIN7.exe">IE9.0以上版本</a>
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- main content end-->


    <!--footer-->
    <div class="footer navbar-fixed-bottom">
        <div class="container">
            <span class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：宏锋信息科技有限公司<b>&nbsp;4006-612-966</b></span>
            <span class="pull-right">HONGFENG Group 版权所有</span>
        </div>
    </div>
    <!--//footer-->
</div>

<script type="application/javascript">
    function login() {
        var userName = $("#userName").val();
        if (userName == null || userName == "") {
            return false;
        }
        var password = $("#password").val();
        if (password == null || password == "") {
            return false;
        }
    }
</script>
</body>
</html>