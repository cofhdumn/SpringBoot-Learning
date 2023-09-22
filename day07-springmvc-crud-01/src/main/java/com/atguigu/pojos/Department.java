package com.atguigu.pojos;

/**
 * 包名:com.atguigu.pojos
 *
 * @author Leevi
 * 日期2023-08-29  14:18
 */
public class Department {
    private Integer did;
    private String dname;
    private String description;

    public Department() {
    }

    public Department(Integer did, String dname, String description) {
        this.did = did;
        this.dname = dname;
        this.description = description;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
