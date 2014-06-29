package hello.spring.aop;

import hello.spring.aop.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-25 下午3:40
 */
public class AopCase extends  TestBase {


    @Qualifier("userSerivce") //指定具体的name
    @Autowired  //按照  类型匹配
    private IUserService userService;

    @Test
    public void t1(){
        //userService.delete();
        userService.save();
        //userService.update();

    }
}
