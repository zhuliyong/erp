package com.sys.controller;

import com.sys.common.response.ResultResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.ResponseWrapper;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/18 16:24
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/index"  )
    @ResponseBody
    public ResultResponse index(){
        System.out.println("===index");
        ResultResponse res = new ResultResponse();
        res.setStatus(1);
        res.setMessage("ok");
        return  res;
    }

}
