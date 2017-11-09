<%--
  Created by IntelliJ IDEA.
  User: Jiazefeng
  Date: 2017/10/19
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<div class="sticky-header header-section ">
    <div>
        <button id="showLeftPush"><i class="fa fa-bars"></i></button>
        <div class="header-left">
            <div class="logo">
                <a href="#" class="fl logo block mt20 ml50">
                    <img src="/static/images/logo/logo.png">
                </a>
            </div>
        </div>
        <div class="header-right">
            <div class="profile_details">
                <ul>
                    <li>
                        <span>2017-10-17 14:55:01</span>
                        <span> 您好，李宁</span>
                        <a href="javascript:;">
                            <span> 修改密码</span>
                        </a>
                        <a class="signOut" href="/"><span></span> <span>退出</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>

    <spring:message code="welcome"/>

    <%--</div>--%>
</div>

