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
                                    <form class="form-horizontal" action="../user/getUserInfo">
                                        <div class="form-group  col-lg-4">
                                            <label for="userRealName" class="col-sm-3 control-label">用户姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder=""
                                                       id="userRealNames"
                                                       name="userRealName">
                                            </div>
                                        </div>
                                        <div class="form-group  col-lg-4">
                                            <label for="userName" class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder="" id="userNames"
                                                       name="userName">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary" for="propertySearch">搜索</button>
                                        <button type="button" class="btn btn-primary" onclick="openAddModel()">添加用戶
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
                                    <th width="8%">用户名</th>
                                    <th width="8%">用户姓名</th>
                                    <th width="7%">用户性别</th>
                                    <th width="7%">用户手机</th>
                                    <th width="7%">用户邮箱</th>
                                    <th width="7%">用户生日</th>
                                    <th width="5%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userInfoList}" var="user" varStatus="status">
                                    <tr>
                                        <td height="40px" style="text-align: center">
                                            <b>${(webPage.pageIndex-1)*20+status.index+1}</b>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${user.userName}">
                                                ${user.userName}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${user.userRealName}">
                                                ${user.userRealName}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${user.userSex}">
                                            <c:if test="${user.userSex == 1}">男</c:if>
                                            <c:if test="${user.userSex == 2}">女</c:if>
                                            <c:if test="${user.userSex == 3}">保密</c:if>
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${user.userPhone}">
                                                ${user.userPhone}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${user.userEmail}">
                                                ${user.userEmail}
                                        </td>
                                        <td height="40px" class="ellipsis message-title" title="${user.userBirthday}">
                                                ${user.userBirthday}
                                        </td>
                                        <td height="40px">
                                            <a href="javascript:openUpdateModal('${user.userId}')" class="a3"><span
                                                    class="span1">编辑</span></a>
                                            <a href="../user/deleteUserInfo?userId=${user.userId}" class="a3"><span
                                                    class="span1">删除</span></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <m:pager pageIndex="${webPage.pageIndex}"
                                     pageSize="${webPage.pageSize}"
                                     recordCount="${webPage.recordCount}"
                                     submitUrl="${pageContext.request.contextPath }/user/getUserInfo?pageIndex={0}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content" name="form" id="form" action="../user/addUserInfo">
            <input type="hidden" name="userId" id="userId">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel2"></h4>
            </div>
            <div class="modal-body">

                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="userName" name="userName"
                               value="${updateUserInfo.userName}">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">真实姓名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="userRealName" name="userRealName"
                               value="${updateUserInfo.userRealName}">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">手机号</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="userPhone" name="userPhone"
                               value="${updateUserInfo.userPhone}">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">
                        <label class="btn btn-primary">
                            <input type="radio" name="userSex" id="userSex1" autocomplete="off" value="1">男
                            <%--<c:if test="${updateUserInfo.userSex == 1}">checked</c:if>>男--%>
                            <%--<input type="number" class="form-control" id="userSex" name="userSex" maxlength="12" value="${updateUserInfo.userSex}">--%>
                        </label>
                        <label class="btn btn-primary">
                            <input type="radio" name="userSex" id="userSex2" autocomplete="off" value="2">女
                            <%--<c:if test="${updateUserInfo.userSex == 2}">checked</c:if>>女--%>
                        </label>
                        <label class="btn btn-primary">
                            <input type="radio" name="userSex" id="userSex3" autocomplete="off" value="3">保密
                            <%--<c:if test="${updateUserInfo.userSex == 3}">checked</c:if>>保密--%>
                        </label>
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">用户生日</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="userBirthday" name="userBirthday"
                               value="${updateUserInfo.userBirthday}">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">用户邮箱</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="userEmail" name="userEmail">
                    </div>
                </div>
                <div class="form-group  col-lg-12">
                    <label class="col-sm-2 control-label">用户备注</label>
                    <div class="col-sm-6">
                        <textarea type="text" class="form-control" id="userRemark" name="userRemark"></textarea>
                    </div>
                </div>
                <div class="modal-footer" style="border: none">
                    <button type="submit" class="btn btn-primary" onclick="return addOrUpdateUser()">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- main content end-->
<%@ include file="../main/foolter.jsp" %>
<script type="application/javascript">
    function addOrUpdateUser() {
        var userName = $("#userName").val();
        if (userName == null || userName == "" || userName == undefined) {
            alert("用户名为空");
            return false;
        }
        var userPhone = $("#userPhone").val();
        if (userPhone == null || userPhone == "" || userPhone == undefined) {
            alert("联系方式为空");
            return false;
        }
        var reg = /^1[3|4|5|7|8][0-9]{9}$/;
        if (!reg.test(userPhone)) {
            alert("手机号不正确");
            return false;
        }
    }
    function init() {
        $("#userId").val();
        $("#userName").val();
        $("#userRealName").val();
        $("#userPhone").val();
        $("#userBirthday").val();
        $("#userSex1").attr("checked", "checked");
        $("#userEmail").val();
        $("#userRemark").val();
    }
    function openAddModel() {
        init();
        $("#myModalLabel2").html("新增用户信息");
        $("#myModal").modal({
            backdrop: false,
            show: true
        });
    }
    function openUpdateModal(userId) {
        $.ajax({
            url: "../user/getUserInfoById?userId=" + userId,
            type: "get",
            async: false,
            dataType: "json",
            success: function (result) {
                console.log(result);
                <!-- 获取返回代码 -->
                if (result.data != null) {
                    var userInfo = result.data;
                    $("#userId").val(userInfo.userId);
                    $("#userName").val(userInfo.userName);
                    $("#userRealName").val(userInfo.userRealName);
                    $("#userPhone").val(userInfo.userPhone);
                    $("#userBirthday").val(userInfo.userBirthday);
                    if (userInfo.userSex == 1) {
                        $("#userSex1").attr("checked", "checked");
                    } else if (userInfo.userSex == 2) {
                        $("#userSex2").attr("checked", "checked");
                    } else {
                        $("#userSex3").attr("checked", "checked");
                    }
                    $("#myModalLabel2").html("编辑用户信息");
                    $("#myModal").modal({
                        backdrop: false,
                        show: true
                    });
                }
            }
        });
    }
</script>
</body>
</html>