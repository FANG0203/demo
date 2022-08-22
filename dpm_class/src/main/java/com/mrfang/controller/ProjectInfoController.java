package com.mrfang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrfang.utils.Msg;
import com.mrfang.entity.ProjectInfo;
import com.mrfang.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author: Fang
 * @ Date: 2022/5/19 10:05
 * @ Project: dpm_class
 */
@RequestMapping("/projectInfos")
@Controller
public class ProjectInfoController {
    @Autowired
    private ProjectInfoService projectInfoService;
    //查询信息，用于页面展示
    @RequestMapping("/")
    @ResponseBody//可以自动将返回的数据变成json数据
    public Msg select_Project(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //引入PageHelper分页插件
        //在查询之前只需要调用,传入页码,以及每一页的大小
        PageHelper.startPage(pn, 5);
        //startPage后面紧跟的查询就是一个分页查询的数据
        List<ProjectInfo> infos = projectInfoService.selectByExampleWithApplicant();
        //使用PageInfo进行包装查询后的结果,只需要将PageInfo交给页面就可以了
        //PageInfo(封装了详细的分页信息,包括我们查询出来的信息,和连续查询显示的页数)
        PageInfo page = new PageInfo(infos, 5);
        return Msg.success().add("pageInfo", page);
    }
    //检测方法名是否可用
    //验证方法名称是否重复
    @RequestMapping("/checkProjectInfo")
    @ResponseBody
    public Msg checkProjectInfo(@RequestParam("projectName") String projectName) {

        //判断用户名是否合法的
        String regProjectName = "(^[a-zA-Z0-9_-]{6,64}$)|(^[\u2E80-\u9FFF]{2,32}$)";
        if (!projectName.matches(regProjectName)) {
            return Msg.fail().add("validate_msg", "用户名为2~32位中文," +
                    "或者6~64位大小写英文、数字、下划线、横杠的组合");
        }
        boolean flag = projectInfoService.checkProjectInfo(projectName);
        if (flag) {
            return Msg.success();
        } else {
            return Msg.fail().add("validate_msg", "x 不可用");
        }
    }
    //保存
    @RequestMapping(value = "/projectInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveProjectInfo(@Valid ProjectInfo projectInfo, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            projectInfoService.saveProjectInfo(projectInfo);
            return Msg.success();
        }
    }
    /*
     * 根据id查询项目详细信息
     * 用于修改编辑展示
     * */
    @RequestMapping(value = "/projectInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getProjectInfo(@PathVariable("id") Integer pi_Id) {
        //@PathVariable("id")代表从路径中获取id
        ProjectInfo projectInfo = projectInfoService.getProjectInfo(pi_Id);
        //System.out.println(projectInfo.toString());
        return Msg.success().add("projectInfo", projectInfo);
    }
    //项目更新方法
    @RequestMapping(value = "/projectInfou/{piId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg saveProjectInfo(ProjectInfo projectInfo) {
        projectInfoService.updateProjectInfo(projectInfo);
        //System.out.println(projectInfo.toString());
        return Msg.success();
    }
    /*
    * 根据id删除单个项目
    * 如果是多个id。就拼接起来: 1-2-3
    * 如果是单个就是: 1
    * */
    @RequestMapping(value = "/projectInfoDel/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteProjectInfoById(@PathVariable("ids") String ids){

        if (ids.contains("-")){
          List<Integer> int_ids = new ArrayList<Integer>();
          String[] str_ids = ids.split("-");
          for (String str_id : str_ids){
              int_ids.add(Integer.valueOf(str_id));
          }
          projectInfoService.deleteProjectInfosAny(int_ids);
        } else {
            Integer id = Integer.valueOf(ids);
            projectInfoService.deleteProjectInfo(id);
        }
        return Msg.success();
    }
}
    /*
    *
    private int pageNum;//当前页码
    private int pageSize;//设置每页多少条数据
    private int size;//当前页有多少条数据
    private int startRow;//当前页码第一条数据的
    private int endRow;//当前页码的开始条
    private int pages;//当前页码结束条
    private int prePage;//上一页（页面链接使用）
    private int nextPage;//下一页（页面链接使用）
    private boolean isFirstPage;//是否为第一页
    private boolean isLastPage;//是否为最后一页
    private boolean hasPreviousPage;//是否有前一页
    private boolean hasNextPage;//是否有下一页
    private int navigatePages;//导航页码数(就是总共有多少页)
    private int[] navigatePageNums;//导航页码数(就是总共有多少页),可以用来遍历
    private int navigateFirstPage;//首页号
    private int navigateLastPage;//尾页号
    * */