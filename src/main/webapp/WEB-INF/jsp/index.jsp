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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>

<head>

    <title>首页</title>
    <%-- 引入jQuery   --%>
    <script  src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script  src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" style="background-color: rgb(5,108,174);">
        <div class="layui-logo" style="color: white;">
            <img src="${ctx}/static/image/loginlogo.png " style="width: 150%;height: 100%;">
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" id="id1">
                </a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" id="role1">
                </a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" id="username1">
                </a>
            </li>
            <li class="layui-nav-item"><a href="${ctx}/logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side " style="background-color: rgb(21,120,174)" >

        <div class="layui-side-scroll" >
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree " style="background-color: rgb(21,120,174)"  id="mune1"    >
            </ul>
        </div>
    </div>

    <div class="layui-body" style="background-color: #d2d2d2; overflow: auto; ">
        <!-- 内容主体区域 -->
        <div   style="padding: 15px;">
            <iframe
                    src="${ctx}/clock"
                    frameborder="0"
                    scrolling="no"
                    id="main-body"
                    name="main-body"
                    width="100%"
                    height="100%"
                    overflow="auto"
                    >
            </iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        技术支持:13569447017@163.com
        <a href="http://www.miit.gov.cn/">豫ICP备18032236号-2</a>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script src="${ctx}/static/art-template/template-web.js"></script>

<script id="tpl-menu" type="text/html">
{{each menuList menu}}
        <li class="layui-nav-item ">
            <a class=""  >{{menu.text}}</a>
            {{each menu.nodes sub_menu}}
            <dl class="layui-nav-child">
                <dd><a id="gn" href="javascript:;" url="${ctx}/{{sub_menu.id}}">{{sub_menu.text}}</a></dd>
            </dl>
            {{/each}}
        </li>
{{/each}}
</script>

<script>
    layui.use(['laytpl','element'], function(){
        var laytpl = layui.laytpl;
        var element = layui.element;
    });

    //JavaScript代码区域
        $.ajax({
            url:'${ctx}/menu',
            type:'GET',
            dataType:'json',
            async: false,
            success:function (response) {

                var html = template('tpl-menu', {
                    menuList: response.data
                });
                document.getElementById('mune1').innerHTML = html;
                $('#username1').html(response.name);
                $('#role1').html(response.role.substring(1,response.role.length-1));
                $('#id1').html(response.id);

                $('.layui-nav-child dd a').click(function () {
                    $('.layui-nav-child a').removeClass('active');
                    var url = $(this).attr('url');
                    if (url) {
                        $('#main-body').attr('src', url);
                    }
                })


            }
        });


</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>


