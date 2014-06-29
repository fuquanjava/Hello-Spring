package hello.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-28 下午4:00
 */

@RunWith(Suite.class)  //可以执行多个junit
@Suite.SuiteClasses({TestCase.class , TestA.class})
public class TestSuite {

}
