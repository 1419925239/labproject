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
    <title>提交实验结果页面</title>
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
                    <th width="120px" style="display: none">学院</th>
                    <th width="100px" >实验类型</th>
                    <th width="120px">实验名字</th>
                    <th width="100px">实验人</th>
                    <th width="100px">指导老师</th>
                    <th width="200px" style="display: none">实验楼</th>
                    <th width="100px">实验室</th>
                    <th width="100px">日期</th>
                    <th width="100px">实验时间段</th>
                    <th width="100px">状态</th>
                    <th width="100px"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResSchLab}" var="exp">
                    <c:set var="nowDate1" value="${fn:replace(exp.scheduledate,'/','')}" />
                    <fmt:formatDate value="<%=new Date()%>" pattern="yyyyMMdd " var="day"/>
                    <fmt:parseNumber var="i" integerOnly="true" type="number" value="${nowDate1}" />
                    <fmt:parseNumber var="j" integerOnly="true" type="number" value="${day}" />
                    <c:if test="${(i-j) >= 0}">
                            <c:if test="${exp.reserUserId == user1.userId}">
                                <tr id="sj">
                                    <td style="display: none">${exp.expinformationFaculty}</td>
                                    <td>${exp.expinformationType}</td>
                                    <td>${exp.expinformationName}</td>
                                    <td>${exp.userName}</td>
                                    <td>${exp.expinformationTeacherName}</td>
                                    <td style="display: none">${exp.labinformationFloor}</td>
                                    <td>${exp.labinformationName}</td>
                                    <td>${exp.scheduledate}</td>
                                    <td>${exp.reserDatatime == 1?"9:00~11:00":exp.reserDatatime == 2?"15:00~17:00":"20:00~22:00"}</td>
                                    <td>${exp.reserStatus == 1?"待审核":"审核通过"}</td>
                                    <c:if test="${exp.reserStatus == 0}">
                                        <td><a href="javascript:;" onclick="expresult('${exp.scheduledate}','${exp.reserDatatime}')">提交</a></td>
                                    </c:if>
                                </tr>
                            </c:if>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            <div style="display: none" id="exptj">
                <div class="layui-container" style="margin-top: 5%">
                    <div class="row">
                        <div class=" col-sm-12 form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">学号:</label>
                                <div class="col-sm-3">
                                    <input class="form-control" value="${user1.userId}"  type="text" id="xuehao"  disabled>
                                </div>

                                <label  class="col-sm-1 control-label">姓名:</label>
                                <div class="col-sm-3">
                                    <input class="form-control" value="${user1.userName}"  type="text" id="xingming"  disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">院系:</label>
                                <div class="col-sm-3">
                                    <input class="form-control" value="${user1.userFaculty}"  type="text" id="yuanxi"  disabled>
                                    <span class="help-block"></span>
                                </div>

                                <label class="col-sm-1 control-label">班级:</label>
                                <div class="col-sm-3">
                                    <input class="form-control" value="${user1.userCalss}" placeholder="请输入内容"   id="banji"   disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" style="margin-left: 35px;margin-top: -10px;">实验结果与分析:</label><br>
                                <div class="col-sm-8" style="margin-top: 10px;margin-left: 20px;">
                                    <textarea class="form-control"  style="height: 20%;" placeholder="请输入内容"  id="shiyanjieguoyufenxi" ></textarea>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" style="margin-left: 35px;margin-top: -20px;">实验完成情况:</label><br>
                                <div class="col-sm-8" style="margin-top: 10px;margin-left: 20px;">
                                    <textarea class="form-control" style="height: 20%;" placeholder="请输入内容" id="shiyanwanchengqingk"></textarea>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group" style="display: none">
                                <label class="col-sm-2 control-label">实验日期</label>
                                <div class="col-sm-5">
                                    <input class="form-control" placeholder="请输入内容" id="shiyanriqi" disabled></input>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group" style="display: none">
                                <label class="col-sm-2 control-label">实验时间段</label>
                                <div class="col-sm-5">
                                    <input class="form-control" placeholder="请输入内容" id="shiyanshijianduan" disabled></input>
                                    <span class="help-block"></span>
                                </div>
                            </div>

                            <button type="button" class="btn btn-default" style="margin-left: 7%;width: 20%" id="tijiao"> 提交</button>
                            <button type="button" class="btn btn-default" style="margin-left: 17%;width: 20%" id="quxiao" "> 取消</button>
                            <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
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
    layui.use('layer', function(){
        var layer = layui.layer;
    });
    function fuzhi(riqi,shijian) {
        var xuehao  = $('#xuehao').val();
        var xingming  = $('#xingming').val();
        var yuanxi  = $('#yuanxi').val();
        var banji  = $('#banji').val();
        var shiyanjieguoyufenxi  = $('#shiyanjieguoyufenxi').val();
        var shiyanwanchengqingk  = $('#shiyanwanchengqingk').val();
        var shiyanriqi  =  $('#shiyanriqi').val();
        var shiyanshijianduan  = shijian;

        $.ajax({
            url:'${ctx}/tjshiyanjieguo',
            type:'POST',
            dataType:'json',
            data:{
                id:xuehao,
                name:xingming,
                facu:yuanxi,
                clas:banji,
                anofre:shiyanjieguoyufenxi,
                car:shiyanwanchengqingk,
                da:shiyanriqi,
                datime:shiyanshijianduan
            },
            success:function (response) {
                if (response.code == 0 ){
                    layer.msg("提交成功！");
                    window.location.href = '${ctx}/25';
                }else if(response.code == 1) {
                    layer.msg("提交失败！");
                }
            }
        })

    }
    function quxiao(a) {
        layer.close(a);
    }
    function expresult(riqi,shijianduan) {
       var index1 = layer.open({
            type: 1
            , title: false //不显示标题栏
            , area: ['700px', '500px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 0 //拖拽模式，0或者1
            , content: $('#exptj')
        });
        $('#shiyanriqi').val(riqi);
        if(shijianduan == 1){
            $('#shiyanshijianduan').val("9:00~11:00");
        }else if(shijianduan == 2){
            $('#shiyanshijianduan').val("15:00~17:00");
        }else if(shijianduan == 3){
            $('#shiyanshijianduan').val("20:00~22:00");
        }
        $('#tijiao').attr('onclick','fuzhi('+riqi+','+shijianduan+');');
        $('#quxiao').attr('onclick','quxiao('+index1+');');
    }

</script>
</body>
</html>
