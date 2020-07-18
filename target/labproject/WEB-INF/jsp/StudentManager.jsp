<%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/22.
@time 11:02.
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
    <title>学生管理</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js" charset="utf-8"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<blockquote class="layui-elem-quote">修改学生信息直接在表格中编辑即可！导入学生账号和密码都为学号！</blockquote>
<button  type="button" class=" layui-btn layui-btn-normal " style="margin-left: 35%" onclick="location.reload()" >
    <i class=" layui-icon-refresh layui-icon" >刷新</i>
</button>
<button type="button" class="layui-btn layui-btn-normal" onclick="addonestudent()">
    <i class="layui-icon-addition layui-icon">单条添加</i>
</button>
<button type="button" class="layui-btn layui-btn-normal" id="test8">
    <i class="layui-icon-file-b layui-icon">选择文件</i>
</button>
<input class="layui-upload-file" type="file" accept=".xls,.xlsx" name="file">
<button type="button" class="layui-btn" id="test9">
    <i class="layui-icon-upload layui-icon">开始上传</i>
</button>
<button type="button" class="layui-btn layui-btn-normal" onclick="downAll()">
    <i class="layui-icon-export layui-icon">全部下载</i>
</button>
<table id="demo" lay-filter="test"></table>

<%--<nav aria-label="Page navigation" style="margin-top: -20px">--%>
<%--    <ul class="pagination">--%>
<%--        <li>--%>
<%--            <a href="#" aria-label="Previous">--%>
<%--                <span aria-hidden="true">&laquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--        <li><a href="#">1</a></li>--%>
<%--        <li><a href="#">2</a></li>--%>
<%--        <li><a href="#">3</a></li>--%>
<%--        <li><a href="#">4</a></li>--%>
<%--        <li><a href="#">5</a></li>--%>
<%--        <li>--%>
<%--            <a href="#" aria-label="Next">--%>
<%--                <span aria-hidden="true">&raquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>

<div id="addstudent" style="display: none">
    <div class="form-horizontal" style="margin-top: 25px">
        <div class="form-group">
            <label class="col-sm-3 control-label">ID</label>
            <div class="col-sm-5">
                <input class="form-control"  type="text" placeholder="请输入学号!" id="userId"></input>
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-3 control-label">密码</label>
            <div class="col-sm-5">
                <input class="form-control"  type="text" id="userPassword" placeholder="请输入密码，为4-15位数字和字母的组合!"  >
                <span class="help-block"></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">姓名</label>
            <div class="col-sm-5">
                <input class="form-control"  type="text" id="userName" placeholder="请输入姓名，为2~5位中文汉字！" >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">学院</label>
            <div class="col-sm-5">
                <input class="form-control"  type="text" id="userFaculty" placeholder="请输入学院"  >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">班级</label>
            <div class="col-sm-5">
                <input class="form-control"  type="text" id="userCalss" placeholder="请输入班级"  >
                <span class="help-block"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">手机号</label>
            <div class="col-sm-5">
                <input class="form-control"  type="text" id="userPhone" placeholder="请输入手机号"  >
                <span class="help-block"></span>
            </div>
        </div>
        <button type="button" class="btn btn-default" style="margin-left: 45%;width: 20%" id="tj"> 提交</button>
        <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>

