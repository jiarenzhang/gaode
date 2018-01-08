package com.zjr.gaode.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: ZhangJiaRen
 * @Date: Created in 15:37 2018/1/8
 * @Description: 访问http://localhost:端口号/swagger-ui.html，可以看到定义的接口（输入参数，输出参数）
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
