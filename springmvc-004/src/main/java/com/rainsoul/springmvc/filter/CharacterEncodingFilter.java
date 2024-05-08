package com.rainsoul.springmvc.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * 字符编码过滤器类，用于确保请求和响应的字符编码为UTF-8。
 * 实现了Filter接口，以便在Servlet容器中作为过滤器使用。
 */
public class CharacterEncodingFilter implements Filter {

    /**
     * 处理请求和响应的过滤逻辑。
     * @param request Servlet请求对象，用于接收客户端发送的请求。
     * @param response Servlet响应对象，用于向客户端发送响应。
     * @param chain 过滤器链，用于调用下一个过滤器或Servlet。
     * @throws IOException 如果发生输入/输出错误。
     * @throws ServletException 如果发生与Servlet相关的异常。
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置请求编码为UTF-8，确保请求参数的编码正确
        request.setCharacterEncoding("UTF-8");
        // 设置响应编码为UTF-8，确保响应数据的编码正确
        response.setContentType("text/html;charset=UTF-8");
        // 执行链中的下一个过滤器或Servlet
        chain.doFilter(request, response);
    }
}

