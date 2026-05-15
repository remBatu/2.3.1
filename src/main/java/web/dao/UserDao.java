package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(Long id);
    void addUser(User user);
    void editUser(User changedUser);
    void deleteUser(Long id);
}
