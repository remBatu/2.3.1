package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return em.createQuery("FROM User u ORDER BY u.id", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void editUser(User changedUser) {
        em.merge(changedUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}
