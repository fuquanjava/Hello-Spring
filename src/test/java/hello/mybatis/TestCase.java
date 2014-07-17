package hello.mybatis;

import hello.mybatis.mapper.UserMapper;
import hello.spring.aop.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-16 下午10:20
 */

public class TestCase {
    SqlSession session = null;
    @Before
    public void setUp(){
        System.out.println("加载配置文件");
        String config = "MyBatis-Configuration.xml";
        try {
            Reader reader = Resources.getResourceAsReader(config);
            SqlSessionFactoryBuilder sessionFactoryBuilder  =
                        new SqlSessionFactoryBuilder();
            SqlSessionFactory sf = sessionFactoryBuilder.build(reader);
            session = sf.openSession();
            System.out.println("sqlSession:"+session);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载文件失败");
        }
    }
    @After
    public void tearDown(){
       if( null != session){
           session.close();;
       }
    }
    @Test
    public void insert(){
        for (int i = 0; i<10000; i++){
            User u1 = new User();
            u1.setName("uuu"+i);
            u1.setPassword("000"+i);
            u1.setEmail("124@12.com");
            u1.setLastlogintime(new Date());

            session.insert("addUser", u1);
            session.commit();; //提交事务
        }


    }

    @Test
    public void testUpdate(){
        User user  = session.selectOne("findById" , 2);
        user.setLastlogintime(new Date());
        session.update("updateUser",user);
        session.commit();;
    }

    @Test
    public void find(){
        User user  = session.selectOne("findById" , 1);
        System.out.println("user:"+user);
    }
    @Test
    public void findAll(){
        List<User> users = session.selectList("findAll");
        for(User user: users){
            System.out.println("user:"+user);
        }
    }

    @Test
    public void testPage(){
        int offset = 2;
        int pageSize = 10;
        RowBounds rowBounds = new RowBounds(offset,pageSize);
        List<User> users = session.selectList("findAll", null , rowBounds);
        for(User user: users){
            System.out.println("user:"+user);
        }

    }

    /** 测试 返回 Map */
    @Test
    public void testMap(){
        Map map =  session.selectOne("getUser" , 1);
        System.out.println(map.get("name"));


    }

    /** 测试 mapper */
    @Test
    public void testMapper(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u1 = mapper.findById(1);
        System.out.println("u1的类型:"+u1.getClass().getSimpleName()); // 真正的User，不是代理的
        System.out.println("u1------>"+u1);

    }

}
