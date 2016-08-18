package org.victor.test.wrapper;

import java.math.BigDecimal;

/**
 * Created by zhengcunwen on 2016/7/16.
 */
public class UserWrapper {
    private Integer id;
    private String name;
    private BigDecimal salary;
    private Integer deptId;
    private Integer age;
    private Integer gender;

    public UserWrapper() {
    }

    public UserWrapper(String name, BigDecimal salary, Integer deptId, Integer age, Integer gender) {
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
        this.age = age;
        this.gender = gender;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
