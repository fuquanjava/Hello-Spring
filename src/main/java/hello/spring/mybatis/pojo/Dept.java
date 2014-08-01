package hello.spring.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-19 下午3:29
 */
public class Dept implements Serializable{

    private List<Emp> emps;//关联emp

    private Integer deptno;
    private String dname;
    private String loc;

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (!deptno.equals(dept.deptno)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return deptno.hashCode();
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
