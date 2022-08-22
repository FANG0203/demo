<%--
  Created by IntelliJ IDEA.
  User: Fang
  Date: 2022/5/20
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--引入jstl的c标签--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--引入jstl的格式化--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--获取当前项目的路径--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
    //将path放到页作用域中,方便使用el表达式调用
    pageContext.setAttribute("app_path", path);
%>

<html>
<head>
    <title>项目首页</title>
    <%--  导入前端框架bootstrap的样式  --%>
    <link rel="stylesheet" href="${app_path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <%--  引入jQuery  --%>
    <script type="text/javascript" src="${app_path}/static/js/jquery-3.2.1.js"></script>
    <%--  引入前端框架bootstarp的js包 必须在jQuery的js包引用的后面(bootstrap的js包依赖jQuery的js包)  --%>
    <script type="text/javascript" src="${app_path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<%--最外层的架子----栅格系统--根据自己的需求自由组合格子的大小--%>
<div class="container-fluid">
    <%--第一行:标题行--%>
    <div class="row">
        <%--标题占一行12个格子--%>
        <div class="col-md-12">
            <h1>SSM-项目申报-Mrfang</h1>
        </div>
    </div>
    <%--第二行:新增删除行--%>
    <div class="row">
        <div class="col-md-2 col-md-offset-10">
            <button type="button" class="btn btn-success" id="projectInfo_add_btn">新增</button>
            <button type="button" class="btn btn-danger" id="projectInfo_delete_all_btn">删除</button>
        </div>
    </div>
    <%--第三行:数据展示行--%>
    <div class="row">
        <%--条纹状表格+鼠标条纹--%>
        <table class="table table-striped table-hover" id="projectInfos_table">
            <%--头部行--%>
            <thead>
            <%--行--%>
            <tr>
                <%--格子--%>
                <td>
                    <input type="checkbox" id="check_all">
                </td>
                <td>项目编号</td>
                <td>项目名称</td>
                <td>开始日期</td>
                <td>结束日期</td>
                <td>申报状态</td>
                <td>申报人</td>
                <td>性别</td>
                <td>工作年限</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody id="projectInfos_table tbody">

<%--            <c:forEach items="${currentprojectInfos}" var="projectInfo">--%>
<%--                <tr>--%>
<%--                        &lt;%&ndash;格子&ndash;%&gt;--%>
<%--                    <td>--%>
<%--                        <input type="checkbox" id="check_all_">--%>
<%--                    </td>--%>
<%--                    <td>${projectInfo.piId}</td>--%>
<%--                    <td>${projectInfo.piProjectname}</td>--%>
<%--                    <td><fmt:formatDate value="${projectInfo.piStartdate}" pattern="yyyy-MM-dd"/></td>--%>
<%--                    <td><fmt:formatDate value="${projectInfo.piEnddate}" pattern="yyyy-MM-dd"/></td>--%>
<%--                    <td>${projectInfo.piStatus}</td>--%>
<%--                    <td>${projectInfo.applicant.acName}</td>--%>
<%--                    <td>${projectInfo.applicant.acSex}</td>--%>
<%--                    <td>${projectInfo.applicant.workinglife}</td>--%>
<%--                    <td>--%>
<%--                        <button type="button" class="btn btn-primary" id="update_">编辑</button>--%>
<%--                        <button type="button" class="btn btn-danger" id="del_">删除</button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
            </tbody>
        </table>
    </div>
    <%--第四行:分页信息行--%>
    <div class="row">
        <%--  分页文字显示  --%>
        <div class="col-md-4 col-md-offset-2" id="page_info_area"></div>
        <%--  分页文字显示  --%>
        <div class="col-md-6" id="page_nav_area"></div>
    </div>
    <%--第五行:操作行--%>
    <div class="row">
        ...
    </div>

</div>
</body>
<script type="text/javascript">
    /* 1.页面加载完成后,直接发送一个Ajax请求,拿到分页数据 */
    $(function () {
        $.ajax({
            url: "${app_path}/projectInfos/",
            data: "pn=1",
            type: "GET",
            success: function (result) {
                console.log(result);
                //1.解析json并显示员工信息
                build_projectInfos_table(result);
            }
        });
    });

    function build_projectInfos_table(result) {
        //解析json数据,拿到其中的extend的值中的pageInfo中的list集合
        var projectInfos = result.extend.pageInfo.list;
        $.each(projectInfos, function (index, item) {
            //alter(item.empName);
            //获取item中的每一个属性信息
            var piIdTd = $("<td></td>").append(item.piId);
            var piProjectnameTd = $("<td></td>").append(item.piProjectname);
            var piStartdateTd = $("<td></td>").append(item.piStartdate);
            var piEnddateTd = $("<td></td>").append(item.piEnddate);
            var piStatusTd = $("<td></td>").append(item.piStatus);
            var acNameTd = $("<td></td>").append(item.applicant.acName);
            var acSexTd = $("<td></td>").append(item.applicant.acSex == 1 ? '男' : '女');
            var workinglifeTd = $("<td></td>").append(item.applicant.workinglife);
            $("<tr></tr>")
                .append(piIdTd)
                .append(piProjectnameTd)
                .append(piStartdateTd)
                .append(piEnddateTd)
                .append(piStatusTd)
                .append(acNameTd)
                .append(acSexTd)
                .append(workinglifeTd)
                .appendTo("#projectInfos_table tbody");
        });
    }

    function dateFarmat(fmt, date) {
        var o = {
            "M+": date.getMonth() + 1, //月份
            "d+": date.getDate(), //日
            "h+": date.getHours(), //小时
            "m+": date.getMinutes(), //分
            "s+": date.getSeconds(), //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }


    function build_page_info(result) {
        //构建分页信息之前,进行分页元素的清空
        $("#page_info_area").empty();
        //构建分页信息的数据
        $("#page_info_area").append("当前第 "
            + result.extend.pageInfo.pageNum + " 页,总共 "
            + result.extend.pageInfo.pages + " 页,总共 "
            + result.extend.pageInfo.total + " 条记录");
        totalCount = result.extend.pageInfo.pages;
        currentPage = result.extend.pageInfo.pageNum;
    }

    function build_page_nav(result) {
        //构建分页显示条前,清空分页显示条的导航区内容
        $("#page_nav_area").empty();
        //构建ul元素
        var ul = $("<ul></ul>").addClass("pagination");
        //构建元素
        //首页的元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        //上一页的元素
        var prePageLi =
            $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
        // …省略部分代码…
    }
</script>

</html>


