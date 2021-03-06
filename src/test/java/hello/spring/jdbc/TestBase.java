package hello.spring.jdbc;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-25 下午3:35
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:applicationContext-jdbc.xml"}
)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback=false) //false 不回滚事务
@Transactional
public class TestBase extends AbstractJUnit4SpringContextTests {

    // 继承 AbstractJUnit4SpringContextTests ，我们的测试类继承该类后将获取到Test Fixture的依赖注入好处
    // what the fuck ?
}
