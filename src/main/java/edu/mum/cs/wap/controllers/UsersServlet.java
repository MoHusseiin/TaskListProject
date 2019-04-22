package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.models.UserType;
import edu.mum.cs.wap.services.IUserService;
import edu.mum.cs.wap.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Users")
public class UsersServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService=new UserService();
        HttpSession  session=request.getSession();

        String userId=request.getParameter("UserID");
        String userName=request.getParameter("UserName");
        String password=request.getParameter("Password");
        String userType=request.getParameter("UserType");
        User user;
        boolean result;
        if(userId.isEmpty()){
            Integer userTypeId=Integer.parseInt(userType);
             user=new User(userName,password, UserType.values()[userTypeId]);
            result= userService.Create(user);
            if(result){
                session=request.getSession();
                LoadAllUsers(session,request,response);
            }

        }
        else {

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession  session=request.getSession();
        String addNewUser=request.getParameter("addNewUser");
        if(addNewUser!=null){
            session.setAttribute("user",new User());
            request.getRequestDispatcher("Users/AddUser.jsp").forward(request,response);
        }
        else {
            LoadAllUsers(session,request,response);
        }

    }

    private void LoadAllUsers ( HttpSession session,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        IUserService userService=new UserService();
        List<User> users=userService.GetAll();
        session.setAttribute("users",users);
        request.getRequestDispatcher("Users/User.jsp").forward(request,response);
    }
}
