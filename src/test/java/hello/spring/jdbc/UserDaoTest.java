package hello.spring.jdbc;

import hello.spring.aop.entity.User;
import hello.spring.jdbc.dao.IUserDAO;
import hello.spring.jdbc.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-26 下午10:27
 */
public class UserDaoTest extends  TestBase{

    @Qualifier("userDao")
    @Autowired
    private IUserDAO userDao ;

    @Qualifier("userService")
    @Autowired
    private IUserService userService;

    @Test
    public void testUserTX(){
       userService.testUserTX();

    }



    public void testSave() throws Exception {
        User user = new User();
        user.setId("2");
        user.setName("hello");
        user.setEmail("1231@12.com");
        user.setPassword("1231");
        user.setLastlogintime(new Date());
        userDao.save(user);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGetUserById() throws Exception {
        User user = userDao.getUserById("1");
        System.out.println("user:"+user);
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testListAll() throws Exception {

    }

    @Test
    public void testQueryCount() throws Exception {
        int count = userDao.queryCount();
        System.out.println("count:"+count);
    }
}
