<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/24.
@time 15:13.
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
    <title>修改实验信息</title>
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
                        <td><a href="javascript:;" onclick="updateexp('${exp.resId}','${exp.scheduleId}','${exp.expinformationId}','${exp.expinformationName}','${exp.labinformationFloor}','${exp.labinformationName}','${exp.scheduledate}');">修改</a></td>
                    </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div id="levelmeaning" style="display: none;margin-top: 1%; overflow:hidden; ">
    <div class="row">
        <div class=" col-sm-12 form-horizontal">


            <div class="form-group">
                <label class="col-sm-3 control-label">实验名</label>
                <div class="col-sm-7">
                    <input class="form-control" id="expname" >
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">实验室楼</label>
                <div class="col-sm-7">
                    <select class="form-control" id="labfool" onclick="selectfloor()">
                        <option id="defaultylabfool" disabled selected hidden></option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">实验室</label>
                <div class="col-sm-7">
                    <select class="form-control" id="labName">
                        <option id="defaultylabName" disabled selected hidden></option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">实验时间</label>
                <div class="col-sm-7">
                    <input class="form-control" id="scheduleDate" >
                </div>
            </div>
            <div style="display: none" id="schedid"></div>
            <div style="display: none" id="expid"></div>
            <div style="display: none" id="resid"></div>

            <button type="button" class="btn btn-default" style="margin-left: 63%;width: 20%" id="tj"  onclick="tjupdate()" > 提交</button>
<%--            <button type="button" class="btn btn-default" style="margin-left: 63%;width: 20%" onclick="closeall();" > 关闭</button>--%>
            <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
        </div>
    </div>
</div>

<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>

<script>
    layui.use(['layer','laydate','jquery'], function(){
        var $=layui.jquery;
        var layer = layui.layer;
        var laydate = layui.laydate;
    });

    function updateexp(resid,schedid,expid,expname,labfloor,labname,schedudate) {
            var $=layui.jquery;
            var layer = layui.layer;
            var laydate = layui.laydate;
            layer.open({
                type: 1
                , title: '修改实验信息' //不显示标题栏
                , area: ['700px', '400px']
                , shade: 0.8
                ,skin: 'yourclass'
                , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                , btnAlign: 'c'
                , moveType: 0 //拖拽模式，0或者1
                , content: $('#levelmeaning')
                ,success:function () {
                    //实验楼方法
                    $.ajax({
                        url:'${ctx}/selectAlllabfloor1',
                        type:'post',
                        dataType:'json',
                        async:true,
                        success:function (response) {
                            for(i = 0;i<response.data.length;i++){
                                if (response.data[i].labinformationFloor == labfloor ){
                                    $('#labfool').append("<option selected>"+response.data[i].labinformationFloor+"</option>")
                                }else{
                                    $('#labfool').append("<option>"+response.data[i].labinformationFloor+"</option>")
                                }
                            }
                        }
                    })
                    // async:true
                    //实验室方法
                    $.ajax({
                        url:'${ctx}/selectAlllabName1',
                        type:'post',
                        dataType:'json',
                        success:function (response1) {
                            for(i = 0;i<response1.data.length;i++){
                                if (response1.data[i].labinformationName == labname ){
                                    $('#labName').append("<option selected>"+response1.data[i].labinformationName+"</option>")
                                }else{
                                    $('#labName').append("<option>"+response1.data[i].labinformationName+"</option>")
                                }
                            }
                        }
                    })
                }
                ,cancel:function () {
                    $('#labName').empty();
                    $('#labfool').empty();
                }
            });

            laydate.render({
                elem: '#scheduleDate'
                ,type:'date'
                ,lang: 'en'
                ,max: 4
                ,min: 0
            });

        $('#expname').val(expname);
        $('#defaultylabName').html(labname);
        $("#scheduleDate").val(schedudate);
        $('#defaultylabfool').html(labfloor);
        $('#schedid').html(schedid);
        $('#expid').html(expid);
        $('#resid').html(resid);


    }

    function tjupdate() {
       var expName =  $('#expname').val();
       var labfool = $('#labfool').val();
       var labName = $('#labName').val();
       var scheduleDate = $('#scheduleDate').val();
       var exid = $('#expid').html();
       var schid =  $('#schedid').html();
       var resid = $('#resid').html();
       $.ajax({
           url:'${ctx}/updateexp1',
           type:'POST',
           dataType:'json',
           data:{ExpName:expName,LabFool:labfool,LabName:labName,ScheduleDate:scheduleDate,ExpId:exid,SchId:schid,ResId:resid},
           success:function (response) {
              if(response.code == 0){
                  window.location.href = '${ctx}/18';
              }else if(response.code == 1){
                layer.open({
                    title: '信息'
                    , content: response.msg
                })
              }
           }
       })
    }

    function selectfloor() {
        var labfloor = $('#labfool').val();
        console.log(labfloor);
        if (labfloor != null){
            $.ajax({
                url:'${ctx}/selectfloorlab',
                type:'POST',
                dataType:'json',
                data:{labfloor1:labfloor},
                success:function (response) {
                    $('#labName').empty();
                    for(i =0;i<response.data.length;i++){
                        $('#labName').append("<option>"+response.data[i]+"</option>");
                        console.log(response.data[i])
                    }

                }
            })
        }
    }

    function closeall() {
        var layer=layui.layer;
        layer.closeAll();
    }
</script>
</body>
</html>
