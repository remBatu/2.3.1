package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private long count = 0L;
    private final List<User> users = new ArrayList<>();

    {
        User user1 = new User("Bob", "Bobson", 66);
        user1.setId(++count);
        User user2 = new User("Ron", "Ronson", 56);
        user2.setId(++count);
        User user3 = new User("Meg", "Megson", 46);
        user3.setId(++count);
        User user4 = new User("Muc", "Mucson", 36);
        user4.setId(++count);
        User user5 = new User("Luc", "Lucson", 26);
        user5.setId(++count);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(Long id) {
        return users.stream().filter(user -> id.equals(user.getId())).findFirst().get();
    }

    @Override
    public void addUser(User user) {
        user.setId(++count);
        users.add(user);
    }

    @Override
    public void editUser(Long id, User changedUser) {
        users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .ifPresent(user -> {
                    user.setName(changedUser.getName());
                    user.setSurname(changedUser.getSurname());
                    user.setAge(changedUser.getAge());
                });
    }

    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> id.equals(user.getId()));
    }
}
