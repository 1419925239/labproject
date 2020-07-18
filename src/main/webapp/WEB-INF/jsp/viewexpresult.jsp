<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/3/6.
@time 10:30.
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
    <title>查看实验结果页面</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<div class="container" style="overflow: auto;">
    <div id="w" class="row clearfix" style="height: 90%;">
        <div class="col-lg-12 column">
            <table class="table" >
                <thead>
                <tr>
                    <th width="120px">学号</th>
                    <th width="100px">姓名</th>
                    <th width="100px">实验名</th>
                    <th width="100px">指导老师</th>
                    <th width="200px" >班级</th>
                    <th id="ID1" width="100px" style="display: none;">实验结果与分析</th>
                    <th id="ID2" width="100px" style="display: none;">实验完成度</th>
                    <th id="ID3" width="100px" style="display: none;">实验日期</th>
                    <th id="ID4" width="100px" style="display: none;">实验时间段</th>
                    <th width="100px">状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResultsList}" var="exp">
                        <c:if test="${exp.expresultsId == user1.userId}">
                            <tr id="sj">
                                <td>${exp.expresultsId}</td>
                                <td>${exp.expresultsName}</td>
                                <td>${exp.expinformationName}</td>
                                <td>${exp.expinformationTeacherName}</td>
                                <td>${exp.expresultsCalss}</td>
                                <td id="ID5" style="display: none;"><textarea style="resize: none;" disabled>${exp.expresultsAnalysis}</textarea></td>
                                <td id="ID6" style="display: none;"><textarea style="resize: none;" disabled>${exp.expresultsFinish}</textarea></td>
                                <td id="ID7" style="display: none;">${exp.expresultriqi}</td>
                                <td id="ID8" style="display: none;">${exp.erpresultsShijianduan == 1?"9:00~11:00":exp.erpresultsShijianduan == 2?"15:00~17:00":"20:00~22:00"}</td>
                                <td>${exp.expresultsStatus == 1?"待审核":"审核通过"}</td>
                                <td ><a href="javascript:;" onclick="updatestyle(
                                    '${exp.expresultsId}',
                                    '${exp.expresultsName}',
                                    '${exp.expinformationName}',
                                    '${exp.expinformationTeacherName}',
                                    '${exp.expresultsCalss}',
                                    '${exp.expresultsAnalysis}',
                                    '${exp.expresultsFinish}',
                                    '${exp.expresultriqi}',
                                    '${exp.erpresultsShijianduan == 1?"9:00~11:00":exp.erpresultsShijianduan == 2?"15:00~17:00":"20:00~22:00"}')">查看</a></td>
                            </tr>
                        </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="syxxtx" style="display: none;margin-top: 20px;">
            <div class="row">
                <div class="col-md-12">
                    <div  class="col-md-7">
                        <div class="col-sm-6">
                            <label>学号：</label>
                        </div>
                        <div id="xuehao1" class="col-sm-5">
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <div class="col-sm-6">
                            <label>姓名：</label>
                        </div>
                        <div id="xingming1" class="col-sm-5">
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <div class="col-sm-6">
                            <label>实验日期：</label>
                        </div>
                        <div id="shiyanriqi1" class="col-sm-5">
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="col-sm-6">
                            <label>时间段：</label>
                        </div>
                        <div id="shijianduan1" class="col-sm-5">
                        </div>
                    </div>
                </div>
                <div class="col-md-12" style="margin-left: 30px;">
                    <hr style="height:1px;border:none;border-top:1px solid #555555;width: 90%;">
                    <label>实验结果与分析:</label><br>
                    <textarea id="syjgfx" style="resize: none;width: 90%;height: 200px;" disabled></textarea>
                </div>
                <div class="col-md-12"  style="margin-left: 30px;margin-top: 10px;">
                    <label>实验完成度:</label><br>
                    <textarea id="shwcd" style="resize: none;width: 90%;height: 200px;" disabled></textarea>
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

   function updatestyle(a,b,c,d,e,f,g,h,i) {
       layer.open({
           type: 1
           , title: false //不显示标题栏
           , area: ['700px', '600px']
           , shade: 0.8
           ,skin: 'yourclass'
           , id: 'LAY_layuipro' //设定一个id，防止重复弹出
           , btnAlign: 'c'
           , moveType: 1 //拖拽模式，0或者1
           , content: $('#syxxtx')
       });
       $('#xuehao1').html(a);
       $('#xingming1').html(b);
       $('#shiyanriqi1').html(h);
       $('#shijianduan1').html(i);
       $('#syjgfx').html(f);
       $('#shwcd').html(g);
   }
</script>
</body>
</html>