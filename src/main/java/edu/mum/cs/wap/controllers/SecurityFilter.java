package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/home")
public class SecurityFilter implements Filter {
    public SecurityFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

       String userName = request.getParameter("userName");
       String password = request.getParameter("password");
       if(userName != null && password != null){
           User user = new UserService().getUser(userName, password);
           String forwardPage = "/";
           if(user != null){
                switch (user.getUserType()) {
                    case Developer:
                        forwardPage = "Tasks";
                        break;
                    case Admin:
                        forwardPage = "Users";
                        break;
                    case ProjectManager:
                            forwardPage = "Tasks";
                        // Teams
                        break;
                }
           }
           response.sendRedirect(forwardPage);
       }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }
}
