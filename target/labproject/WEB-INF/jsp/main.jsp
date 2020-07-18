<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/8.
@time 23:51.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>个人信息</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<div class="row">

<form class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">ID</label>
        <div class="col-sm-3">
<%--            <input class="form-control"  type="text" placeholder="${UserId1}" disabled>--%>
            <p class="form-control-static">${UserId1}</p>
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">密码</label>
        <div class="col-sm-3">
            <input class="form-control"  type="text" placeholder="${UserPassword1}" disabled>
<%--            <p class="form-control-static">${UserPassword1}</p>--%>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-3">
            <input class="form-control"  type="text" placeholder="${UserName1}" disabled>
<%--            <p class="form-control-static">${UserName1}</p>--%>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">学院</label>
        <div class="col-sm-3">
            <input class="form-control"  type="text" placeholder="${UserFaculty1}" disabled>
<%--            <p class="form-control-static">${UserFaculty1}</p>--%>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">班级</label>
        <div class="col-sm-3">
            <input class="form-control"  type="text" placeholder="${UserClass1}" disabled>
<%--            <p class="form-control-static">${UserClass1}</p>--%>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">手机号</label>
        <div class="col-sm-3">
            <input class="form-control"  type="text" placeholder="${UserPhone1}" disabled>
<%--            <p class="form-control-static">${UserPhone1}</p>--%>
        </div>
    </div>
</form>
</div>

<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>


</body>
</html>
