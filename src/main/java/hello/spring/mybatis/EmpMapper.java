package hello.spring.mybatis;

import hello.spring.mybatis.pojo.Emp;
import org.springframework.stereotype.Component;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-16 下午10:32
 */
@MyBatisComponentAnnotation
@Component("empMapper")
public interface EmpMapper {
    public Emp findById(int id);
}
