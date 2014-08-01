package hello.spring.mybatis.dao;

import hello.spring.mybatis.pojo.Dept;

import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-19 下午3:30
 */
public interface IDeptDao {
    public List<Dept> findAll();
}
