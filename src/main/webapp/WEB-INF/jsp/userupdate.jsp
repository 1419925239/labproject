<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/18.
@time 15:38.
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
    <title>个人信息</title>
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
            <label class="col-sm-2 control-label">ID</label>
            <div class="col-sm-3">
                <p class="form-control-static" id="userId">${user2.userId}</p>
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">密码</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="userPassword" placeholder="${user2.userPassword}" value="${user2.userPassword}" >
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="userName" placeholder="${user2.userName}" value="${user2.userName}" >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学院</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="userFaculty" placeholder="${user2.userFaculty}" value="${user2.userFaculty}" >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">班级</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="userCalss" placeholder="${user2.userCalss}" value="${user2.userCalss}" >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">手机号</label>
            <div class="col-sm-3">
                <input class="form-control"  type="text" id="userPhone" placeholder="${user2.userPhone}" value="${user2.userPhone}" >
                <span class="help-block"></span>
            </div>
        </div>
         <button type="button" class="btn btn-default" style="margin-left: 17%" id="tj"> 提交</button>
        <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>
<script>
    layui.use('layer', function () {
        var layer = layui.layer;
    });

    //校验表单数据
    function validate_add_form(){

        var userPassword = $('#userPassword').val();
        var userName = $('#userName').val();
        var userPhone = $('#userPhone').val();

        var regName =/^[\u4E00-\u9FA5]{2,4}$/;//用户名的正则表达式
        var regPassword =/^[A-Za-z0-9]{4,15}$/ ;//密码的正则表达式
        var regPhone = /^1(3|4|5|6|7|8|9)\d{9}$/ ;//手机号的正则表达式

        //校验密码
        if(!regPassword.test(userPassword)){
            //alert("密码必须为4-15位数字和字母的组合!");
            show_validate_msg("#userPassword","error","密码必须为4-15位数字和字母的组合!");
            return false;
        }else {
            show_validate_msg("#userPassword","success","");
        }

        //校验姓名
        if(!regName.test(userName)){
            show_validate_msg("#userName","error","姓名必须为2~5位中文汉字！");
            return false;
        }else {
            show_validate_msg("#userName","success","");
        }
        //校验手机号
        if (!regPhone.test(userPhone)){
            //alert("手机号有误，请重新填写!")
            show_validate_msg("#userPhone","error","手机号有误，请重新填写!");
            return false;
        }else {
            show_validate_msg("#userPhone","success","");
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
        $('#tj').on('click',function () {

            if(!validate_add_form()){
                return false;
            }
            var userId = ${user2.userId};
            var userPassword = $('#userPassword').val();
            var userName = $('#userName').val();
            var userFaculty = $('#userFaculty').val();
            var userCalss = $('#userCalss').val();
            var userPhone = $('#userPhone').val();

            $.ajax({
                url:'${ctx}/updateUser',
                type:'POST',
                data:{userid:userId,userpas:userPassword,userna:userName,userfa:userFaculty,userca:userCalss,userph:userPhone},
                success:function (response) {
                    if(response.code == 0){
                        layer.open({
                            title:'信息',
                            content: '修改成功!',
                            yes: function(index, layero){
                                //do something
                                window.location.href = parent.location.reload();
                                layer.close(index); //如果设定了yes回调，需进行手工关闭
                            }
                        });
                        // alert(response.msg);
                    }else if(response.code == 1){
                        $('#msg').text(response.msg);
                    }
                }
            })

        })

</script>
</body>
</html>
