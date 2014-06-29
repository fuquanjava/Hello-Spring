package hello.junit;


import org.junit.Before;
import org.junit.Test;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-28 下午3:59
 */
public class TestA {
    @Before
    public void setUp(){
        System.out.println("setUp()..");
    }

    @Test
    public void testXX(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
