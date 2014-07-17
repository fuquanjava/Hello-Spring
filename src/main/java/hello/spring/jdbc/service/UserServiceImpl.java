package hello.spring.jdbc.service;

import hello.spring.aop.entity.User;
import hello.spring.jdbc.dao.IUserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-29 下午10:19
 */

@Service("userService")
public class UserServiceImpl implements  IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Qualifier("userDao")
    @Autowired
    private IUserDAO userDAO;


    @Override
    public void testUserTX() {
        logger.info("=======测试事务 begin============");
        User u1 = userDAO.getUserById("2");
        u1.setLastlogintime(new Date());
        userDAO.update(u1);
        userDAO.delete(userDAO.getUserById("3").getId());
        logger.info("=======测试事务 end ============");
    }
}
