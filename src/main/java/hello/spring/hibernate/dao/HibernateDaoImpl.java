package hello.spring.hibernate.dao;

import hello.spring.aop.entity.User;
import hello.spring.jdbc.dao.IUserDAO;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-1 下午3:24
 */

@Repository("hibernateDao")
public class HibernateDaoImpl implements IUserDAO {


    private HibernateTemplate hibernateTemplate;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void save(User user) {
        this.hibernateTemplate.saveOrUpdate(user);
    }

    @Override
    public void update(User user) {
        this.hibernateTemplate.saveOrUpdate(user);
    }

    @Override
    public User getUserById(String id) {
        return this.hibernateTemplate.get(User.class, id);
    }


    @Override
    public void delete(String id) {
        this.hibernateTemplate.delete(this.getUserById(id));
    }

    @Override
    public List<User> listAll() {
        String hql = " from hello.spring.aop.entity.User";
        return this.hibernateTemplate.find(hql);
    }

    @Override
    public int queryCount() {
        String hql = "select count(*) from hello.spring.aop.entity.User";
        List list = this.hibernateTemplate.find(hql);
        return Integer.valueOf(list.get(0).toString());
    }
}
