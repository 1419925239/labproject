<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/23.
@time 18:58.
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
    <title>实验室添加</title>
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
            <label class="col-sm-2 control-label">实验室楼</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="labfool" >
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">实验室名字</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="labname"   >
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">实验室可容纳人数</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="labnum"  >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">已占用人数</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="labzyrs" value="0"  disabled >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">实验室描述</label>
            <div class="col-sm-3">
                <input class="form-control" id="labsc"></input>
                <span class="help-block"></span>
            </div>
        </div>

        <button type="button" class="btn btn-default" style="margin-left: 17%;width: 23%" id="tj"  > 提交</button>
        <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>
<script>
    //校验表单
    function show_data_from() {
        var num = $('#labnum').val();
        var num1 = $('#labzyrs').val();
        if(parseInt(num1) > parseInt(num) ){
            show_validate_msg("#labzyrs","error","已占用人数不能超过总人数");
            return false;
        }
        return  true;
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
    $('#tj').click(function () {
        var labfool1 = $('#labfool').val();
        var labname1 =  $('#labname').val();
        var labnum1 =  $('#labnum').val();
        var labsykj1 =  $('#labzyrs').val();
        var labdes1 =  $('#labsc').val();
        if(!show_data_from()){
            return false;
        }
        $.ajax({
            url:'${ctx}/addlab',
            type:'POST',
            dataType:'json',
            data:{labfool:labfool1,labname:labname1,labnum:labnum1,labsykj:labsykj1,labdes:labdes1},
            success:function (response) {
                if (response.code == 0){
                    window.location.href = '${ctx}/clock';
                } else {
                    layer.open({
                        title: '信息'
                        ,content: response.msg
                    });
                }
            }
        })

    })
</script>
</body>
</html>