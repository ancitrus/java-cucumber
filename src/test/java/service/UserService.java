package service;

import api.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(String url);
}
