package hello.springmvc.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-13 下午10:08
 */
public class User  implements Serializable{

    private Integer id  = 1; //默认值 1 ，避免 hashcode方法出现空指针


    @NotEmpty(message = "name不能为空!")
    private  String name ;

    @NotEmpty(message = "password 不能为空!" )
    @Size(min = 6,max = 12 ,message = "密码位数必须在{min}-{max}位")
    private String password ;

    private Date loginTime;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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
}
