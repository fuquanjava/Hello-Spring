package hello.spring.aop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * fuquanemail@gamil.com
 */
public class User  implements  Serializable{
    private static final long serialVersionUID = 8160066602222958933L;

    private String  id ;

    private String name;

    private String password;

    private String email ;

    private Date lastlogintime;


    public String getId() {
        System.out.println("getId:"+id);
        return id;
    }

    public void setId(String id) {
        System.out.println("setId:"+id);
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.name+","+this.password+","+this.email+","+this.lastlogintime;
    }
}
