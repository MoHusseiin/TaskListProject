package edu.mum.cs.wap.services;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.models.UserType;

import java.util.List;

public interface IUserService<T> extends IService<T> {
    public User getUser(String userName, String password);
    public List<User> getUserByUserType(UserType userType);
}
