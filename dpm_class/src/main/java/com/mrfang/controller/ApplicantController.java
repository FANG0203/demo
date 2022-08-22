package com.mrfang.controller;

import com.mrfang.utils.Msg;
import com.mrfang.entity.Applicant;
import com.mrfang.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/5/19 10:04
 * @ Project: dpm_class
 */
@RequestMapping("/applicants")
@Controller
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @RequestMapping("/")
    @ResponseBody
    public Msg getApplicants(){
        //调用业务层，得到结果
        List<Applicant> list =applicantService.getApplicants();
        //将结果放到成功的数据包中，以json的方式进行返还结果
        return Msg.success().add("applicants",list);
    }
}
