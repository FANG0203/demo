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
    <link rel="stylesheet" href="${app_path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>

    <%--  引入jQuery  --%>
    <script type="text/javascript" src="${app_path}/static/js/jquery-3.2.1.js"></script>

    <%--  引入前端框架bootstarp的js包 必须在jQuery的js包引用的后面(bootstrap的js包依赖jQuery的js包)  --%>
    <script type="text/javascript" src="${app_path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <%--解决浏览器为网页标题找不到资源加图标的报错--%>
    <link rel="shortcut icon" href="#"/>
</head>
<body onload="time()">
<%--------------------------------------------------------增加----------------------------------------------------------%>
<!-- 添加申报项目的模态框 -->
<div class="modal fade" id="projectInfoAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">项目申报</h4>
            </div>
            <div class="modal-body">
                <%--Bootstrap表单模块--%>
                <form class="form-horizontal">
                    <%--项目名称--%>
                    <div class="form-group">
                        <%--label标签的作用是为鼠标用户改进了可用性--%>
                        <label for="projectName_add_input" class="col-sm-2 control-label">ProjectName</label>
                        <div class="col-sm-10">
                            <%--placeholder="text文本框提示"--%>
                            <input type="text" name="piProjectname" class="form-control" id="projectName_add_input"
                                   placeholder="ProjectName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--  起始时间  --%>
                    <div class="form-group">
                        <label for="startDate_add_input" class="col-sm-2 control-label">StartDate</label>
                        <div class="col-sm-10">
                            <input type="date" name="piStartdate"
                                   class="form-control" id="startDate_add_input" placeholder="StartDate">
                        </div>
                    </div>
                    <%--  结束时间  --%>
                    <div class="form-group">
                        <label for="endDate_add_input" class="col-sm-2 control-label">EndDate</label>
                        <div class="col-sm-10">
                            <input type="date" name="piEnddate"
                                   class="form-control" id="endDate_add_input" placeholder="EndDate">
                        </div>
                    </div>
                    <%--  申报状态  --%>
                    <div class="form-group">
                        <label for="Status_add_input" class="col-sm-2 control-label">Status</label>
                        <div class="col-sm-6">
                            <!-- 状态显示和提交的值是不一样的 -->
                            <select class="form-control" name="piStatus" id="Status_add_input">
                                <option value="0">已申报</option>
                                <option value="1">审核中</option>
                                <option value="2">已审核</option>
                            </select>
                        </div>
                    </div>
                    <!-- 申报人列表 -->
                    <div class="form-group">
                        <label for="Applicant_add_input" class="col-sm-2 control-label">Applicant</label>
                        <div class="col-sm-6">
                            <!-- 内容是查询出来的名字,提交的值是申报人的acId编号 -->
                            <select class="form-control" name="acid" id="Applicant_add_input">
                            </select>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="projectInfo_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<%--------------------------------------------------------修改----------------------------------------------------------%>
