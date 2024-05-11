package com.rainsoul.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"x", "y"})
/**
 * SessionScopeTestController类用于演示和测试在Spring MVC中如何使用原生Servlet API以及Session属性来完成数据的共享和存储。
 */
public class SessionScopeTestController {

    /**
     * 通过原生Servlet API测试Session数据共享。
     *
     * @param session HttpSession对象，用于存储会话数据。
     * @return 返回逻辑视图名称，此处为"ok"。
     */
    @RequestMapping(value = "/testSessionServletAPI")
    public String testServletAPI(HttpSession session) {
        // 将数据存储到session中
        session.setAttribute("testSessionScope", "在SpringMVC当中使用原生Servlet API完成session域数据共享");
        // 返回逻辑视图名称（这是一个转发的行为）
        return "ok";
    }

    /**
     * 利用ModelMap测试Session属性的添加与使用。
     *
     * @param modelMap ModelMap对象，用于在视图和控制器之间传递数据，此处用于添加session属性。
     * @return 返回逻辑视图名称，此处为"ok"。
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(ModelMap modelMap){
        // 将数据存储到session域当中
        modelMap.addAttribute("x", "我是陈东民");
        modelMap.addAttribute("y", "我是李政");

        // 返回逻辑视图名称
        return "ok";
    }
}
