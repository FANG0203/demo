package com.mrfang.dao;

import com.mrfang.entity.Applicant;
import com.mrfang.entity.ApplicantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicantMapper {
    long countByExample(ApplicantExample example);

    int deleteByExample(ApplicantExample example);

    int deleteByPrimaryKey(Integer acId);

    int insert(Applicant record);

    int insertSelective(Applicant record);

    List<Applicant> selectByExample(ApplicantExample example);

    Applicant selectByPrimaryKey(Integer acId);

    int updateByExampleSelective(@Param("record") Applicant record, @Param("example") ApplicantExample example);

    int updateByExample(@Param("record") Applicant record, @Param("example") ApplicantExample example);

    int updateByPrimaryKeySelective(Applicant record);

    int updateByPrimaryKey(Applicant record);
}