<!-- 修改申报项目的模态框 -->
<div class="modal fade" id="projectInfoUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">项目申报编辑</h4>
            </div>
            <div class="modal-body">
                <!-- 模态框中的表单 -->
                <form class="form-horizontal">
                    <!-- 项目id -->
                    <div class="form-group">
                        <label for="projectId_update_static" class="col-sm-2 control-label">ProjectId</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="projectId_update_static"></p>
                        </div>
                    </div>

                    <!-- 项目名称 -->
                    <div class="form-group">
                        <label for="projectName_update_input" class="col-sm-2 control-label">ProjectName</label>
                        <div class="col-sm-10">
                            <input type="text" name="piProjectname"
                                   class="form-control" id="projectName_update_input" placeholder="ProjectName">
                        </div>
                    </div>

                    <%--  起始时间  --%>
                    <div class="form-group">
                        <label for="startDate_update_input" class="col-sm-2 control-label">StartDate</label>
                        <div class="col-sm-10">
                            <input type="date" name="piStartdate"
                                   class="form-control" id="startDate_update_input" placeholder="StartDate">
                        </div>
                    </div>
                    <%--  结束时间  --%>
                    <div class="form-group">
                        <label for="endDate_update_input" class="col-sm-2 control-label">EndDate</label>
                        <div class="col-sm-10">
                            <input type="date" name="piEnddate"
                                   class="form-control" id="endDate_update_input" placeholder="EndDate">
                        </div>
                    </div>
                    <%--  申报状态  --%>
                    <div class="form-group">
                        <label for="Status_update_input" class="col-sm-2 control-label">Status</label>
                        <div class="col-sm-6">
                            <!-- 状态显示和提交的值是不一样的 -->
                            <select class="form-control" name="piStatus" id="Status_update_input">
                                <option value="0">已申报</option>
                                <option value="1">审核中</option>
                                <option value="2">已审核</option>
                            </select>
                        </div>
                    </div>
                    <!-- 申报人列表 -->
                    <div class="form-group">
                        <label for="Applicant_update_input" class="col-sm-2 control-label">Applicant</label>
                        <div class="col-sm-6">
                            <!-- 内容是查询出来的名字,提交的值是申报人的acId编号 -->
                            <select class="form-control" name="acid" id="Applicant_update_input">
                            </select>
                        </div>
                    </div>

                </form>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="projectInfo_update_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<%--最外层的架子----栅格系统--根据自己的需求自由组合格子的大小--%>
