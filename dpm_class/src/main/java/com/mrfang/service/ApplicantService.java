package com.mrfang.service;
import com.mrfang.entity.Applicant;
import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/5/19 8:27
 * @ Project: dpm_class
 */
public interface ApplicantService {

    /*
     * 查询所有的申报人
     * */
    List<Applicant> getApplicants();
}
