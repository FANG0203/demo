package com.mrfang.service;
import com.mrfang.entity.ProjectInfo;
import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/5/19 8:27
 * @ Project: dpm_class
 */
public interface ProjectInfoService {

    //查询所有项目(两表联查)
    List<ProjectInfo> selectByExampleWithApplicant();

    //添加项目
    void saveProjectInfo(ProjectInfo projectInfo);

    //验证申报的项目是否存在
    boolean checkProjectInfo(String projectName);

    //查询单个项目(两表联查)
    ProjectInfo selectByPrimaryKeyWithApplicant(Integer piId);

    //根据项目id查出项目的信息
    ProjectInfo getProjectInfo(Integer pi_Id);

    //修改项目信息，根据key有选择的修改
    void  updateProjectInfo(ProjectInfo projectInfo);

    //deleteProject
    void deleteProjectInfo(Integer id);

    //delProjects
    void deleteProjectInfosAny(List<Integer> ids);
}
