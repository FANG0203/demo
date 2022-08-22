<%--
  Created by IntelliJ IDEA.
  User: Fang
  Date: 2022/5/19
  Time: 10:17
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
                <td>申请人编号</td>
                <td>申报人</td>
                <td>申请人生日</td>
                <td>性别</td>
                <td>工作年限</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${currentApplicantList}" var="applicant">
                <tr>
                    <td>
                        <input type="checkbox" id="">
                    </td>
                    <td>${applicant.acId}</td>
                    <td>${applicant.acName}</td>
                    <td>${applicant.acBirthday}</td>
                    <td>${applicant.acSex}</td>
                    <td>${applicant.workinglife}</td>
                    <td>
                        <button type="button" class="btn btn-primary" id="update_">编辑</button>
                        <button type="button" class="btn btn-danger" id="del_">删除</button>
                    </td>
                </tr>
            </c:forEach>
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
</html>

