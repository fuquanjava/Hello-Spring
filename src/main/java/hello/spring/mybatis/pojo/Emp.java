package hello.spring.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-19 下午10:14
 */
public class Emp implements Serializable {
    private Dept dept; // 持有DEPT 的引用

    private Integer id;

    private  String name;

    private Date hireDate  ;

    private String job;

    private  Integer deptNo;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", job='" + job + '\'' +
                ", deptNo=" + deptNo +
                '}';
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
