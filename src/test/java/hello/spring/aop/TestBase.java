package hello.spring.aop;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-25 下午3:35
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:applicationContext-aop.xml","classpath:applicationContext.xml"}
)
 //@TransactionConfiguration(transactionManager = "txManager", defaultRollback=false)
public class TestBase  extends AbstractJUnit4SpringContextTests {

    // 继承 AbstractJUnit4SpringContextTests ，我们的测试类继承该类后将获取到Test Fixture的依赖注入好处
    // what the fuck ?
}
