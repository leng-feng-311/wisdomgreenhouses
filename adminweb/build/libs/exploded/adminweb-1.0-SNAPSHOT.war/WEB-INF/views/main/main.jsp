<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title><spring:message code="sys.tital"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%-- 在IE运行最新的渲染模式 --%>
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <%-- 初始化移动浏览显示 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->
    <link href="/static/css/bootstrap/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="/static/css/custom/style.css" rel='stylesheet' type='text/css'/>
    <link href="../static/css/page/page.css" rel='stylesheet' type='text/css'/>
    <!-- font CSS -->
    <!-- font-awesome icons -->
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome icons -->
    <link href="/static/css/animate.css" rel="stylesheet" type="text/css" media="all">
    <!-- js-->
    <script src="/static/js/jquery/jquery-1.11.1.min.js"></script>
    <script src="/static/js/modernizr.custom.js"></script>
    <script src="/static/js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <script src="/static/js/metisMenu.min.js"></script>
    <script>
        $(function () {
            $('#menu').metisMenu();
        });
    </script>
    <script src="/static/js/custom.js"></script>
    <script src="/static/js/showRight.js"></script>
</head>

<body class="cbp-spmenu-push">
<div class="main-content">
    <div class='sidebar' role='navigation'>
        <div class='navbar-collapse'>
            <jsp:include page="nav.jsp"></jsp:include>
            <jsp:include page="header.jsp"></jsp:include>
            <!-- main content start-->
            <div id="page-wrapper" style="min-height: 453px;">
                <div class="main-page">
                    <%--<h3 class="title1">您现在的位置是：<a href="#">首页</a></h3>--%>

                    <!-- 载入左侧菜单指向的jsp（或html等）页面内容 -->
                    <div id="content">
                        <h4>
                            <strong><spring:message code="welcome"/></strong>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</div>--%>
<%--</div>--%>
<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
<%--</div>--%>

<%--<script type="text/javascript">--%>

    <%--/*--%>
     <%--* 对选中的标签激活active状态，对先前处于active状态但之后未被选中的标签取消active--%>
     <%--* （实现左侧菜单中的标签点击后变色的效果）--%>
     <%--*/--%>
    <%--$(document).ready(function () {--%>
        <%--$('ul.nav > li > a').click(function (e) {--%>
            <%--//e.preventDefault();    加上这句则导航的<a>标签会失效--%>
            <%--$('ul.nav > li >a').removeClass('active');--%>
            <%--$(this).addClass('active');--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>