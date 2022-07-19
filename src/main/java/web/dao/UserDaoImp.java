package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import javax.persistence.*;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getOne(Long id) {
    return getAll().stream().filter(user -> user.getId() == id).findAny().orElse(new User("a", "b", 38));
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.merge(user));
    }

    @Override
    public void update(Long id , User nuser) {
        User upUser = getOne(id);
        upUser.setName(nuser.getName());
        upUser.setLastName(nuser.getLastName());
        upUser.setAge(nuser.getAge());
    }
}
