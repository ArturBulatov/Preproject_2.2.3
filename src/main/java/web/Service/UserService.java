//package web.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import web.dao.UserDao;
//import web.models.User;
//
//import java.util.List;
//
//@Service
//public class UserService {
//    private final UserDao userDao;
//
//    @Autowired
//    public UserService(UserDao userDao){
//        this.userDao = userDao;
//    }
//
//    public User findById(Long id) {
//        return userDao.findById(id).orElse(null);
//    }
//
//    public List<User> finAll() {
//        return userDao.findAll();
//    }
//
//    public User saveUser(User user) {
//        return userDao.save(user);
//    }
//
//    public void deleteById(Long id) {
//        userDao.deleteById(id);
//    }
//}
