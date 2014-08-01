package hello.spring.mybatis;

import hello.spring.aop.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-16 下午10:32
 */
@MyBatisComponentAnnotation
@Component("userMapper")
public interface UserMapper {
    public void addUser(User user) ;

    public void updateUser(User user);

    public void deleteById(int id);

    public User findById(int id);


    public List<User> findAll();

    public User getUser(int id);

    public User listUser();
}
