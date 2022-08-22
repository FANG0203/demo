package com.mrfang.service.impl;

import com.mrfang.dao.ProjectInfoMapper;
import com.mrfang.entity.ProjectInfo;
import com.mrfang.entity.ProjectInfoExample;
import com.mrfang.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/5/19 8:55
 * @ Project: dpm_class
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Override
    public List<ProjectInfo> selectByExampleWithApplicant() {
        return projectInfoMapper.selectByExampleWithApplicant(null);
    }

    @Override
    public void saveProjectInfo(ProjectInfo projectInfo) {
        projectInfoMapper.insertSelective(projectInfo);
    }

    @Override
    public boolean checkProjectInfo(String projectName) {
        //创建查询条件
        ProjectInfoExample example = new ProjectInfoExample();
        //得到条件对象
        ProjectInfoExample.Criteria criteria = example.createCriteria();
        criteria.andPiProjectnameEqualTo(projectName);
        //根据条件查询数量
        long count = projectInfoMapper.countByExample(example);
        //如果为零，则代表没有查到，可以使用，结果为ture
        return count==0;
    }

    @Override
    public ProjectInfo selectByPrimaryKeyWithApplicant(Integer piId) {
        return projectInfoMapper.selectByPrimaryKeyWithApplicant(piId);
    }

    @Override
    public ProjectInfo getProjectInfo(Integer pi_Id) {
        return projectInfoMapper.selectByPrimaryKey(pi_Id);
    }

    @Override
    public void updateProjectInfo(ProjectInfo projectInfo) {
        projectInfoMapper.updateByPrimaryKeySelective(projectInfo);
    }

    @Override
    public void deleteProjectInfo(Integer id) {
        projectInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteProjectInfosAny(List<Integer> ids) {
        ProjectInfoExample example = new ProjectInfoExample();
        ProjectInfoExample.Criteria criteria = example.createCriteria();
        //相当于在数据库中为delete from projectinfo where pi_id in 集合
        criteria.andPiIdIn(ids);
        projectInfoMapper.deleteByExample(example);
    }


}

