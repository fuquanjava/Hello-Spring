package hello.spring.jdbc.dao;

import hello.spring.aop.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-6-25 下午11:26
 */

@Repository("userDao")
public class UserDaoImpl   implements  IUserDAO{


    private JdbcTemplate jdbcTemplate; //没有继承，直接注入


    @Resource(name="dataSource")
    public  void setDataSource(DataSource dataSource) {
        System.out.println("注入=======dataSource========开始====");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("注入=======dataSource========成功====");
    }

    public void save(User user){
        String saveSql = "insert into d_user(name, email, password,lastLoginTime) values (?,?,?,?)";
        this.jdbcTemplate.update(saveSql , new Object[]{user.getName() , user.getEmail(),user.getPassword(),user.getLastlogintime()});

    }

    @Override
    public void update(User user) {
        String sql = " update d_user  set name = ? , email = ? , password= ? , lastLoginTime = ? where id = ?";
        this.jdbcTemplate.update(sql, user.getName(),user.getEmail() , user.getPassword(),user.getLastlogintime() , user.getId());

    }

    @Override
    public User getUserById(String id) {
        String sql =  "select id , name , email , password , lastLoginTime from d_user where id = ?";
        return  this.jdbcTemplate.queryForObject(sql,new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setLastlogintime(rs.getDate("lastLoginTime"));
                return user;
            }
        } , id);
    }

    @Override
    public void delete(String id) {
        String sql =  " delete from d_user where id = ?";
        this.jdbcTemplate.update(sql , id);
    }


    public List<User> listAll() {
        String sql =  " select id , name , email , password , lastLoginTime from d_user";
        return this.jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setLastlogintime(rs.getDate("lastLoginTime"));
                return user;
            }
        });
    }

    @Override
    public int queryCount() {
        String sql  = "select count(1) from d_user";
        return this.jdbcTemplate.queryForInt(sql);
    }


}


