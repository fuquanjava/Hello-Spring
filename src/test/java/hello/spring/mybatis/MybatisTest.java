package hello.spring.mybatis;

import hello.spring.aop.entity.User;
import hello.spring.mybatis.dao.IUserDao;
import hello.spring.mybatis.pojo.Dept;
import hello.spring.mybatis.pojo.Emp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-26 下午10:27
 */
public class MybatisTest extends TestBase {

    //@Resource
    public UserMapper userMapper; //这不是错,只是userMapper的实例 是MapperScannerConfigurer生成的


    @Autowired
    public DeptMapper deptMapper;

    @Autowired
    public EmpMapper empMapper;

    //@Qualifier("myBatisUserDao")
   // @Autowired
    public IUserDao dao ;

    @Test
    public void testGet(){
       User user = userMapper.findById(1);
        System.out.println("------------------user:"+user);


    }

    public void testDept(){
        List<Dept> lists = deptMapper.findAll();
        System.out.println("lists:"+lists);
    }

    @Test
    public void insert(){
        User u1 = new User();
        for(int i=0;i < 100 ; i++){
            u1.setName("user-"+i);
            u1.setEmail("123@12.com");
            u1.setPassword("123");
            u1.setLastlogintime(new Date());
            userMapper.addUser(u1);
        }

    }

    @Test
    public void testTemplate(){
        User user  = dao.findById(2);
        System.out.println("=============================user:"+user);
    }

    @Test
    public void save(){
        Dept dept = new Dept();
        dept.setDname("开发");
        dept.setLoc("武汉");
        deptMapper.saveDept(dept);
        int id = dept.getDeptno();
        System.out.println("no:============================"+id);
    }

    @Test
    public void empMapper(){
        Emp emp = empMapper.findById(1);
        System.out.println("======================"+emp.getName());
        String dname = emp.getDept().getDname();
        System.out.println("======================"+dname);

    }

    @Test
    public void empMapper2(){
       Dept dept = deptMapper.getDept(10);
       List<Emp>emps =  dept.getEmps() ;
        System.out.println("========================="+emps.size());

    }

    @Test
    public void testDept2(){
        List<Dept> depts = deptMapper.listDeptPage("deptno", 0, 4);
        System.out.println("depts:"+depts.size());
        for(Dept dept : depts){
            System.out.println("====================dept:============================");
            System.out.print(dept.getDeptno());
            System.out.println("##############"+dept.getDname());

        }

    }
}
