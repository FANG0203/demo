package com.mrfang.dao;

import com.mrfang.entity.ProjectInfo;
import com.mrfang.entity.ProjectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectInfoMapper {
    //统计数量
    long countByExample(ProjectInfoExample example);
    //根据条件删除
    int deleteByExample(ProjectInfoExample example);
    //根据主键删除
    int deleteByPrimaryKey(Integer piId);
    //添加
    int insert(ProjectInfo record);
    //有选择的添加
    int insertSelective(ProjectInfo record);
    //根据条件查询
    List<ProjectInfo> selectByExample(ProjectInfoExample example);
    //根据主键查询
    ProjectInfo selectByPrimaryKey(Integer piId);
    //根据条件有选择修改
    int updateByExampleSelective(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);
    //根据条件修改所有
    int updateByExample(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);
    //根据主键有选择的修改
    int updateByPrimaryKeySelective(ProjectInfo record);
    //根据主键修改
    int updateByPrimaryKey(ProjectInfo record);
    /*
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * 以上自动生成操作都为单表操作，所以我们需要创建自己需求的俩表联查
    * */
    //根据条件两表联查询所有信息
    List<ProjectInfo> selectByExampleWithApplicant(ProjectInfoExample example);
    //根据主键两表联查询单个信息
    ProjectInfo selectByPrimaryKeyWithApplicant(Integer piId);
}