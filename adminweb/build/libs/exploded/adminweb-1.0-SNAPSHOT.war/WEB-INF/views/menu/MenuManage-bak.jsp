<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/morinda-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
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
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加菜单</button>
            </form>
        </div>
        <%--搜索条件结束--%>
    </div>
</div>
<div class="table-responsive bs-example widget-shadow">

    <table width="100%" class="tableStyle">
        <thead>
        <tr>
            <th>排序</th>
            <th>菜单Id</th>
            <th>菜单名称</th>
            <th>菜单描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roleMenuDTOs}" var="menu" varStatus="vs">
            <tr>
                <td><b>${vs.count}</b></td>
                <td>${menu.roleMenuId}</td>
                <td>${menu.roleMenuName}</td>
                <td>${menu.roleMenuDesc}</td>
                <td class="last">
                    <a href="../role/menuSecManage?parId=${menu.roleMenuId}" class="a3"><span
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


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form class="modal-content" name="form" id="form" >
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
                    <button type="submit" class="btn btn-primary" onclick="add()">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>