<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/2.
@time 21:05.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>

    <title>登录页面</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body style="margin:0;padding:0; overflow-x:hidden ">
<%--顶部--%>
<div class="row">

    <nav class="navbar" style="background:rgb(5,108,174)" >
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="col-xs-12 col-md-12">
        <div class="navbar-header">
            <a class="navbar-brand"  style="color: white;">&nbsp;&nbsp;欢迎登录实验室预约管理系统</a>
        </div>
        </div>
    </nav>


</div>
<%--主题--%>
<div class="row" style="background: rgb(21,120,174); margin-top: -20px;  ">

    <div class="col-xs-12 col-md-12">
        <div class="col-xs-3 col-md-3">

        </div>
        <div class="col-xs-6 col-md-6" style="text-align: center;">
            <div style="margin-top: 70px">
                <img class="img-responsive" src="${ctx}/static/image/loginlogo.png">
            </div>
        </div>
        <div class="col-xs-3 col-md-3">

        </div>
    </div>

    <div class="col-lg-12 col-md-12" style="background: rgb(21,120,174); height: 69%">
        <div class="col-lg-2 col-md-2">

        </div>
        <div class="col-lg-8 col-md-8" style=" margin-top: 35px;">
            <div class="col-lg-9 col-lg-offset-2 col-md-9 col-md-offset-0"  style="width: 100%;height: 100%;-moz-background-size:100% 100%;background-image: url(${ctx}/static/image/logininfo.png); background-repeat: no-repeat; ">
                <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3" style="margin-top: 12%;">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label  class="col-sm-2 col-md-5 col-lg-2 control-label">用户名</label>
                            <div class="col-sm-10 col-md-7 col-lg-7">
                                <input type="text" id="input_id" class="form-control"   placeholder="请输入用户名">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 col-md-5 col-lg-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                            <div class="col-sm-10 col-md-7 col-lg-7">
                                <input type="password" id="input_pass" class="form-control"  placeholder="请输入密码">
                                <span class="help-block"></span>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10 col-md-offset-4 col-md-6 col-lg-offset-1 col-lg-7">
                                <button type="button" id="login" class="btn btn-default btn-block " >登录</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-2 col-md-2">

        </div>
    </div>

</div>
<%--底部--%>
<div class="row">
    <div class="col-xs-12 col-md-12" style="background: rgb(64,143,187);text-align: center;">
        <p class="text-capitalize" style="margin-top: 0.5%;">技术支持:13569447017@163.com<a href="http://www.miit.gov.cn/">豫ICP备18032236号-2</a></p>
    </div>
</div>

<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use('layer', function () {
        var layer = layui.layer;
    });
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
    function validate_add_form(){
        var userid = $('#input_id').val();
        var regid = /^\d{11}|\d{13}$/;
        //校验id
        if(!regid.test(userid)){
            show_validate_msg("#input_id","error","学号必须为纯数字!");
            return false;
        }else {
            show_validate_msg("#input_id","success","");
        }

        return true;
    }

        $('#login').on("click",function () {
            var name = $('#input_id').val();
            var password = $('#input_pass').val();
            $.ajax(
                {
                    url:"${ctx}/login",
                    type:"POST",
                    data:{username:name,passwords:password},
                    success:function (response) {
                        console.log(response)
                        if(response.code== 0){
                            window.location.href = '${ctx}/success';
                        }
                        else {
                            layer.msg(response.msg, {icon: 5});
                        }
                    }
                }
            );
        })

</script>


</body>

</html>
