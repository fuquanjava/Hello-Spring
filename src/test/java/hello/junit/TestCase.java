package hello.junit;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static  org.junit.Assert.*;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-28 下午2:53
 */
public class TestCase {
    private Logger logger = LoggerFactory.getLogger(TestCase.class);

    Foo foo ;
    // 在junit3中的初始化方法叫 setUp(), 所以在junit4后也习惯把初始化方法 setUp();
    @Before
    public void setUp(){
        foo = new Foo();
        logger.info("setUp======================初始化==========");
    }

    @Test
    public void testAdd(){
       assertEquals("添加" , foo.add(1,2), 3);

    }

    @Test(expected = RuntimeException.class)   //指定抛出异常
    public void testDivide(){
        assertEquals("除法:", foo.divide(4,2 ),2);
    }

    @Test(timeout = 1000)  //指定方法的有效执行时间,超过时间抛出异常
    public void testMinus(){
        assertEquals("减法:", foo.minus(3,1) , 2);
    }
}
