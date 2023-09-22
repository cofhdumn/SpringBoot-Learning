package com.atguigu.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: Department
 * Package: com.atguigu.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/9 16:37
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer did;
    private String dname;
    private String description;

    /**
     * 一个部门对应多个员工
     */
    private List<Employee> employeeList;
}
