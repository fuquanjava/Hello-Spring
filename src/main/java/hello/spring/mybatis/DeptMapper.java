package hello.spring.mybatis;

import hello.spring.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-19 下午3:30
 */
@MyBatisComponentAnnotation
@Component("deptMapper")
public interface DeptMapper {
    public List<Dept> findAll();

    public void saveDept ( Dept dept) ;

    public Dept getDept(int deptno);

    public List<Dept> listDeptPage(@Param("orderColumn") String orderColumn ,
                                    @Param("offset")int offset , @Param("limit")int limit);

    public List<Dept> listDeptPage2(String orderColumn , int offset , int limit);

}
