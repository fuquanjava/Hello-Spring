package hello.spring.autoproxy;

import hello.spring.aop.entity.User;
import hello.spring.jdbc.dao.IUserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-1 下午5:08
 */
public class UserImpl implements IUserDAO{

    private Logger logger = LoggerFactory.getLogger(UserImpl.class);

    @Override
    public void save(User user) {
        logger.info("==============save===============");
    }

    @Override
    public void update(User user) {
        logger.info("==============update===============");
    }

    @Override
    public User getUserById(String id) {
        logger.info("==============getUserById===============");
        return  null;
    }

    @Override
    public void delete(String id) {
        logger.info("==============delete===============");
    }

    @Override
    public List<User> listAll() {
        logger.info("==============listAll===============");
        return  null;
    }

    @Override
    public int queryCount() {
        logger.info("==============queryCount===============");
        return  0 ;
    }
}