<div class="container-fluid">
    <%--第一行:标题行--%>
    <div class="row">
        <%--标题占一行12个格子--%>
        <div class="col-md-10">
            <h1>SSM-项目申报-Mrfang</h1>
        </div>
        <div class="col-md-2 col-md-offset-9"> <time id="showtime"></time></div>
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
                <td>项目编号(#)</td>
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
            <tbody>

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

        <div class="col-md-2 col-md-offset-10" id="page_turn_area">
            <div class="input-group">
                <input type="text" onkeyup="value=value.replace(/^(0+)|[^\d]+/g),''" class="form-control"
                       placeholder="跳转到第n页" id="turn_to_page">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="button_go">Go!</button>
                    </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->

    </div>
</div>
</body>
</html>
<script type="text/javascript">
    /*
    * 设置实时显示当前日期，星期，时间
    * 并实现日期，星期与时间的格式
    * 日期 xxxx/xx/x
    * 星期 星期x
    * 时间 x/xx/xx
    * */
    function time(){
        var now = new Date();
        var t =document.getElementById('showtime');
        var min=now.getMinutes();
        var s=now.getSeconds();
        var week = new Array('日', '一', '二', '三', '四', '五', '六');
        var weekday = week[now.getDay()];
        if (min < 10) {
            min = "0" + min;
        }
        if (s < 10) {
            s = "0" + s;
        }
        t.innerHTML="&nbsp&nbsp&nbsp&nbsp"+now.getFullYear()+"/"+(now.getMonth() + 1)+"/"+now.getDate()+"<br/>"+
            "星期"+weekday+"&nbsp"+now.getHours()+":"+min+":"+s;
        setTimeout(time,1000);
    }
<%----------------------------------------------------------查询--------------------------------------------------------%>
    //全员总记录数 当前页面
    var totalCount, currentPage;
    /* 1.页面加载完成后,直接发送一个Ajax请求,拿到分页数据 */
    $(function () {
        //goToFirst
        to_page(1);
    });

    //跳转页数
    function to_page(pn) {
        $.ajax({
            url: "${app_path}/projectInfos/",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                // console.log(result);
                //解析json并显示员工信息
                build_projectInfos_table(result);
                //解析json并显示分页信息
                build_page_info(result);
                build_page_nav(result);
            }
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
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1)?(o[k]):(("00"+o[k]).substr((""+o[k]).length)));
        return fmt;
    }

       /*
        * 添加按钮的单击效果
        * 1.主页点击新增
        * 2.弹出对话框
        * 3.在数据库中查询出申报人的姓名，以下拉列表的形式展示在对话框中
        * 4.使用ajax进行异步访问，校验项目是否重复（在前端校验用户名是否合理）
        * 5.后端保证数据安全，再次校验JSR303
        *
        * */

    function build_projectInfos_table(result) {
        //清空数据，不然会叠加
        $("#projectInfos_table tbody").empty();

        //解析json数据,拿到其中的extend的值中的pageInfo中的list集合
        var projectInfos = result.extend.pageInfo.list;
        $.each(projectInfos, function (index, item) {
            //alter(item.empName);
            //获取item中的每一个属性信息

            //增加复选框
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            //编号格子
            var piIdTd = $("<td></td>").append(item.piId);
            var piProjectnameTd = $("<td></td>").append(item.piProjectname);
            /*
            *var piStartdateTd = $("<td></td>").append(item.piStartdate);
            *var piEnddateTd = $("<td></td>").append(item.piEnddate);
            * 格式化时间
            * dateFarmat("yyyy-MM-dd hh:mm:ss", new Date(item.piStartdate)
            * */
            var piStartdateTd = $("<td></td>").append(dateFarmat("yyyy-MM-dd", new Date(item.piStartdate)));
            var piEnddateTd = $("<td></td>").append(dateFarmat("yyyy-MM-dd", new Date(item.piEnddate)));
            //三目表达式的升级，可判断多重级
            var piStatusTd = $("<td></td>").append(item.piStatus == 0 ? '已申报' : item.piStatus == 1 ? '审核中' : '已审核');
            var acNameTd = $("<td></td>").append(item.applicant.acName);
            var acSexTd = $("<td></td>").append(item.applicant.acSex == 1 ? '男' : '女');
            var workinglifeTd = $("<td></td>").append(item.applicant.workinglife);
            //addClass("glyphicon glyphicon-pencil") 添加按钮的样式
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>")).addClass("glyphicon glyphicon-pencil").append(" 编辑");
            //为编辑按钮增加id属性
            editBtn.attr("edit-id", item.piId);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>")).addClass("glyphicon glyphicon-trash").append(" 删除");
            //为删除按钮增加id属性
            delBtn.attr("del-id", item.piId);
            //在两个按钮之间增加空格
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

            $("<tr></tr>")
                .append(checkBoxTd)
                .append(piIdTd)
                .append(piProjectnameTd)
                .append(piStartdateTd)
                .append(piEnddateTd)
                .append(piStatusTd)
                .append(acNameTd)
                .append(acSexTd)
                .append(workinglifeTd)
                .append(btnTd)
                .appendTo("#projectInfos_table tbody");
        });
    }
    // 显示分页的文字内容。
    function build_page_info(result) {
        //构建分页信息之前,进行分页元素的清空
        $("#page_info_area").empty();
        //构建分页信息的数据
        $("#page_info_area").append("当前第 " +
            result.extend.pageInfo.pageNum + " 页,总共 " +
            result.extend.pageInfo.pages + " 页,总共 " +
            result.extend.pageInfo.total + " 条记录");
        totalCount = result.extend.pageInfo.pages;
        currentPage = result.extend.pageInfo.pageNum;
        // console.log("test_____test");
    }
    //显示分页导航条
    function build_page_nav(result) {
        //构建分页显示条前,清空分页显示条的导航区内容
        $("#page_nav_area").empty();
        //构建ul元素，并添加类样式
        var ul = $("<ul></ul>").addClass("pagination");
        //构建元素

        //首页的元素，attr为添加属性
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        //上一页的元素
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));

        /*
        * 判断是否有上一页，如果没有，则不能点击 firstPageLi/prePageLi
        * 如果有则跳转首页或者前一页
        * */
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }

        //下一页的元素
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
        //末页的元素
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));

        /*
        * 判断是否有下一页，如果没有，则不能点击 nextPageLi/lastPageLi
        * 如果有则跳转未页或者下一页
        * */
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            })
        }

        //添加首页和前一页
        ul.append(firstPageLi).append(prePageLi);
        //遍历给ul中添加页码
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
            //让当前页面高亮
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            //添加单击事件
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        //把ul添加到nav元素中
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    <%-----------------------------------------------------新增-----------------------------------------------------%>
    /*
    * jsp方法顺序不同，前端网页可能会出现奇怪的问题
    * 方法封装
    * 每次新增之后，再次点击，前一次的内容没有删除
    * 清除原来的新增内容
    * */
    function reset_form(ele) {
        //重置内容
        $(ele)[0].reset();
        //清空样式找到该元素下所以内容里面包含这俩class的内容并清除
        $(ele).find("*").remove("has-success has-error");
        //找到所有class为.help-block并清空
        $(ele).find(".help-block").text("");
    }

    //获得所有申报人信息
    //查询申报人的函数
    function getApplicants(ele) {
        //先要清除下拉列表中原本的元素对象
        $(ele).empty();
        //ajax请求，获取所有部门
        $.ajax({
            url: "${app_path}/applicants/",
            type: "GET",
            success: function (result) {
                // console.log(result);
                //显示部门信息在下拉列表中
                $.each(result.extend.applicants, function () {
                    //构建列表项的内容,给的值为部门的id
                    var optionEle = $("<option></option>").append(this.acName).attr("value", this.acId);
                    //将构建的option添加在select里面
                    optionEle.appendTo(ele);
                });
            }
        });
    }

    //给添加按钮绑定单击事件
    $("#projectInfo_add_btn").click(function () {
        //先清除下拉列表中原本的元素结果
        reset_form("#projectInfoAddModal form")
        /*
        *.modal('toggle');
        * 如果弹出框没有显示，则使弹出框显示，反之反之
        * 使弹出框显示出来
        * */
        // $("#projectInfoAddModal").modal('toggle');
        //给日期框添加默认时间
        $(function () {
            document.getElementById('startDate_add_input').valueAsDate = new Date();
            document.getElementById('endDate_add_input').valueAsDate = new Date();
        });
        //发送ajax请求,查出部门信息,显示在新增员工时的下拉列表中
        getApplicants("#projectInfoAddModal select[name=acid]");
        //解决模态框状态下的点击灰色部分消失
        $("#projectInfoAddModal").modal({
            backdrop: 'static'
        });
    });


    //校验添加的表单
    function validate_add_form() {
        //主要是校验项目的名字
        //1.拿到校验的数据,使用正则表达式
        var projectName = $("#projectName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,64}$)|(^[\u2E80-\u9FFF]{2,32}$)/;
        //验证项目名
        if (!regName.test(projectName)) {
            //alert("用户名为2~24位中文,或者6~16位大小写英文、数字、下划线、横杠的组合");
            //调用验证信息的显示函数
            show_validate_msg("#projectName_add_input", "error", "项目名为2~32位中文,或者6~24位大小写英文、数字、下划线、横杠的组合")
            return false;
        } else {
            show_validate_msg("#projectName_add_input", "success", "")
        }
        return true;
    }

    //验证信息的显示
    function show_validate_msg(ele, status, msg) {//选择器元素,状态,信息
        //每次显示验证的信息时,都将之前的类样式清除掉
        $(ele).parent().removeClass("has-error has-success");
        if ("success" == status) {
            //正确的话,先添加正确样式
            $(ele).parent().addClass("has-success");
        } else if ("error" == status) {
            //错误的话,先添加错误样式
            $(ele).parent().addClass("has-error");
        }
        //然后添加正确或者错误文字信息
        $(ele).next("span").text(msg);
    }

    //进行项目名重复验证,ajax异步请求7
    $("#projectName_add_input").change(function () {
        //获取输入框的值
        var projectName = this.value;

        //发送ajax请求校验用户是否可用
        $.ajax({
            url: "${app_path}/projectInfos/checkProjectInfo",
            data: "projectName=" + projectName,
            type: "POST",
            success: function (result) {
                //console.log(result);
                //判断返回的Msg对象中的状态码是200(成功)还是400(失败)
                if (result.code == 200) {
                    show_validate_msg("#projectName_add_input", "success", "√ 可用");
                    //通过jq对保存按钮进行携带属性信息(保证验证项目名重复时,点击保存按钮不能提交模态框)
                    $("projectInfo_save_btn").attr("ajax_validate_projectName", "success");
                } else {
                    show_validate_msg("#projectName_add_input", "error", result.extend.validate_msg);
                    $("projectInfo_save_btn").attr("ajax_validate_projectName", "error");
                }
            }
        });
    });

    //模态框点击保存的访问
    $("#projectInfo_save_btn").click(function () {
        //0.先要对提交给服务器的数据进行校验
        if (!validate_add_form()) {//如果校验的方法返回不成功,点击事件就不再执行
            return false;
        }
        //添加之前需要判断ajax请求用户名可用校验是否可用;如果成功才能继续保存
        if ($(this).attr("ajax_validate_projectName") == "error") {
            return false;
        }
        /*
        * 将jq序列化出来得表单信息作为ajax请求的数据
        * 1.将模态框中表中的数据提交给服务器进行保存
        * 2.发送ajax请求,保存员工
        * 在这个地方通过jquery提供的表单序列化提取表单元素(这样就不用通过id一个一个获取里面的值,然后通过serialize()函数得到信息)
        *  alert($("#projectInfoAddModal form").serialize());提取了ajax的请求信息
        * -----注意-----表单里面传的name名要与后台实体类里面的字段名完全一致
        * */
        $.ajax({
            url: "${app_path}/projectInfos/projectInfo",
            data: $("#projectInfoAddModal form").serialize(),
            type: "POST",
            success: function (result) {
                if (result.code == 200) {
                    //员工保存成功
                    //1.关闭模态框
                    $("#projectInfoAddModal").modal("hide");
                    /*来到最后一页,显示刚才保存的数据(考虑到如果添加的是在新的页码中,这样我
                    们就不知道最后一页,但是分页请求提供的分页会自动处理这个问题,当你的页码超
                    过最大页面,会自动查询最后一页的数据)*/
                    //发送ajax请求显示最后一页
                    to_page(totalCount);
                } else {
                    if (undefined != result.extend.errorFields.projectName) {
                        show_validate_msg(
                            "#projectName_add_input",
                            "error",
                            result.extend.errorFields.projectName);
                    }
                }
            }
        });
    });
<%--------------------------------------------------------修改----------------------------------------------------------%>

    function getProjectInfo(id) {
        $.ajax({
            url: "${app_path}/projectInfos/projectInfo/" + id,
            type: "GET",
            success: function (result) {
                //获取员工对象
                var projectInfo = result.extend.projectInfo;
                //将对象中的信息放到相应的页面位置
                $("#projectId_update_static").text(projectInfo.piId);
                $("#projectName_update_input").val(projectInfo.piProjectname);
                $("#startDate_update_input").val(dateFarmat("yyyy-MM-dd", new Date(projectInfo.piStartdate)));
                $("#endDate_update_input").val(dateFarmat("yyyy-MM-dd", new Date(projectInfo.piEnddate)));
                $("#projectInfoUpdateModal select[name=piStatus]").val([parseInt(projectInfo.piStatus)]);
                $("#projectInfoUpdateModal select[name=acid]").val([parseInt(projectInfo.acid)]);
            }
        });
    }
    //此时绑定点击事件时，是加载dom元素之前绑定的，此时还没有编辑按钮，所以绑定不上
    /* 解决方法：动态绑定
    1.创建按钮的同时绑定按钮（这样的话代码冗余，不适合）
    2.使用live函数进行动态绑定，但是live()函数已经过期
    使用on()代替live()函数
    ：
    on(events,[selector],[data],fn)
    */
    //在整个文档中绑定
    $(document).on("click", ".edit_btn", function () {
        //1.查询项目信息，显示项目的信息
        getProjectInfo($(this).attr("edit-id"));
        //2.查询申报人信息，并显示申报人的列表
        //发送ajax请求,查出部门信息,显示在新增员工时的下拉列表中
        getApplicants("#projectInfoUpdateModal select[name=acid]");
        //3.将需要更新的员工id,从编辑按钮携带给模态框的更新按钮; 然后弹出模态框
        $("#projectInfo_update_btn").attr("edit-id", $(this).attr("edit-id"));
        //模态框弹出
        $("#projectInfoUpdateModal").modal({
            backdrop: 'static'
        });
    });
    //点击更新,更新员工信息
    $("#projectInfo_update_btn").click(function () {
        //以PUT方式请求
        $.ajax({
            url: "${app_path}/projectInfos/projectInfou/" + $(this).attr("edit-id"),
            type: "PUT",
            data: $("#projectInfoUpdateModal form").serialize(),//传递的数据为序列化的projectInfo对象,同时携带参数请求方法为PUT
            success: function (result) {
                // console.log(result);
                //隐藏模态框
                $("#projectInfoUpdateModal").modal("hide");
                //回到当前修改信息的页面
                to_page(currentPage);
                // console.log($("#projectInfoUpdateModal form").serialize());
            }
        });
    });


    <%-------------------------------------------------------删除-------------------------------------------------------%>
    //单个删除按钮动态绑定事件
    $(document).on("click", ".delete_btn", function () {
        //1.弹出对话框,同时获取删除项目的名字
        //alert($(this).parents("tr").find("td:eq(2)").text());
        var projectInfoName = $(this).parents("tr").find("td:eq(2)").text();
        //获得删除按钮上绑定的属性del-id
        var delId = $(this).attr("del-id");
        if (confirm("确定删除" + projectInfoName + "吗?")) {
            //发送ajax请求删除用户
            $.ajax({
                url: "${app_path}/projectInfos/projectInfoDel/" + delId,
                type: "DELETE",
                success: function (result) {
                    //console.log(result);
                    alert(result.msg);
                    //回到当前页
                    to_page(currentPage);
                }
            });
        }
    });
    // 复选框全选_框
    $("#check_all").click(function () {
        $(this).prop("checked");
        $(".check_item").prop("checked", $(this).prop("checked"));
    });
    /*
    * 如果当页的复选框全选了，则全选框自动选择
    * */
    $(document).on("click", ".check_item", function () {
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });
    //点击全部删除
    $("#projectInfo_delete_all_btn").click(function () {
        //创建用于存放删除的名字
        var projectInfoNames = "";
        //用于存放用户id的字符串
        var del_ids_str = "";
        $.each($(".check_item:checked"), function () {
            //遍历选中的元素,将名字拼接到projectInfoNames中,用","隔开
            projectInfoNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_ids_str += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        //去除最后一个","
        projectInfoNames = projectInfoNames.substring(0, projectInfoNames.length - 1);
        //去除最后一个"-"
        del_ids_str = del_ids_str.substring(0, del_ids_str.length - 1);
        if (confirm("确定删除" + projectInfoNames + "吗?")) {
            //发送ajax请求删除用户
            $.ajax({
                url: "${app_path}/projectInfos/projectInfoDel/" + del_ids_str,
                type: "DELETE",
                success: function (result) {
                    //console.log(result);
                    alert(result.msg);
                    //回到当前页
                    to_page(currentPage);
                }
            });
        }
    });

    $("#button_go").click(function () {

            // $("#turn_to_page").empty();
            var turn_page = $("#turn_to_page").val();
            if (turn_page>totalCount){
                to_page(totalCount);
            }
            else if(turn_page<1){
                to_page(1);
            }
            else {
                to_page(turn_page);
            }
        }
    );
    // function build_page_turn() {
    //     $("#page_turn_area").empty();
    //
    //     var div = $("<div><div>").addClass("input-group");
    //
    //     var input_area = $("<input></input>").addClass("form-control").attr("type","text","placeholder","shuru")
    //     var go =$("<span></span>").addClass("input-group-btn").append($("<button></buten>")).addClass("btn btn-default").append("Go").attr("type","button","href","#");
    //
    //     div.append(input_area).append(go);
    //     div.appendTo("#page_turn_area");
    // }
    // $(function () {
    //     //goToFirst
    //     to_page(1);
    // });

</script>


