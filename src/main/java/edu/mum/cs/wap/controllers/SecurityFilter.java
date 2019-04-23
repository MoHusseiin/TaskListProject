package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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

        HttpSession session = request.getSession();
       String userName = request.getParameter("userName");
       String password = request.getParameter("password");
       if(userName != null && password != null){
           User user = new UserService().getUser(userName, password);
           String forwardPage = "login";
           if(user != null){
               List<String> roles = new ArrayList<>();
                switch (user.getUserType()) {
                    case Developer:
                    forwardPage = "UserDashboard";
                    roles.add("Tasks");
                    roles.add("UserDashboard");
                    break;
                    case Admin:
                        forwardPage = "Users";
                        roles.add("Users");
                        break;
                    case ProjectManager:
                        forwardPage = "PMDashboard";
                        roles.add("Tasks");
                        roles.add("Teams");
                        roles.add("PMDashboard");
                        break;
                }
               session.setAttribute("currentUser", user);
               session.setAttribute("roles", roles);
           }else
               session.setAttribute("loginError", "Invalid Username/Password");
           response.sendRedirect(forwardPage);
       }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }
}
