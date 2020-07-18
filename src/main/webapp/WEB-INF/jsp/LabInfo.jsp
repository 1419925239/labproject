<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/23.
@time 11:02.
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
    <title>实验室查询</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>实验室楼</th>
                    <th>实验室名字</th>
                    <th>实验室可容纳人数</th>
                    <th>实验室描述</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${labinfo}" var="lab">
                <tr>
                    <td>${lab.labinformationFloor}</td>
                    <td>${lab.labinformationName}</td>
                    <td>${lab.labinformationNum}</td>
                    <td>${lab.labinformationDescription}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>

</body>
</html>