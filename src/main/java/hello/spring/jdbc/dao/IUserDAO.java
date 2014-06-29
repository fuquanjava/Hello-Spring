package hello.spring.jdbc.dao;

import hello.spring.aop.entity.User;

import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-26 下午9:53
 */
public interface IUserDAO {

    public void save(User user) ;


    public void update( User user) ;


    public User getUserById ( String id );

    public void  delete(String id );

    public List<User> listAll();


    public int queryCount();




}
