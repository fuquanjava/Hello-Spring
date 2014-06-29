package hello.spring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-25 下午2:51
 */

@Service("userSerivce")
public class UserServiceImpl implements  IUserService {
    private static  final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean  save() {
        logger.info("保存用户信息");

        return true; //返回给后置通知
    }

    @Override
    public void delete() {
        logger.info("删除用户信息");
    }

    @Override
    public void update() {
        logger.info("更新用户信息");
    }
}
