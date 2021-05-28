package com.zarek.crm.filter; /**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */

import com.zarek.crm.pojo.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 资源限定访问：只有登录过的用户才能访问系统的服务
 */
public class ResourcesFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException
    {
    }

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException
    {

        long start = System.currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String servletPath = httpServletRequest.getServletPath();
        System.out.println("servletPath = " + servletPath);

        if("/login.html".equals(servletPath) || "/settings/user/login.do".equals(servletPath)|| "/login".equals(servletPath) || "/".equals(servletPath)) {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if(user!=null){

                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }else{

                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            }
        }
        System.out.println("Execute cost="+(System.currentTimeMillis()-start));

    }
}
