package com.rainsoul.springmvc.controller;

import com.rainsoul.springmvc.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * AJAX处理的控制器类
 */
@RestController
public class AJAXController {

    /**
     * 通过HTTP GET请求返回一个简单的字符串消息。
     * 这个方法展示了如何直接通过响应体输出信息。
     *
     * @param response HTTP响应对象，用于直接向客户端输出信息。
     * @throws IOException 如果在写入响应体时发生IO错误。
     */
    /*@GetMapping("/ajax")
    public String ajax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("hello ajax, my name is Spring MVC!");
        return null;
    }*/

    /**
     * 类似于上面的方法，但此示例展示了另一种直接向客户端输出的方式。
     *
     * @param response HTTP响应对象，用于直接向客户端输出信息。
     * @throws IOException 如果在写入响应体时发生IO错误。
     */
    /*@GetMapping("/ajax")
    public void ajax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("hello ajax, my name is Spring MVC2!");
    }*/

    /**
     * 返回一个JSON格式的字符串，展示如何返回非字符串数据。
     * 该方法注释了@ResponseBody，表示返回值将直接写入HTTP响应的主体。
     *
     * @return 包含用户信息的JSON字符串。
     */
    /*@GetMapping("/ajax")
    @ResponseBody
    public String ajax() {
        //return "hello ajax, my name is Spring MVC!";
        return "{\"id\":\"1111112222\", \"username\":\"zhangsan\", \"password\":\"1234\"}";
    }*/

    /**
     * 返回一个用户实体，展示如何返回复杂类型数据。
     * 该方法省略了@ResponseBody注解，因为@RestController注解默认使每个方法的返回值成为响应体的内容。
     *
     * @return 用户实体对象。
     */
    @GetMapping("/ajax")
    public User ajax() {
        User user = new User(111222L, "lisi", "123");
        return user;
    }

    /*@ResponseBody 是Spring MVC框架中的一个注解，其主要作用是指示一个控制器方法的返回值应该直接写入
    HTTP响应体（Response Body）中，而不是被解释为视图名称去渲染视图模板。这意味着该注解可以帮助我们将
    Java对象直接转换为客户端可以理解的格式，如JSON、XML等，而不需要通过传统的视图层技术。当一个方法使用了
    @ResponseBody 注解后，Spring MVC会利用消息转换器（如 MappingJackson2HttpMessageConverter）
    自动将返回的对象转换成合适的格式，并将其写入到HTTP响应中。这种方式非常适合构建RESTful风格的Web服务，
    因为它允许服务端直接向客户端返回数据，而不是渲染一个完整的HTML页面，从而使得前后端分离更加彻底，
    提高了应用的可维护性和灵活性。

    @RestController 是Spring MVC框架中的一个复合注解，它是 @Controller 和 @ResponseBody 注解的结合体。其主要作用是简化创建RESTful风格的控制器类的过程。
    当一个类被标记为 @RestController 时，表明这个类中的所有请求处理方法都默认启用了 @ResponseBody 功能，即它们的返回值都会被自动转换成适合HTTP响应的格式（如JSON或XML），
    直接写入响应体中，而不需要在每个方法上单独标注 @ResponseBody。简而言之，@RestController 的用途如下：
    简化注解：避免在每个处理方法上重复使用 @ResponseBody。
    RESTful风格：明确表示该控制器类设计用于处理REST风格的API请求，关注资源的表述和操作。
    数据直接输出：指示控制器方法的输出应直接序列化为响应体内容，而非渲染视图模板。
    使用 @RestController 可以快速开发API接口，特别适用于那些不需要视图渲染，仅关注数据传输的Web服务场景。*/
}
