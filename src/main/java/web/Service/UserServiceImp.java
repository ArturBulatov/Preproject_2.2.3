package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDaoImp;
import web.models.User;

import java.util.List;

public class UserServiceImp implements UserService {
    private UserDaoImp userDaoImp;
    @Autowired
    public UserServiceImp (UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }
    @Override
    public List<User> getAll() {
        return userDaoImp.getAll();
    }

    @Override
    public User getOne(Long id) {
        return userDaoImp.getOne(id);
    }

    @Override
    public void add(User user) {
        userDaoImp.add(user);
    }

    @Override
    public void delete(User user) {
        userDaoImp.delete(user);
    }

    @Override
    public void update(Long id, User user) {
        userDaoImp.update(id, user);
    }
}
