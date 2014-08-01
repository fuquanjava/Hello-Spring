package hello.spring.mybatis.dao;

import hello.spring.aop.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-19 下午5:02
 */
@Repository("myBatisUserDao")
public class UserDaoImpl implements  IUserDao {

    @Qualifier("sqlSessionTemplate")
    @Autowired
    private SqlSessionTemplate template;

    @Override
    public void addUser(User user) {
        template.insert("addUser", user);
    }

    @Override
    public void updateUser(User user) {
        template.update("updateUser" ,user);
    }

    @Override
    public void deleteById(int id) {
        template.delete("deleteById" , id);
    }

    @Override
    public User findById(int id) {
      return  template.selectOne("findById" , id);
    }

    @Override
    public List<User> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUser(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User listUser() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
