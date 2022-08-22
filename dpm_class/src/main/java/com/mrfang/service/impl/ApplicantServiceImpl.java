package com.mrfang.service.impl;

import com.mrfang.dao.ApplicantMapper;
import com.mrfang.entity.Applicant;
import com.mrfang.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/5/19 8:39
 * @ Project: dpm_class
 */
@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public List<Applicant> getApplicants() {
        return applicantMapper.selectByExample(null);
    }
}
