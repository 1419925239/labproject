<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
@author 张占恒.
@date 2020/2/24.
@time 15:03.
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
    <title>预约实验页面</title>
    <%-- 引入jQuery   --%>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <%--   引入样式 --%>
    <script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
</head>
<body style="background-color: #d2d2d2; ">
<div class="layui-tab layui-tab-card">
    <ul class="layui-tab-title">
        <li class="layui-this">个人预约</li>
        <li>课堂预约</li>
        <li>开放型预约</li>
    </ul>
    <div class="layui-tab-content" style="height: 100%;">
<%--        个人预约--%>
        <div class="layui-tab-item layui-show">
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-xs-4">
                        <div class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">实验室</label>
                            <div class="layui-input-block">
                                <select name="labname" id="labname" lay-filter="labname" >
                                    <option selected="selected">请选择</option>
                                    <c:forEach items="${labname}" var="labname">
                                        <option>${labname.labinformationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="col-xs-2">
                        <button  class="layui-btn layui-btn-radius layui-btn-normal" onclick="tj1()">查询</button>
                    </div>
                </div>
            </div>
    <%--        显示所有实验室的排期表--%>
            <div class="row" style="overflow: auto;">
                <div class="col-xs-12">
                    <div id="scheduleview" style="height: 75%"></div>
                </div>
            </div>
    <%--        出现所有的实验室的排期信息，然后点击选择就弹出预约框框--%>
                                <div style="display: none;overflow: paged-y" id="syxxtx">
                                    <div class="layui-container" style="margin-top: 5%">
                                        <div class="row">
                                            <div class=" col-sm-12 form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">院系</label>
                                                    <div class="col-sm-5">
                                                        <input class="form-control" value="${user1.userFaculty}"  type="text" id="yuanxi"  disabled>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-sm-2 control-label">姓名</label>
                                                    <div class="col-sm-5">
                                                        <input class="form-control" value="${user1.userName}"  type="text" id="xingming"  disabled>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">指导老师</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"    id="zhidaolaos" >
                                                            <c:forEach items="${teacherName}" var="teachername">
                                                                <option>${teachername.userName}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">实验名</label>
                                                    <div class="col-sm-5">
                                                        <input class="form-control" placeholder="请输入内容"   id="shiyanming"   >
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">实验类型</label>
                                                    <div class="col-sm-5">
                                                        <input class="form-control" value="开放型"   id="shiyanleixing" disabled>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">实验目的</label>
                                                    <div class="col-sm-5">
                                                        <textarea class="form-control" placeholder="请输入内容" id="shiyanmudi"></textarea>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">实验步骤</label>
                                                    <div class="col-sm-5">
                                                        <textarea class="form-control" placeholder="请输入内容" id="shiyanbuzhou"></textarea>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">实验所需设备</label>
                                                    <div class="col-sm-5">
                                                        <textarea class="form-control" placeholder="请输入内容" id="shiyanshebei"></textarea>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">实验室</label>
                                                    <div class="col-sm-5">
                                                        <input class="form-control" placeholder="请输入内容" id="shiyanshi" disabled></input>
                                                        <span class="help-block"></span>
                                                    </div>
                                                </div>
                                                <button type="button" class="btn btn-default" style="margin-left: 37%;width: 20%" id="tijiao"    > 提交</button>
                                                <h3><span class="text-danger" style="margin-left: 17%" id="msg"></span></h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
        </div>
    <%--        课堂预约--%>
         <div class="layui-tab-item">

    <%--选择实验楼，选择实验室，出来对应实验室有的实验信息，然后可以点击预约--%>
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-xs-8">
                     <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">实验楼</label>
                            <div class="layui-input-block">
                                <select name="interest1" id="labinformationFloor" lay-filter="labinformationFloor" onclick="clickfloor()">
                                    <option selected="selected">请选择</option>
                                    <c:forEach items="${labfloor}" var="floor">
                                        <option value="${floor.labinformationFloor}">${floor.labinformationFloor}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">实验室</label>
                            <div class="layui-input-block">
                                <select name="interest2" id="labinformationName" lay-filter="labinformationName" >
                                    <option selected="selected">请选择</option>
                                </select>
                            </div>
                        </div>
                     </form>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn layui-btn-normal" lay-filter="*" name="chaxun" onclick="chaxun()" >查询</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

                <div class="row" style=" overflow: auto;">
                    <div class="col-xs-12">
                        <div id="tableview" style="height: 75%"></div>
                    </div>
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

            </div>
<%--    开放型预约--%>
        <div class="layui-tab-item">
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-xs-8">
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">实验楼</label>
                                <div class="layui-input-block">
                                    <select name="interest1" id="labinformationFloor1" lay-filter="labinformationFloor1" onclick="clickfloor1()">
                                        <option selected="selected">请选择</option>
                                        <c:forEach items="${labfloor}" var="floor">
                                            <option value="${floor.labinformationFloor}">${floor.labinformationFloor}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">实验室</label>
                                <div class="layui-input-block">
                                    <select name="interest2" id="labinformationName1" lay-filter="labinformationName1" >
                                        <option selected="selected">请选择</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn layui-btn-normal" lay-filter="*" name="chaxun" onclick="chaxun1()" >查询</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style=" overflow: auto;">
                <div class="col-xs-12">
                    <div id="tableview1" style="height: 75%"></div>
                </div>
            </div>
            <div id="gerenshenqing1" style="display: none">
                <div class="layui-container" style="margin-top: 5%">
                    <div class="row">
                        <div class=" col-sm-12 form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">院系</label>
                                <div class="col-sm-5">
                                    <input class="form-control"   type="text" id="gerenyuanxi1"  disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">指导老师</label>
                                <div class="col-sm-5">
                                    <input class="form-control" type="text" id="gerenxingming1"  disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验名</label>
                                <div class="col-sm-5">
                                    <input class="form-control" type="text" id="gerenshiyanming1"  disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验室</label>
                                <div class="col-sm-5">
                                    <input class="form-control"  id="gerenshiyanshi1" disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验类型</label>
                                <div class="col-sm-5">
                                    <input class="form-control"    id="gerenshiyanleixing1"  disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验目的</label>
                                <div class="col-sm-5">
                                    <textarea style="resize: none;"  class="form-control"    id="gerenshiyanmudi1" disabled></textarea>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验步骤</label>
                                <div class="col-sm-5">
                                    <textarea class="form-control"  id="gerenshiyanbuzhou1" style="resize: none;"  disabled></textarea>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验日期</label>
                                <div class="col-sm-5">
                                    <input class="form-control"  id="gerenshiyanriqi1" disabled>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">实验时间</label>
                                <div class="col-sm-5">
                                    <select class="form-control" placeholder="请输入内容" id="gerenshiyanshijian1">
                                        <option value="1">9:00~11:00am</option>
                                        <option value="2">15:00~17:00am</option>
                                        <option value="3">20:00~22:00am</option>
                                    </select>
                                    <span class="help-block"></span>
                                </div>
                            </div>

                            <button type="button" class="btn btn-default" style="margin-left: 37%;width: 20%" id="gerentijiao1"    > 提交</button>
                            <h3><span class="text-danger" style="margin-left: 17%" id="msg11"></span></h3>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="${ctx}/static/layui/layui.js" charset="utf-8"></script>
<script id="demo" type="text/html">
    <table class="table" id="test1">
        <thead>
        <tr>
            <th></th>
            {{# layui.each(d.pqdate,function(index,item){ }}
            <th id="{{index}}">{{ item }}</th>
            {{#  }); }}
        </tr>
        </thead>

        <tbody>
        <tr>
            {{# layui.each(d.labdate,function(index,item){ }}
            <th id="syshi" rowspan="6" style="vertical-align: middle">{{item.labinformationName}}</th>
            {{#  }); }}

            {{# layui.each(d.t1,function(index,item){ }}
            <td >{{ item }}</td>
            {{#  }); }}
        </tr>
        <tr>
            {{# layui.each(d.kj1,function(index,item){ }}
            <td  height="50px">
                空闲：{{item.num}}占用：{{item.labonesche}}&nbsp;&nbsp;&nbsp;&nbsp;
                {{#  if( item.labonesche != item.num){ }}
                <button  class="layui-btn  layui-btn-sm " onclick="sqzhaoshang('{{index}}','1')" >申请</button>
                {{#  } }}
            </td>
            {{#  }); }}
        </tr>
        <tr>
            {{# layui.each(d.t2,function(index,item){ }}
            <td>{{ item }}</td>
            {{#  }); }}

        </tr>
        <tr>
            {{# layui.each(d.kj2,function(index,item){ }}
            <td id="xiawu"  height="50px">
                空闲：{{item.num}}占用：{{item.labtwosche}}&nbsp;&nbsp;&nbsp;&nbsp;
                {{#  if( item.labtwosche != item.num){ }}
                <button  class="layui-btn  layui-btn-sm " onclick="xiawu('{{index}}','2')" >申请</button>
                {{#  } }}
            </td>
            {{#  }); }}
        </tr>
        <tr>
            {{# layui.each(d.t3,function(index,item){ }}
            <td>{{ item }}</td>
            {{#  }); }}
        </tr>
        <tr>
            {{# layui.each(d.kj3,function(index,item){ }}
            <td id="wanshang"  height="50px">
                空闲：{{item.num}}占用：{{item.labthreesche}}&nbsp;&nbsp;&nbsp;&nbsp;
                {{#  if( item.labthreesche != item.num){ }}
                <button  class="layui-btn  layui-btn-sm " onclick="wanshang('{{index}}','3')" >申请</button>
                {{#  } }}
            </td>
            {{#  }); }}
        </tr>
        </tbody>
    </table>
</script>
<script id="demo1" type="text/html">
    <blockquote class="layui-elem-quote">绿色代表当前实验所处时间段！</blockquote>
    <table class="layui-table">
        <thead>
        <tr>
            <th>实验名</th>
            <th>指导老师</th>
            <th>实验日期</th>
            <th colspan="2">9:00~11:00am</th>
            <th colspan="2">15:00~17:00pm</th>
            <th colspan="2">20:00~22:00pm</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        {{#
            var newda = function(){
                return (new Date()).valueOf();
            }
        }}
        {{#  layui.each(d.data, function(index, item){ }}
         {{#  if(d.shuju == item.labinformationName ) { }}
            {{# if(item.expinformationType === "课堂型" && item.roleName != "[学生]" ){ }}

                    <tr >
                        <td>{{ item.expinformationName }}</td>
                        <td>{{ item.expinformationTeacherName }}</td>
                        <td>{{ item.scheduledate }}</td>
                        {{# if(item.reserDatatime === 1 ) { }}
                        <td style="background-color: green;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: green;color: white">占用:{{ item.t1 }}</td>
                        <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: red;color: white">占用:{{ item.t2 }}</td>
                        <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: red;color: white">占用:{{ item.t3 }}</td>
                        {{# } else if(item.reserDatatime === 2){ }}
                        <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: red;color: white">占用:{{ item.t1 }}</td>
                        <td style="background-color: green;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: green;color: white">占用:{{ item.t2 }}</td>
                        <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: red;color: white">占用:{{ item.t3 }}</td>
                        {{# } else if(item.reserDatatime === 3){ }}
                        <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: red;color: white">占用:{{ item.t1 }}</td>
                        <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: red;color: white">占用:{{ item.t2 }}</td>
                        <td style="background-color: green;color: white">空闲:{{ item.labinformationNum }}</td>
                        <td style="background-color: green;color: white">占用:{{ item.t3 }}</td>
                        {{# } }}
                        {{# if(item.t1 < item.labinformationNum && item.t2 < item.labinformationNum &&  item.t3 < item.labinformationNum) { }}
                        <td><a href="javascript:;" onclick="
                        ketangshenqing(
                            '{{ item.expinformationFaculty }}',
                            '{{ item.expinformationTeacherName }}',
                            '{{ item.expinformationName }}',
                            '{{ item.labinformationName }}',
                            '{{ item.expinformationType }}',
                            '{{ item.expinformationPurpose }}',
                            '{{ item.expinformationStep }}',
                            '{{ item.scheduledate }}',
                            '{{ item.expinformationId }}',
                            '{{ item.scheduleId }}',
                            '{{ item. labinformationId }}',
                            )
                            ">申请</a></td>
                        {{# } }}
                    </tr>

            {{#  } }}
          {{#  } }}
        {{#  }); }}
        </tbody>
    </table>
    {{#  if(d.shuju === "" ){ }}
    {{#  } }}
</script>
<script id="demo2" type="text/html">
    <blockquote class="layui-elem-quote">绿色代表当前实验所处时间段！</blockquote>
    <table class="layui-table">
        <thead>
        <tr>
            <th>实验名</th>
            <th>指导老师</th>
            <th>实验日期</th>
            <th colspan="2">9:00~11:00am</th>
            <th colspan="2">15:00~17:00pm</th>
            <th colspan="2">20:00~22:00pm</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        {{#
        var newda = function(){
        return (new Date()).valueOf();
        }
        }}
        {{#  layui.each(d.data, function(index, item){ }}
        {{#  if(d.shuju == item.labinformationName ) { }}
        {{# if(item.expinformationType === "开放型" && item.roleName != "[学生]" ){ }}

        <tr >
            <td>{{ item.expinformationName }}</td>
            <td>{{ item.expinformationTeacherName }}</td>
            <td>{{ item.scheduledate }}</td>
            {{# if(item.reserDatatime === 1 ) { }}
            <td style="background-color: green;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: green;color: white">占用:{{ item.t1 }}</td>
            <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: red;color: white">占用:{{ item.t2 }}</td>
            <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: red;color: white">占用:{{ item.t3 }}</td>
            {{# } else if(item.reserDatatime === 2){ }}
            <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: red;color: white">占用:{{ item.t1 }}</td>
            <td style="background-color: green;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: green;color: white">占用:{{ item.t2 }}</td>
            <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: red;color: white">占用:{{ item.t3 }}</td>
            {{# } else if(item.reserDatatime === 3){ }}
            <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: red;color: white">占用:{{ item.t1 }}</td>
            <td style="background-color: red;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: red;color: white">占用:{{ item.t2 }}</td>
            <td style="background-color: green;color: white">空闲:{{ item.labinformationNum }}</td>
            <td style="background-color: green;color: white">占用:{{ item.t3 }}</td>
            {{# } }}
            {{# if(item.t1 < item.labinformationNum && item.t2 < item.labinformationNum &&  item.t3 < item.labinformationNum) { }}
            <td><a href="javascript:;" onclick="
                        kaifangshenqing(
                            '{{ item.expinformationFaculty }}',
                            '{{ item.expinformationTeacherName }}',
                            '{{ item.expinformationName }}',
                            '{{ item.labinformationName }}',
                            '{{ item.expinformationType }}',
                            '{{ item.expinformationPurpose }}',
                            '{{ item.expinformationStep }}',
                            '{{ item.scheduledate }}',
                            '{{ item.expinformationId }}',
                            '{{ item.scheduleId }}',
                            '{{ item. labinformationId }}'
                            )
                        ">申请</a></td>
            {{# } }}
        </tr>

        {{#  } }}
        {{#  } }}
        {{#  }); }}
        </tbody>
    </table>
    {{#  if(d.shuju === "" ){ }}
    {{#  } }}
</script>
<script>
    layui.use(['laytpl','element','form','layer'],function () {
        var laytpl = layui.laytpl;
        var form = layui.form;
        var element = layui.element;
        var layer = layui.layer;
    });

    //将时间戳转化为日期
    function timeFormat(dateStr) {
        var date = new Date(dateStr);
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate());
        return Y+M+D;
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
            layer.msg(msg, {icon: 5});
        }
    }
    //校验表单
    function validate_add_form(){
        var shiyanming = $('#shiyanming').val();
        var shiyanmudi = $('#shiyanmudi').val();
        var shiyanbuzhou = $('#shiyanbuzhou').val();
        var shiyanshebei = $('#shiyanshebei').val();
        if (shiyanming == ""){
            show_validate_msg("shiyanming","error","实验名不能为空！");
            return false;
        }else {
            show_validate_msg("shiyanming","success","")
        }

        if (shiyanmudi == ""){
            show_validate_msg("shiyanmudi","error","实验目的不能为空！");
            return false;
        }else {
            show_validate_msg("shiyanmudi","success","")
        }

        if (shiyanbuzhou == ""){
            show_validate_msg("shiyanbuzhou","error","实验步骤不能为空！");
            return false;
        }else {
            show_validate_msg("shiyanbuzhou","success","")
        }

        if (shiyanshebei == ""){
            show_validate_msg("shiyanshebei","error","实验设备不能为空！");
            return false;
        }else {
            show_validate_msg("shiyanshebei","success","")
        }

        return true;
    }
    //查询实验室的排期表
    function tj1() {
        var lab = $('#labname').val();
        if(lab == "请选择"){
            layer.open({
                title: '信息'
                ,content: "请选择实验室！"
            })
        }else {
        $.ajax({
            url:'${ctx}/selectBylabnameToschedu',
            type:'post',
            dataType:'json',
            data:{labname:lab},
            success:function (response) {
                console.log(response);
                var T1 = new Array();
                var T2 = new Array();
                var T3 = new Array();
                var kj = new Array();
                var kj1 = new Array();
                var kj2 = new Array();
                console.log(kj)
                for (i = 0;i<response.data[0].length;i++){
                    T1.push("9:00~11:00am");
                    T2.push("15:00~17:00pm");
                    T3.push("20:00~22:00pm");
                }
                var k = 0
                for (i = 0;i<response.data[0].length;i++) {
                    var sj1 = response.data[0][i];
                        if(k < response.data[1].length){
                            var sj2 = response.data[1][k].scheduleDate;
                        }
                        var sj3 = timeFormat(sj2);
                        if(sj1 == sj3 ){
                            kj.push({
                                num: response.data[2][0].labinformationNum,
                                labonesche: response.data[1][k].t1,
                            })
                            kj1.push({
                                num: response.data[2][0].labinformationNum,
                                labtwosche: response.data[1][k].t2,
                            })
                            kj2.push({
                                num: response.data[2][0].labinformationNum,
                                labthreesche: response.data[1][k].t3
                            })

                                k = k +1;

                        }else {
                            kj.push({
                                num: response.data[2][0].labinformationNum,
                                labonesche: 0,
                            })
                            kj1.push({
                                num: response.data[2][0].labinformationNum,
                                labtwosche: 0,
                            })
                            kj2.push({
                                num: response.data[2][0].labinformationNum,
                                labthreesche: 0
                            })
                        }



                }
                    var laytpl = layui.laytpl;
                    var data = {
                       "pqdate":response.data[0],
                       "schdate":response.data[1],
                       "labdate":response.data[2],
                        "t1":T1,
                        "t2":T2,
                        "t3":T3,
                        "kj1":kj,
                        "kj2":kj1,
                        "kj3":kj2
                            }
                    var getTpl = demo.innerHTML
                        ,view = document.getElementById('scheduleview');
                        laytpl(getTpl).render(data, function(html){
                        view.innerHTML = html;
                    });

            }
        })
        }
    }
    //获取过去或者未来时间
    function getLastOrNextFewDateBy(day){
        var today = new Date();
        var lastOrNextDate = today.getTime() + 1000 * 60 * 60 * 24 * day;
        today.setTime(lastOrNextDate);
        var year = today.getFullYear();
        var month = today.getMonth() + 1;
        var date = today.getDate();
        month = month < 10 ? '0' + month : month;
        date = date < 10 ? '0' + date : date;
        return year + "-" + month + "-" + date;
    }
    //打开预约表
    function dakaiyuyuebiao() {
        layer.open({
            type: 1
            , title: '申请实验' //不显示标题栏
            , area: ['700px', '500px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: $('#syxxtx')
        });
        var syshi = $('#syshi').html();
        $('#shiyanshi').val(syshi);
    }
    //转化日期
    function toriqi(x) {
        if(x == 0){
            var date = getLastOrNextFewDateBy(0);
            return date;
        }else if (x == 1){
            var date = getLastOrNextFewDateBy(1);
            return date;
        }else if(x == 2){
            var date = getLastOrNextFewDateBy(2);
            return date;
        }else if(x == 3){
            var  date = getLastOrNextFewDateBy(3);
            return date;
        }else if(x == 4){
            var date = getLastOrNextFewDateBy(4);
            return date;
        }
    }
    //提交按钮
    function fuzhi(riqi,shijian) {

        var yuanxi = $('#yuanxi').val();
        var xingming = $('#xingming').val();
        var zhidaolaos = $('#zhidaolaos').val();
        var shiyanming = $('#shiyanming').val();
        var shiyanleixing = $('#shiyanleixing').val();
        var shiyanmudi = $('#shiyanmudi').val();
        var shiyanbuzhou = $('#shiyanbuzhou').val();
        var shiyanshebei = $('#shiyanshebei').val();
        var shiyanshi = $('#shiyanshi').val();
        var date = toriqi(riqi);
        if(!validate_add_form()){
            return false;
        }

        $.ajax({
            url:'${ctx}/sqzhaoshang',
            type:'POST',
            dataType:'json',
            data:{
                Fac:yuanxi,
                Nam:xingming,
                teaname:zhidaolaos,
                expname:shiyanming,
                exptype:shiyanleixing,
                exppur:shiyanmudi,
                expins:shiyanbuzhou,
                expshebei:shiyanshebei,
                labna:shiyanshi,
                sch:date,
                dateduan:shijian,
                userid:${user1.userId}
            },
            success:function (response) {
                if(response.code == 0){
                    layer.open({
                        title: '信息'
                        ,content: '申请成功！'
                        ,yes:function (index,layero) {
                            window.location.href = '${ctx}/13';
                            layer.close(index)
                        }
                    });
                }else if (response.code == 1) {
                    layer.open({
                        title: '信息'
                        ,content: response.msg
                    });
                }
            }
        })
    }

    function sqzhaoshang(riqi,shijian){
        var syshi = $('#labname').val();
        var date = toriqi(riqi);
        $.ajax({
            url:'${ctx}/panduan',
            dataType:'json',
            type:'POST',
            async:false,
            data:{da1:date,datatime:shijian,sys:syshi},
            success:function (response) {
                if (response.code == 0){
                    dakaiyuyuebiao();
                    $('#tijiao').attr('onclick','fuzhi('+riqi+','+shijian+');');
                }else if(response.code == 1){
                    layer.msg(response.msg, {icon: 5});
                }
            }
        })

    }
    function  xiawu(riqi,shijian){
        var syshi = $('#labname').val();
        var date = toriqi(riqi);
        $.ajax({
            url:'${ctx}/panduan',
            dataType:'json',
            type:'POST',
            async:false,
            data:{da1:date,datatime:shijian,sys:syshi},
            success:function (response) {
                if (response.code == 0){
                    dakaiyuyuebiao();
                    $('#tijiao').attr('onclick','fuzhi('+riqi+','+shijian+');');
                }else if(response.code == 1){
                    layer.msg(response.msg, {icon: 5});
                }
            }
        })
    }
    function wanshang(riqi,shijian){
        var syshi = $('#labname').val();
        var date = toriqi(riqi);
        $.ajax({
            url:'${ctx}/panduan',
            dataType:'json',
            type:'POST',
            async:false,
            data:{da1:date,datatime:shijian,sys:syshi},
            success:function (response) {
                if (response.code == 0){
                    dakaiyuyuebiao();
                    $('#tijiao').attr('onclick','fuzhi('+riqi+','+shijian+');');
                }else if(response.code == 1){
                    layer.msg(response.msg, {icon: 5});
                }
            }
        })
    }
    function chaxun(){
        var shuju = $('#labinformationName').val();
        if( shuju == '请选择'){
            layer.open({
                title: '信息'
                ,content: "请选择实验室！"
            })
        }else {
            $.ajax({
                url:'${ctx}/viewBylabNametotable',
                type:'POST',
                dataType:'json',
                data:{shiyansh:shuju},
                success:function (response) {
                    console.log(response.data[2]);

                    var shiyanshidate = new Array();
                    for (i=0;i<response.data[1].length;i++){
                        shiyanshidate.push(response.data[1][i]);
                    }
                    console.log(shiyanshidate);

                    var laytpl = layui.laytpl;
                    var data = {
                        "shuju":response.data[2],
                        "data":shiyanshidate,
                    }
                    var getTpl = demo1.innerHTML
                        ,view = document.getElementById('tableview');
                    laytpl(getTpl).render(data, function(html){
                        view.innerHTML = html;
                    });
                }
            })
        }

    }
    function chaxun1(){
        var shuju = $('#labinformationName1').val();
        if( shuju == '请选择'){
            layer.open({
                title: '信息'
                ,content: "请选择实验室！"
            })
        }else {
            $.ajax({
                url:'${ctx}/viewBylabNametotable',
                type:'POST',
                dataType:'json',
                data:{shiyansh:shuju},
                success:function (response) {
                    console.log(response.data[2]);

                    var shiyanshidate = new Array();
                    for (i=0;i<response.data[1].length;i++){
                        shiyanshidate.push(response.data[1][i]);
                    }
                    console.log(shiyanshidate);

                    var laytpl = layui.laytpl;
                    var data = {
                        "shuju":response.data[2],
                        "data":shiyanshidate,
                    }
                    var getTpl = demo2.innerHTML
                        ,view = document.getElementById('tableview1');
                    laytpl(getTpl).render(data, function(html){
                        view.innerHTML = html;
                    });
                }
            })
        }

    }
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
    function sub1(expid,scheid,labid) {
        var shijianduan = $('#gerenshiyanshijian1').val();
        var shiyanriqi = $('#gerenshiyanriqi1').val();
        var userid = ${user1.userId};
        $.ajax({
            url:'${ctx}/kaifangshenqing',
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
            , title: '课堂实验申请' //不显示标题栏
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
    function kaifangshenqing(fac,teachername,expname,labname,expty,exppur,expste,sch,expid,scheid,labid){
        layer.open({
            type: 1
            , title: '开放实验申请' //不显示标题栏
            , area: ['700px', '500px']
            , shade: 0.8
            ,skin: 'yourclass'
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: $('#gerenshenqing1')
        });
        $('#gerenyuanxi1').val(fac);
        $('#gerenxingming1').val(teachername);
        $('#gerenshiyanming1').val(expname);
        $('#gerenshiyanshi1').val(labname);
        $('#gerenshiyanleixing1').val(expty);
        $('#gerenshiyanmudi1').val(exppur);
        $('#gerenshiyanbuzhou1').val(expste);
        $('#gerenshiyanriqi1').val(sch);
        $('#gerentijiao1').attr('onclick','sub1('+expid+','+scheid+','+labid+');');
    }
    layui.use('form', function(){
        var form = layui.form;
        form.on('select(labinformationFloor)',function (data) {
            console.log(data.value)
            if(data.value != null){
                $.ajax({
                    url:'${ctx}/selectfloorlab',
                    type:'POST',
                    dataType:'json',
                    data:{labfloor1:data.value},
                    success:function (response) {
                        $('#labinformationName').empty();
                        if(response.data.length != 0){
                            for(i =0;i<response.data.length;i++){
                                $('#labinformationName').append("<option>"+response.data[i]+"</option>");
                                console.log(response.data[i])
                            }
                            form.render();
                        }else {
                            $('#labinformationName').append("<option>请选择</option>");
                            form.render();
                        }

                    }
                })
            }
        })
        form.on('select(labinformationFloor1)',function (data) {
            console.log(data.value)
            if(data.value != null){
                $.ajax({
                    url:'${ctx}/selectfloorlab',
                    type:'POST',
                    dataType:'json',
                    data:{labfloor1:data.value},
                    success:function (response) {
                        $('#labinformationName1').empty();
                        if(response.data.length != 0){
                            for(i =0;i<response.data.length;i++){
                                $('#labinformationName1').append("<option>"+response.data[i]+"</option>");
                                console.log(response.data[i])
                            }
                            form.render();
                        }else {
                            $('#labinformationName1').append("<option>请选择</option>");
                            form.render();
                        }

                    }
                })
            }
        })
    });



</script>
</body>
</html>
