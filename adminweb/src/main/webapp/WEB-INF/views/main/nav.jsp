<%--
  Created by IntelliJ IDEA.
  User: Jiazefeng
  Date: 2017/10/19
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left">
    <ul class="nav" id="menu">
        <li><a href="#"><i class="fa fa-star-o nav_icon"></i>数据分析</a></li>
        <li>
            <a href="#">
                <i class="fa fa-star-o nav_icon"></i>系统管理<span class="fa arrow"></span>
            </a>
            <ul class="nav nav-second-level collapse">
                <li><a href="../menu/menuManage.html">菜单管理</a></li>
                <li><a href="../user/getUserInfo">用户管理</a></li>
                <li><a href="#">权限管理</a></li>
            </ul>
            <%--<ul class="nav nav-second-level collapse">--%>
                <%--<li><a href="../user/getUserInfo">用户管理</a></li>--%>
                <%--&lt;%&ndash;<li><a href="../user/getUserInfo"><i class="fa fa-star-o nav_icon"></i>用户管理</a></li>&ndash;%&gt;--%>
            <%--</ul>--%>
            <%--<ul class="nav nav-second-level collapse">--%>
                <%--<li><a href="#">权限管理</a></li>--%>
                <%--&lt;%&ndash;<li><a href="#"><i class="fa fa-star-o nav_icon"></i>权限管理</a></li>&ndash;%&gt;--%>
            <%--</ul>--%>
        </li>
        <li><a href="../equipment/getEquipmentList"><i class="fa fa-star-o nav_icon"></i>设备管理</a></li>
        <li><a href="#"><i class="fa fa-star-o nav_icon"></i>环境管理</a></li>
        <li><a href="#"><i class="fa fa-star-o nav_icon"></i>历史数据管理</a></li>
        <li><a href="#"><i class="fa fa-star-o nav_icon"></i>阈值管理</a></li>
        <li><a href="#"><i class="fa fa-star-o nav_icon"></i>视频图像管理</a></li>
    </ul>
</nav>
