package com.atguigu.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Employee
 * Package: com.atguigu.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/9 15:43
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer eid;
    private String ename;
    private Double salary;
    private String gender;
    private String tel;
    private String address;
    private Integer did;

    /**
     * 员工所属的部门
     */

    private Department department;
}
