package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDaoImp;
import web.models.User;
import org.springframework.transaction.annotation.*;
import java.util.List;
@Transactional(readOnly = true)
@Component
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
    @Transactional
    @Override
    public void add(User user) {
        userDaoImp.add(user);
    }
    @Transactional
    @Override
    public void delete(User user) {
        userDaoImp.delete(user);
    }
    @Transactional
    @Override
    public void update(Long id, User user) {
        userDaoImp.update(id, user);
    }
}
