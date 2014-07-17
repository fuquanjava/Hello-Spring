package hello.spring.hibernate;

import hello.spring.jdbc.dao.IUserDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-1 下午4:13
 */
public class TestCase extends  TestBase {

    @Autowired
    private IUserDAO hibernateDao;

    @Test
    public void t1(){
        System.out.println("hibernateDao:"+hibernateDao);
    }

}
