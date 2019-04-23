package edu.mum.cs.wap.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.io.PrintWriter;
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

        String name=request.getParameter("Name");
        String email=request.getParameter("Email");
        String phone=request.getParameter("Phone");
        String address=request.getParameter("Address");
        String lngLat=request.getParameter("LngLat");


        User user;
        if(userId.isEmpty()){
            Integer userTypeId=Integer.parseInt(userType);
             user=new User(userName,password, UserType.values()[userTypeId],name,email,phone,address,lngLat);
             userService.Create(user);
        }
        else {
            Integer userTypeId=Integer.parseInt(userType);
            user=new User(Integer.parseInt(userId),userName,password, UserType.values()[userTypeId],name,email,phone,address,lngLat);
            userService.Update(user);
        }
        response.sendRedirect("Users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession  session=request.getSession();
        String addNewUser=request.getParameter("addNewUser");
        String updateUser=request.getParameter("updateUser");

        if(addNewUser!=null){
            session.setAttribute("user",new User());
            request.getRequestDispatcher("Users/AddUser.jsp").forward(request,response);
        }
        else if(updateUser !=null){
            int id=Integer.parseInt(updateUser);
            IUserService userService=new UserService();
            User user=((UserService) userService).GetById(id);
            session.setAttribute("user",user);
            request.getRequestDispatcher("Users/AddUser.jsp").forward(request,response);

        }
        else {
            LoadAllUsers(session,request,response);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService userService=new UserService();
        HttpSession  session=req.getSession();

        String userId=req.getParameter("UserID");
        if(!userId.isEmpty()){
            Integer id=Integer.parseInt(userId);
           boolean result= userService.Delete(id);
            resp.setContentType("application/json");
            PrintWriter out=resp.getWriter();
            out.print(result);
        }
    }

    private void LoadAllUsers (HttpSession session, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        IUserService userService=new UserService();
        List<User> users=userService.GetAll();
        session.setAttribute("users",users);
        request.getRequestDispatcher("Users/User.jsp").forward(request,response);
    }
}
