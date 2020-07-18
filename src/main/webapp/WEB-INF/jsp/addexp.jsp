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
    <title>实验信息添加</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<div class="row">
    <div class="form-horizontal">

        <div class="form-group">
            <label class="col-sm-2 control-label">学院</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="expinformationFaculty" value="${user1.userFaculty}" disabled>
            </div>
<%--        </div>--%>

<%--        <div class="form-group">--%>
            <label  class="col-sm-2 control-label">实验类型</label>
            <div class="col-sm-3">
                <select class="form-control" id="expinformationType">
                    <option selected="selected">开放型</option>
                    <option>课堂型</option>
                </select>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">实验名字</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="expinformationName"  >
                <span class="help-block"></span>
            </div>
<%--        </div>--%>

<%--        <div class="form-group">--%>
            <label class="col-sm-2 control-label">指导老师名字</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="expinformationTeacherName"  value="${user1.userName}"   disabled>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">实验楼</label>
            <div class="col-sm-3">
                <select class="form-control" id="labinformationFloor" onclick="selectfloor()">
                    <c:forEach items="${labfloor}" var="floor">
                        <option value="${floor.labinformationFloor}">${floor.labinformationFloor}</option>
                    </c:forEach>
                </select>
                <span class="help-block"></span>
            </div>
<%--        </div>--%>
<%--        <div class="form-group">--%>
            <label class="col-sm-2 control-label">实验室</label>
            <div class="col-sm-3">
                <select class="form-control" id="labinformationName">
                </select>
                <span class="help-block"></span>
                <div style="display: none;">
                    <p id="labid"></p>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">实验时间</label>
            <div class="col-sm-3">
                <input class="form-control" id="scheduleDate">
                <span class="help-block"></span>
            </div>
<%--        </div>--%>

<%--        <div class="form-group">--%>
            <label class="col-sm-2 control-label">时间段</label>
            <div class="col-sm-3">
                <select class="form-control" id="datatime">
                    <option value="1">9:00~11:00am</option>
                    <option value="2">15:00~17:00pm</option>
                    <option value="3">20:00~22:00pm</option>
                </select>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">实验目的</label>
            <div class="col-sm-8">
                <input  class="form-control" id="expinformationPurpose"></input>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">所需仪器</label>
            <div class="col-sm-8">
                <textarea class="form-control" id="expinformationIns" style="height: 13%" ></textarea>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">实验步骤</label>
            <div class="col-sm-8">
                <textarea class="form-control" id="expinformationStep" style="height: 13%" ></textarea>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-8">
                <button type="button" class="btn btn-default" style="margin-left: 97%;width: 23%" id="tj" onclick="tj()" > 提交</button>
                <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" ></script>
<script src="${ctx}/static/art-template/template-web.js" charset='utf-8'></script>
<script>


    layui.use(['laydate','layer'], function(){
        var laydate = layui.laydate;
        var layer = layui.layer;
        //执行一个laydate实例
        laydate.render({
            elem: '#scheduleDate'
            ,lang: 'en'
            ,max: 4
            ,min: 0
        });
    });
    //选择楼号展现出来实验室
    function selectfloor() {
        var labinformationFloor = $('#labinformationFloor option:selected');
        var labfloor = labinformationFloor.val();
        console.log(labfloor);
        if (labfloor != null){
            $.ajax({
                url:'${ctx}/selectfloorlab',
                type:'POST',
                dataType:'json',
                async : false,
                data:{labfloor1:labfloor},
                success:function (response) {
                    console.log(response);
                    $('#labinformationName').empty();
                    for(i =0;i<response.data.length;i++){
                        $('#labinformationName').append("<option>"+response.data[i]+"</option>");
                        console.log(response.data[i])
                    }

                }
            })
        }
    }
    //创建时间
    function CurentTime()
    {
        var now = new Date();
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
        var clock = year + "-";
        if(month < 10)
            clock += "0";
        clock += month + "-";
        if(day < 10)
            clock += "0";
        clock += day + " ";
        return(clock);
    }

    //校验表单信息
    function validate_add_form(){
        var exptype = $('#expinformationType').val();
        var expname = $('#expinformationName').val();
        var expins = $('#expinformationIns').val();
        var expstep = $('#expinformationStep').val();
        var labinformationName = $('#labinformationName option:selected');
        var labname = labinformationName.val();
        //课堂类型校验
        if(exptype == null){
            show_validate_msg("expinformationType","error","不能为空！");
            return false;
        }else {
            show_validate_msg("expinformationType","success","");
        }
        //实验名字校验
        if (expname == null){
            show_validate_msg("expinformationName","error","不能为空！");
            return  false;
        }else {
            show_validate_msg("expinformationName","success","");
        }
        //实验步骤校验
        if(expstep == null ){
            show_validate_msg("expinformationStep","error","不能为空！");
            return false;
        }else {
            show_validate_msg("expinformationStep","success","");
        }
        //实验目的校验
        if(expins == null ){
            show_validate_msg("expinformationIns","error","不能为空！");
            return false;
        }else {
            show_validate_msg("expinformationIns","success","");
        }
        //实验室校验
        if(labname == null ){
            show_validate_msg("labinformationName","error","不能为空！");
            return false;
        }else {
            show_validate_msg("labinformationName","success","");
        }
        return true;
    }


    //显示校验信息
    function show_validate_msg(ele,status,msg){
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success" == status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if ("error" == status) {
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }

    function tj() {
        var expfac = $('#expinformationFaculty').val();
        var exptype = $('#expinformationType').val();
        var expname = $('#expinformationName').val();
        var expteaname = $('#expinformationTeacherName').val();
        var exppur = $('#expinformationPurpose').val();
        var expins = $('#expinformationIns').val();
        var expstep = $('#expinformationStep').val();
        var labinformationFloor = $('#labinformationFloor option:selected');
        var labfloor = labinformationFloor.val();
        var labinformationName = $('#labinformationName option:selected');
        var labname = labinformationName.val();
        var scheduleDate = $('#scheduleDate').val();
        var datatime = $('#datatime option:selected');
        var time=datatime.val();
        if(!validate_add_form()){
            return false;
        }

        //时间的判定！
        var arys1= new Array();
        var arys2= new Array();
        var nowstart = CurentTime();
        arys1 = nowstart.split('-');
        var sdate=new Date(arys1[0],parseInt(arys1[1]-1),arys1[2]);
        arys2=scheduleDate.split('-');
        var edate=new Date(arys2[0],parseInt(arys2[1]-1),arys2[2]);
        console.log(sdate+"----"+edate);
        if(edate <sdate){
            layer.open({
                title: '信息'
                ,content: "起始时间不能小于当前时间！"
            })
        }else {
                    $.ajax({
                        url:'${ctx}/addexp',
                        type:'POST',
                        dataType:'json',
                        data:{
                            expinformationFaculty:expfac,
                            expinformationType:exptype,
                            expinformationName:expname,
                            expinformationTeacherName:expteaname,
                            expinformationPurpose:exppur,
                            expinformationIns:expins,
                            expinformationStep:expstep,
                            labinformationFloor:labfloor,
                            labinformationName:labname,
                            scheduleDate:scheduleDate,
                            datatime:time,
                            userid:${user1.userId}
                        },
                        success:function (response) {
                            if (response.code == 0){
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




    }
</script>
</body>
</html>

