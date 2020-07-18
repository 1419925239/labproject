<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/3/5.
@time 17:19.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>审核预约结果页面</title>
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
                    <th width="120px" style="display: none;">学院</th>
                    <th width="100px" style="display: none;">实验类型</th>
                    <th width="120px">实验名字</th>
                    <th width="100px">实验人</th>
                    <th width="100px">指导老师</th>
                    <th width="200px" style="display: none;">实验楼</th>
                    <th width="100px">实验室</th>
                    <th width="100px">日期</th>
                    <th width="100px">实验时间段</th>
                    <th width="100px">状态</th>
                    <th colspan="2" width="130px">是否通过审核</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResSchLab}" var="exp">
                    <c:set var="nowDate1" value="${fn:replace(exp.scheduledate,'/','')}" />
                    <fmt:formatDate value="<%=new Date()%>" pattern="yyyyMMdd " var="day"/>
                    <fmt:parseNumber var="i" integerOnly="true" type="number" value="${nowDate1}" />
                    <fmt:parseNumber var="j" integerOnly="true" type="number" value="${day}" />
                    <c:if test="${(i-j) >= 0}">
                            <c:if test="${exp.userName != exp.expinformationTeacherName}">
                            <c:if test="${exp.expinformationTeacherName == user1.userName}">
                                <tr id="sj">
                                    <td style="display: none;">${exp.expinformationFaculty}</td>
                                    <td style="display: none;">${exp.expinformationType}</td>
                                    <td>${exp.expinformationName}</td>
                                    <td>${exp.userName}</td>
                                    <td>${exp.expinformationTeacherName}</td>
                                    <td style="display: none;">${exp.labinformationFloor}</td>
                                    <td>${exp.labinformationName}</td>
                                    <td>${exp.scheduledate}</td>
                                    <td>${exp.reserDatatime == 1?"9:00~11:00":exp.reserDatatime == 2?"15:00~17:00":"0:00~22:00"}</td>
                                    <td>${exp.reserStatus == 1?"待审核":"审核通过"}</td>
                                    <td width="70" ><a href="javascript:;" class="layui-btn layui-btn-sm" onclick="tongguo('${exp.expinformationId}','${exp.resId}')" >通过</a></td>
                                    <td ><a href="javascript:;" class="layui-btn layui-btn-sm"  onclick="butongguo('${exp.expinformationId}','${exp.resId}')">不通过</a></td>
                                </tr>
                            </c:if>
                            </c:if>
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
    layui.use('layer', function(){
        var layer = layui.layer;
    });

    function tongguo(expid,resid) {
        layer.open({
            title: '信息'
            ,content: '你确定要审核通过么？'
            ,  yes: function(index, layero){
                //do something
                $.ajax({
                    url:'${ctx}/tongguo',
                    type:'POST',
                    dataType:'json',
                    data:{exid:expid,reid:resid},
                    success:function (response) {
                        if(response.code == 0){
                            layer.msg(response.msg,{icon: 6});
                            window.location.reload();
                        }else {
                            layer.msg(response.msg, {icon: 5});
                            window.location.reload();
                        }

                    }
                })
                layer.close(index); //如果设定了yes回调，需进行手工关闭
            }
        });


    }
    function butongguo(expid1,resid1) {
        layer.open({
            title: '信息'
            ,content: '你确定要审核不通过么？'
            ,  yes: function(index, layero){
                //do something
                $.ajax({
                    url:'${ctx}/butongguo',
                    type:'POST',
                    dataType:'json',
                    data:{exid:expid1,reid:resid1},
                    success:function (response) {
                        if(response.code == 0){
                            layer.msg(response.msg,{icon: 6});
                        }else {
                            layer.msg(response.msg, {icon: 5});
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
