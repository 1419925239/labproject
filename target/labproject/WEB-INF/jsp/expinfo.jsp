<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %><%--
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>实验信息</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2;"  >
<blockquote class="layui-elem-quote">绿色代表当前实验所处时间段！</blockquote>
<div class="container" style="overflow: auto;">
    <div class="row clearfix" style="height: 87%;">
        <div class="col-lg-12 ">

            <table class="table" >
                <thead>
                <tr>
                    <th width="120px" style="display: none">学院</th>
                    <th width="100px">实验类型</th>
                    <th width="160px">实验名字</th>
                    <th width="170px" style="display: none">指导老师</th>
                    <th width="250px" style="display: none">实验楼</th>
                    <th width="200px" style="display: none">实验室</th>
                    <th width="100px">实验时间</th>
                    <th colspan="2" width="140px">9:00~11:00</th>
                    <th colspan="2" width="140px">15:00~17:00</th>
                    <th colspan="2" width="140px">20:00~22:00</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResSchLab}" var="exp">
                    <c:set var="nowDate1" value="${fn:replace(exp.scheduledate,'/','')}" />
                    <fmt:formatDate value="<%=new Date()%>" pattern="yyyyMMdd " var="day"/>
                    <fmt:parseNumber var="i" integerOnly="true" type="number" value="${nowDate1}" />
                    <fmt:parseNumber var="j" integerOnly="true" type="number" value="${day}" />
                   <c:if test="${(i-j) >= 0}">
                       <c:if test="${exp.expinformationType == '课堂型'}">
                            <c:if test="${exp.roleName != '[学生]'}">
                                <tr id="sj">
                                    <td style="display: none">${exp.expinformationFaculty}</td>
                                    <td>${exp.expinformationType}</td>
                                    <td>${exp.expinformationName}</td>
                                    <td style="display: none">${exp.expinformationTeacherName}</td>
                                    <td style="display: none">${exp.labinformationFloor}</td>
                                    <td style="display: none">${exp.labinformationName}</td>
                                    <td>${exp.scheduledate}</td>
                                    <c:choose>
                                        <c:when test="${exp.reserDatatime == 1}"><!-- if (id==1) -->
                                            <td width="75px" style="background-color: green;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: green;color: white">占用:${exp.t1}</td>
                                            <td width="75px" style="background-color: red;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: red;color: white">占用:${exp.t2}</td>
                                            <td width="75px" style="background-color: red;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: red;color: white">占用:${exp.t3}</td>
                                        </c:when>
                                        <c:when test="${exp.reserDatatime == 2}"><!-- if (id==2) -->
                                            <td width="75px" style="background-color: red;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: red;color: white">占用:${exp.t1}</td>
                                            <td width="75px" style="background-color: green;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: green;color: white">占用:${exp.t2}</td>
                                            <td width="75px" style="background-color: red;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: red;color: white">占用:${exp.t3}</td>
                                        </c:when>
                                        <c:when test="${exp.reserDatatime == 3}"><!-- if (id==2) -->
                                            <td width="75px" style="background-color: red;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: red;color: white">占用:${exp.t1}</td>
                                            <td width="75px" style="background-color: red;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: red;color: white">占用:${exp.t2}</td>
                                            <td width="75px" style="background-color: green;color: white">空闲:${exp.labinformationNum}</td>
                                            <td width="75px" style="background-color: green;color: white">占用:${exp.t3}</td>
                                        </c:when>
                                        <c:otherwise> <!-- else(id==其他) -->
                                            <!-- 执行code -->
                                        </c:otherwise>
                                    </c:choose>
                                    <td><a href="javascript:;" onclick="view(
                                        '${exp.expinformationFaculty}',
                                        '${exp.expinformationType}',
                                        '${exp.expinformationName}',
                                        '${exp.expinformationTeacherName}',
                                        '${exp.labinformationFloor}',
                                        '${exp.labinformationName}',
                                    )" >查看</a></td>
                                    <c:if test="${role4 == '[学生]'}">
                                        <td><a href="javascript:;" onclick="ketangshenqing(
                                            '${exp.expinformationFaculty}',
                                            '${exp.expinformationTeacherName}',
                                            '${exp.expinformationName}',
                                            '${exp.labinformationName}',
                                            '${exp.expinformationType}',
                                            '${exp.expinformationPurpose}',
                                            '${exp.expinformationStep}',
                                            '${exp.scheduledate}',
                                            '${exp.expinformationId}',
                                            '${exp.scheduleId}',
                                            '${exp.labinformationId}',
                                        )" >申请</a></td>
                                    </c:if>
                                </tr>
                            </c:if>
                       </c:if>
                   </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="gerenshenqing" style="display: none">
            <div class="layui-container" style="margin-top: 5%">
                <div class="row">
                    <div class=" col-sm-12 form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">院系</label>
                            <div class="col-sm-5">
                                <input class="form-control"   type="text" id="gerenyuanxi"  disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">指导老师</label>
                            <div class="col-sm-5">
                                <input class="form-control" type="text" id="gerenxingming"  disabled>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验名</label>
                            <div class="col-sm-5">
                                <input class="form-control" type="text" id="gerenshiyanming"  disabled>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验室</label>
                            <div class="col-sm-5">
                                <input class="form-control"  id="gerenshiyanshi" disabled>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验类型</label>
                            <div class="col-sm-5">
                                <input class="form-control"    id="gerenshiyanleixing"  disabled>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验目的</label>
                            <div class="col-sm-5">
                                <textarea style="resize: none;"  class="form-control"    id="gerenshiyanmudi" disabled></textarea>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验步骤</label>
                            <div class="col-sm-5">
                                <textarea class="form-control"  id="gerenshiyanbuzhou" style="resize: none;"  disabled></textarea>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验日期</label>
                            <div class="col-sm-5">
                                <input class="form-control"  id="gerenshiyanriqi" disabled>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">实验时间</label>
                            <div class="col-sm-5">
                                <select class="form-control" placeholder="请输入内容" id="gerenshiyanshijian">
                                    <option value="1">9:00~11:00am</option>
                                    <option value="2">15:00~17:00am</option>
                                    <option value="3">20:00~22:00am</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <button type="button" class="btn btn-default" style="margin-left: 37%;width: 20%" id="gerentijiao"    > 提交</button>
                        <h3><span class="text-danger" style="margin-left: 17%" id="msg1"></span></h3>
                    </div>
                </div>
            </div>
        </div>
        <div id="viewdate" style="display:none;">
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
                        <label class="col-sm-4 control-label">指导老师：</label>
                        <div class="col-sm-8" id="zhidaolaos">
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

    function sub(expid,scheid,labid) {
        var shijianduan = $('#gerenshiyanshijian').val();
        var shiyanriqi = $('#gerenshiyanriqi').val();
        var userid = ${user1.userId};
        $.ajax({
            url:'${ctx}/ketangyuyue',
            type:'POST',
            dataType:'json',
            data:{exp:expid,sch:scheid,lab:labid,shij:shijianduan,shiya:shiyanriqi,use:userid},
            success:function (response) {
                if(response.code == 0){
                    window.location.href = '${ctx}/13';
                }else if(response.code == 1) {
                    layer.msg(response.msg);
                }
            }

        })
    }
    function ketangshenqing(fac,teachername,expname,labname,expty,exppur,expste,sch,expid,scheid,labid){
        layer.open({
            type: 1
            , title: '课堂申请' //不显示标题栏
            , area: ['700px', '500px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: $('#gerenshenqing')
        });
        $('#gerenyuanxi').val(fac);
        $('#gerenxingming').val(teachername);
        $('#gerenshiyanming').val(expname);
        $('#gerenshiyanshi').val(labname);
        $('#gerenshiyanleixing').val(expty);
        $('#gerenshiyanmudi').val(exppur);
        $('#gerenshiyanbuzhou').val(expste);
        $('#gerenshiyanriqi').val(sch);
        $('#gerentijiao').attr('onclick','sub('+expid+','+scheid+','+labid+');');
    }
    function view(a,b,c,d,e,f) {
        layer.open({
            type: 1
            , title: '实验详细信息' //不显示标题栏
            , area: ['500px', '300px']
            , shade: 0.8
            ,skin: 'yourclass1'
            , id: 'LAY_layuipro1' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: $('#viewdate')

        });
        $('#xueyuan1').html(a);
        $('#shiyanleixing').html(b);
        $('#shiyanming').html(c);
        $('#zhidaolaos').html(d);
        $('#shiyanl').html(e);
        $('#shiyans').html(f);
    }
</script>
</body>
</html>
