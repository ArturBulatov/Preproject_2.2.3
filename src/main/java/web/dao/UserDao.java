package web.dao;

import web.models.User;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDao  {
    public List<User> getAll();
    public User getOne(Long id);
    public void add(User user);
    public void delete(User user);
    public void update(Long id, User user);

}
