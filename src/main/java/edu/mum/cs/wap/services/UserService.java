package edu.mum.cs.wap.services;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.repository.UserRep;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService  implements IUserService<User> {
    @Override
    public boolean Create(User model)  {
        boolean result=false;
        try {
            result = UserRep.addUser(model);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean Update(User model) {
        boolean result=false;
        try {
            result = UserRep.updateUser(model);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public List<User> GetAll() {
        List<User> result=new ArrayList<>();
        try {
            result = UserRep.ReteriveUsers();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User GetById(int id) {
        User result=new User();
        try {
            result = UserRep.GetUserById(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
