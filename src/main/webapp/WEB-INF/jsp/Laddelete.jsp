<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/23.
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
    <title>实验室删除页面</title>
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
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${labinfo}" var="lab">
                    <tr>
                        <td>${lab.labinformationFloor}</td>
                        <td>${lab.labinformationName}</td>
                        <td>${lab.labinformationNum}</td>
                        <td>${lab.labinformationDescription}</td>
                        <td><a href="javascript:;" onclick="deletelab(${lab.labinformationId})">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>
<script>
    layui.use(['laytpl','element','form','layer'],function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        var element = layui.element;
        var layer = layui.layer;
    });

    function deletelab(id) {
        layer.open({
            content: '你确定要删除么？',
            yes: function(index, layero){
                //do something
                $.ajax({
                    url:'${ctx}/labdelete',
                    type:'POST',
                    dataType:'json',
                    data:{labid:id},
                    success:function (response) {
                        if (response.code == 0){
                            window.location.href = '${ctx}/9';
                        }else{
                            layer.msg(response.msg);
                        }
                    }
                })
                layer.close(index); //如果设定了yes回调，需进行手工关闭
            }
        });
    }
</script>
</body>
</html>
