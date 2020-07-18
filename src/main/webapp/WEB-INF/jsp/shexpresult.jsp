<%--
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
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>审核实验结果页面</title>
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
                    <th width="100px">学号</th>
                    <th width="80px">姓名</th>
                    <th width="100px">实验名</th>
                    <th width="100px">指导老师</th>
                    <th width="200px" style="display: none">班级</th>
                    <th width="100px" style="display: none">实验结果与分析</th>
                    <th width="100px" style="display: none">实验完成度</th>
                    <th width="100px">实验日期</th>
                    <th width="100px">实验时间段</th>
                    <th width="100px">状态</th>
                    <th colspan="2" width="140px" ></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expResultsList}" var="exp">
                    <c:if test="${exp.teacherNameId == user1.userId}">
                        <tr id="sj">
                            <td>${exp.expresultsId}</td>
                            <td>${exp.expresultsName}</td>
                            <td>${exp.expinformationName}</td>
                            <td>${exp.expinformationTeacherName}</td>
                            <td style="display: none">${exp.expresultsCalss}</td>
                            <td style="display: none"><textarea style="resize: none;" disabled>${exp.expresultsAnalysis}</textarea></td>
                            <td style="display: none"><textarea style="resize: none;" disabled>${exp.expresultsFinish}</textarea></td>
                            <td>${exp.expresultriqi}</td>
                            <td>${exp.erpresultsShijianduan == 1?"9:00~11:00":exp.erpresultsShijianduan == 2?"15:00~17:00":"20:00~22:00"}</td>
                            <td>${exp.expresultsStatus == 1?"待审核":"审核通过"}</td>
                            <td width="70px" ><a href="javascript:;" class="layui-btn layui-btn-sm" onclick="tongguo('${exp.id}')" >通过</a></td>
                            <td width="70px" ><a href="javascript:;" class="layui-btn layui-btn-sm" onclick="butongguo('${exp.id}')" >不通过</a></td>
                            <td><a href="javascript:;" onclick="view(
                                '${exp.expresultsId}',
                                '${exp.expresultsName}',
                                '${exp.expinformationName}',
                                '${exp.expinformationTeacherName}',
                                '${exp.expresultsAnalysis}',
                                '${exp.expresultsFinish}',
                                '${exp.expresultsStatus == 1?"待审核":"审核通过"}'
                                )">查看</a></td>
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
                        <div class="col-sm-5">
                            <label>学号：</label>
                        </div>
                        <div id="xuehao1" class="col-sm-6">
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
                        <div class="col-sm-5">
                            <label>实验名：</label>
                        </div>
                        <div id="shiyanming1" class="col-sm-6">
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="col-sm-6">
                            <label>指导老师</label>
                        </div>
                        <div id="zhidaolaos1" class="col-sm-5">
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
    layui.use('layer', function(){
        var layer = layui.layer;
    });
    function view(a,b,c,d,e,f,g) {
        layer.open({
            type: 1
            , title: '实验结果' //不显示标题栏
            , area: ['700px', '620px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: $('#syxxtx')
        });
        $('#xuehao1').html(a);
        $('#xingming1').html(b);
        $('#shiyanming1').html(c);
        $('#zhidaolaos1').html(d);
        $('#syjgfx').html(e);
        $('#shwcd').html(f);
        $('#shenhezhuangt').html(g);
    }
    function tongguo(id) {
        layer.open({
            title: '信息'
            ,content: '你确定要审核通过么？'
            ,  yes: function(index, layero){
                //do something
                $.ajax({
                    url:'${ctx}/tongguoexpr',
                    type:'POST',
                    dataType:'json',
                    data:{expr:id},
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
    function butongguo(id) {
        layer.open({
            title: '信息'
            ,content: '你确定要不审核通过么？'
            ,  yes: function(index, layero){
                //do something
                $.ajax({
                    url:'${ctx}/butongguoexpr',
                    type:'POST',
                    dataType:'json',
                    data:{expr:id},
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
</script>
</body>
</html>
