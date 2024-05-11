package com.rainsoul.springmvc.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Interceptor3 implements HandlerInterceptor {
    /**
     * 在请求处理之前执行的逻辑。
     *
     * @param request  HttpServletRequest对象，代表客户端的请求
     * @param response HttpServletResponse对象，用于向客户端发送响应
     * @param handler  将要处理请求的处理器对象
     * @return boolean 返回值表明是否继续执行后续的拦截器或处理器
     * @throws Exception 抛出异常时可捕获，用于处理异常情况
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor3's preHandle!");
        return true;
    }

    /**
     * 在请求处理之后执行，但在视图被渲染之前。
     *
     * @param request  HttpServletRequest对象，代表客户端的请求
     * @param response HttpServletResponse对象，用于向客户端发送响应
     * @param handler  处理请求的处理器对象
     * @param modelAndView 视图和模型数据的组合
     * @throws Exception 抛出异常时可捕获，用于处理异常情况
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor3's postHandle!");
    }

    /**
     * 在整个请求处理完成，视图渲染完毕后执行。
     *
     * @param request  HttpServletRequest对象，代表客户端的请求
     * @param response HttpServletResponse对象，用于向客户端发送响应
     * @param handler  处理请求的处理器对象
     * @param ex       在请求处理过程中抛出的异常对象
     * @throws Exception 抛出异常时可捕获，用于处理异常情况
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor3's afterCompletion!");
    }
}
