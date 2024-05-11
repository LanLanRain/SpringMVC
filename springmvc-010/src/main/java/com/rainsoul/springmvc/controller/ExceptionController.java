package com.rainsoul.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 这个类是全局异常处理控制器，提供统一的异常处理机制。
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * 处理所有捕获到的异常，并将异常信息传递给前端。
     *
     * @param e 捕获到的异常对象
     * @param model 用于向视图添加数据的模型对象
     * @return 返回视图名称 "tip"，用于展示异常信息
     */
    @ExceptionHandler
    public String tip(Exception e, Model model){
        // 向模型中添加异常对象，以便在前端页面上显示异常信息
        model.addAttribute("yiChang", e);
        return "tip";
    }

   /* @ControllerAdvice 是 Spring MVC 中的一个注解，它的主要作用是提供全局的异常处理。
    当控制器方法中抛出异常时，Spring 将查找带有 @ControllerAdvice 注解的类，然后根据
    其中的方法来匹配并执行相应的异常处理逻辑。在这个例子中，ExceptionController 类使用了
    @ControllerAdvice 注解，表明它是应用于所有控制器的一个全局异常处理器。@ExceptionHandler
    注解的 tip 方法会捕获应用程序中任何未被特定控制器方法处理的异常，并将这些异常信息传递给前端。
    Model 参数允许处理程序向视图传递数据，这里通过 model.addAttribute() 添加了异常对象，
    这样在渲染 "tip" 视图时，可以访问并展示异常的详细信息。

    总结一下 @ControllerAdvice 的作用：
    全局性：它使得异常处理代码集中化，不需要在每个控制器或方法中单独处理异常。
    灵活性：可以通过指定 @ExceptionHandler 注解处理特定类型的异常，或者使用通配符处理所有异常。
    增强用户体验：可以优雅地处理错误，提供定制化的错误页面或反馈，而不是显示默认的错误页面。
    简化代码：减少控制器中的样板代码，让控制器专注于业务逻辑。
    在这个特定的 ExceptionController 类中，tip 方法是一个通用的异常处理器，用于捕获任何类型的异常，
    并将异常信息以 "yiChang" 键存储在模型中，然后重定向到 "tip" 视图进行显示。*/
}
