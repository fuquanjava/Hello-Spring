package hello.spring.autoproxy;

import hello.spring.jdbc.dao.IUserDAO;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-1 下午5:15
 */
public class Main {
    public static void main(String[] args) {
        IUserDAO dao = new UserImpl();
        dao.save(null);


    }
}