layui.use(['form', 'layer', 'util', 'transfer', 'element','table','upload'], function () {
    var form = layui.form
        , layer = layui.layer
        , util = layui.util
        , transfer = layui.transfer
        , table = layui.table
        , element = layui.element
        , upload = layui.upload;

        //第一个实例
        table.render({
            elem: '#demo'
            ,url: '${ctx}/studentdata' //数据接口
            ,dataType:'json'
            ,type:'POST'
            ,page: {
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
            }//开启分页
            ,hash:true
            ,cols: [[ //表头
                {field: 'userId', title: 'ID', width:160, sort: true, fixed: 'left',edit: 'text'}
                ,{field: 'userName', title: '用户名', width:90,edit: 'text'}
                ,{field: 'userPassword', title: '密码', width:160,edit: 'text'}
                ,{field: 'userCalss', title: '班级', width:160,edit: 'text'}
                ,{field: 'userFaculty', title: '学院', width: 187,edit: 'text'}
                ,{field: 'userPhone', title: '手机号', width: 187,edit: 'text'}
                ,{field: 'roleName', title: '角色', width: 90}
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if(layEvent === 'detail'){ //查看
                //do somehing
                layer.alert("查看"+"----"+data)
                console.log(data)
                console.log(data.userId)
            } else
            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除本条信息么？', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url:'${ctx}/deletestudent',
                        type:'POST',
                        dataType:'json',
                        data:{userid:data.userId},
                        success:function (response) {
                            console.log(response)
                        }
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                //do something

                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    ,title: 'xxx'
                });
            } else if(layEvent === 'LAYTABLE_TIPS'){
                layer.alert('Hi，头部工具栏扩展的右侧图标。');
            }
        });
        table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
            console.log(obj.value); //得到修改后的值
            console.log(obj.field); //当前编辑的字段名
            console.log(obj.data); //所在行的所有相关数据
            // console.log(obj.data.userId);
            var userid = obj.data.userId;
            var username = obj.data.userName;
            var userps = obj.data.userPassword;
            var userclas = obj.data.userCalss;
            var userfac = obj.data.userFaculty;
            var userphone = obj.data.userPhone;

            // console.log(userid);
            $.ajax({
                url:'${ctx}/updateStudent',
                dataType:'json',
                data:{userid:userid,userps:userps,username:username,userfac:userfac,userclass:userclas,userphone:userphone},
                success:function (response) {
                    console.log(response)
                }
            })

        });
    //选完文件后不自动上传

    var loading;
    upload.render({
        elem: '#test8'
        ,url: '${ctx}/importstudentdata'
        ,accept: 'file' //普通文件
        ,acceptMime: '.xls,.xlsx'
        ,exts: 'xls|xlsx'
        ,auto: false
        //,multiple: true
        ,bindAction: '#test9'
        ,before: function(obj){         //loading.....
            loading=layer.msg("正在导入数据，请稍后......", {icon: 16}); //上传loading
        }
        ,done: function(result){//返回值接收
            console.log(result)
          if(result.code == 0 ){
              layer.close(loading);
              layer.msg("导入成功！",{icon:6});
          }else {
                layer.close(loading);
                layer.msg(result.msg,{icon:6});
            }
        },error:function (index,upload) {
            console.log(upload);
            layer.close(loading);
            layer.msg("导入成功！请刷新",{icon:6});
        }
    });
    });

    //下载
    function downAll() {
        window.location.href = '${ctx}/exportUserAllList';
    }
//校验表单数据
function validate_add_form(){
    var userid = $('#userId').val();
    var userPassword = $('#userPassword').val();
    var userName = $('#userName').val();
    var userPhone = $('#userPhone').val();

    var regid = /^[0-9]$/;
    var regName =/^[\u4E00-\u9FA5]{2,4}$/;//用户名的正则表达式
    var regPassword =/^[A-Za-z0-9]{4,15}$/ ;//密码的正则表达式
    var regPhone = /^1(3|4|5|6|7|8|9)\d{9}$/ ;//手机号的正则表达式

    // //校验id
    // if(!regid.test(userid)){
    //     show_validate_msg("#userId","error","学号必须为纯数字!");
    //     return false;
    // }else {
    //     show_validate_msg("#userId","success","");
    // }
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
    function addonestudent() {
        var layer = layui.layer;
        layer.open({
            type: 1
            , title: '增加学生信息' //不显示标题栏
            , area: ['700px', '500px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 0 //拖拽模式，0或者1
            , content: $('#addstudent')
        });

        $('#tj').on('click',function () {

            if(!validate_add_form()){
                return false;
            }
            var userId = $('#userId').val();
            var userPassword = $('#userPassword').val();
            var userName = $('#userName').val();
            var userFaculty = $('#userFaculty').val();
            var userCalss = $('#userCalss').val();
            var userPhone = $('#userPhone').val();

            $.ajax({
                url:'${ctx}/addUser',
                type:'POST',
                data:{userid:userId,userpas:userPassword,userna:userName,userfa:userFaculty,userca:userCalss,userph:userPhone},
                success:function (response) {
                    if(response.code == 0){
                        window.location.href = '${ctx}/8';
                        // alert(response.msg);
                    }else if(response.code == 1){
                        $('#msg').text(response.msg);
                    }
                }
            })

        })
    }




</script>
</body>
</html>
