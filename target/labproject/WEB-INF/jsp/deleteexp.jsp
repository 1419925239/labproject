<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/24.
@time 15:14.
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
    <title>实验信息删除</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<div class="container" style="overflow: auto;">
    <div class="row clearfix" style="height: 90%;">
        <div class="col-lg-12 column">
            <table class="table" >
                <thead>
                <tr>
                    <th width="120px">学院</th>
                    <th width="100px">实验类型</th>
                    <th width="120px">实验名字</th>
                    <th width="100px">指导老师</th>
                    <th width="200px">实验楼</th>
                    <th width="100px">实验室</th>
                    <th width="100px">实验时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResSchLab}" var="exp">
                    <c:if test="${exp.reserUserId == user1.userId}">
                    <tr id="sj">
                        <td>${exp.expinformationFaculty}</td>
                        <td>${exp.expinformationType}</td>
                        <td>${exp.expinformationName}</td>
                        <td>${exp.expinformationTeacherName}</td>
                        <td>${exp.labinformationFloor}</td>
                        <td>${exp.labinformationName}</td>
                        <td>${exp.scheduledate}</td>
                        <td><a href="javascript:;" onclick="deleteexp('${exp.resId}','${exp.scheduleId}','${exp.expinformationId}')">删除</a></td>
                    </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>
<script>
    function deleteexp(resid,schedid,expid) {
        $.ajax({
            url:'${ctx}/deleteexpinfo',
            type:'POST',
            dataType:'json',
            data:{resId:resid,schedId:schedid,expId:expid},
            success:function (response) {
                console.log(response);
                if(response.code ==0){
                    window.location.href = '${ctx}/18';
                }else {
                    layer.open({
                        title: '信息'
                        ,content: response.msg
                    });
                }
            }
        })
    }
</script>
</body>
</html>
