<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/3/5.
@time 11:16.
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
    <title>查询预约实验结果</title>
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
                    <th width="100px" style="display: none;">实验室</th>
                    <th width="100px">日期</th>
                    <th width="100px">实验时间段</th>
                    <th width="100px">状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResSchLab}" var="exp">
                    <c:set var="nowDate1" value="${fn:replace(exp.scheduledate,'/','')}" />
                    <fmt:formatDate value="<%=new Date()%>" pattern="yyyyMMdd " var="day"/>
                    <fmt:parseNumber var="i" integerOnly="true" type="number" value="${nowDate1}" />
                    <fmt:parseNumber var="j" integerOnly="true" type="number" value="${day}" />
                    <c:if test="${(i-j) >= 0}">
                            <c:if test="${exp.expinformationTeacherName != user1.userName}">
                            <c:if test="${exp.userName == user1.userName}">
                                <tr id="sj">
                                    <td style="display: none;">${exp.expinformationFaculty}</td>
                                    <td style="display: none;">${exp.expinformationType}</td>
                                    <td>${exp.expinformationName}</td>
                                    <td>${exp.userName}</td>
                                    <td>${exp.expinformationTeacherName}</td>
                                    <td style="display:none;">${exp.labinformationFloor}</td>
                                    <td style="display:none;">${exp.labinformationName}</td>
                                    <td>${exp.scheduledate}</td>
                                    <td>${exp.reserDatatime == 1?"9:00~11:00":exp.reserDatatime == 2?"15:00~17:00":"20:00~22:00"}</td>
                                    <td>${exp.reserStatus == 1?"待审核":"审核通过"}</td>
                                    <td><a href="javascript:;" onclick="viewdate(
                                        '${exp.expinformationFaculty}',
                                        '${exp.expinformationType}',
                                        '${exp.expinformationName}',
                                        '${exp.labinformationFloor}',
                                        '${exp.labinformationName}',
                                        )">查看</a></td>
                                </tr>
                            </c:if>
                            </c:if>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="syxxtx" style="display: none;margin-top: 20px;">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">学院：</label>
                        <div class="col-sm-8" id="xueyuan1">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">实验类型：</label>
                        <div class="col-sm-8" id="shiyanleixing">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">实验名：</label>
                        <div class="col-sm-8" id="shiyanming">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">实验楼：</label>
                        <div class="col-sm-8" id="shiyanl">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <label class="col-sm-4 control-label">实验室：</label>
                        <div class="col-sm-8" id="shiyans">
                        </div>
                    </div>
                </div>
            </div>
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
    function viewdate(a,b,c,d,e) {
        layer.open({
            type: 1
            , title: false //不显示标题栏
            , area: ['500px', '300px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: $('#syxxtx')
        });
        $('#xueyuan1').html(a);
        $('#shiyanleixing').html(b);
        $('#shiyanming').html(c);
        $('#shiyanl').html(d);
        $('#shiyans').html(e);
    }
</script>
</body>
</html>