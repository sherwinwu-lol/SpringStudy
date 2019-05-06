package com.wusd.framework.mvc.controller;

import com.wusd.framework.mvc.annotation.Controller;
import com.wusd.framework.mvc.annotation.RequestMapping;
import com.wusd.framework.mvc.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/doTestP")
    public void testP(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("param") String param) {
        System.out.println(param);
        try {
            response.getWriter().write("doTestP method success! param: " + param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/doTest")
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("doTest method success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
