<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/morinda-tags" %>
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
            <jsp:include page="../main/nav.jsp"></jsp:include>
            <jsp:include page="../main/header.jsp"></jsp:include>
            <!-- main content start-->
            <div id="page-wrapper" style="min-height: 453px;">
                <div class="main-page">
                    <div id="content">
                        <div class="forms">
                            <div class="widget-shadow " data-example-id="basic-forms">
                                <%--搜索条件开始--%>
                                <div class="form-body">
                                    <form class="form-horizontal" action="../role/addFirMenu">
                                        <div class="form-group  col-lg-4">
                                            <label for="roleMenuName" class="col-sm-3 control-label">菜单名称</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder="" id="roleMenuName"
                                                       name="roleMenuName">
                                            </div>
                                        </div>
                                        <div class="form-group  col-lg-4">
                                            <label for="roleMenuDesc" class="col-sm-3 control-label">菜单描述</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder="" id="roleMenuDesc"
                                                       name="roleMenuDesc">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary" for="propertySearch">搜索</button>
                                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                                data-target="#myModal">添加菜单
                                        </button>
                                    </form>
                                </div>
                                <%--搜索条件结束--%>
                            </div>
                        </div>
                        <div class="table-responsive bs-example widget-shadow" style="border-top: 1px dashed #ccc;
    padding-top: 16px;">

                            <table width="100%" class="tableStyle" style="table-layout: fixed;">
                                <thead>
                                <tr>
                                    <th width="3%">序号</th>
                                    <th width="8%">菜单级别</th>
                                    <th width="8%">菜单名称</th>
                                    <th width="7%">访问路径</th>
                                    <th width="7%">菜单描述</th>
                                    <th width="5%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${menuInfoList}" var="menu" varStatus="status">
                                    <tr>
                                        <td height="40px" style="text-align: center">
                                            <b>${(webPage.pageIndex-1)*20+status.index+1}</b>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${menu.menuLevel}">
                                            <c:if test="${menu.menuLevel eq '1'}">一级</c:if>
                                            <c:if test="${menu.menuLevel eq '2'}">二级</c:if>
                                            <c:if test="${menu.menuLevel eq '3'}">三级</c:if>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${menu.menuName}">
                                                ${menu.menuName}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${menu.menuUrl}">
                                                ${menu.menuUrl}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${menu.menuDesc}">
                                                ${menu.menuDesc}
                                        </td>
                                        <td height="40px">
                                            <a href="../role/menuSecManage?parId=${menu.menuId}" class="a3"><span
                                                    class="span1">查看二级菜单</span></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <m:pager pageIndex="${webPage.pageIndex}"
                                     pageSize="${webPage.pageSize}"
                                     recordCount="${webPage.recordCount}"
                                     submitUrl="${pageContext.request.contextPath }/role/menuManage.html?pageIndex={0}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</div>--%>
<%--</div>--%>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content" name="form" id="form" action="../menu/addFirMenu">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel2">添加一级菜单</h4>
            </div>
            <div class="modal-body">

                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">菜单名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="menuName" name="menuName">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">菜单排序</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="menuOrder" name="menuOrder">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">菜单描述</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="menuDesc" name="menuDesc">
                    </div>
                </div>
                <div class="modal-footer" style="border: none">
                    <button type="submit" class="btn btn-primary">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>

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