package com.atguigu.mapper;

import com.atguigu.pojos.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: EmployeeMapper
 * Package: com.atguigu.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/9 16:31
 * @Version 1.0
 */
public interface EmployeeMapper {
    /**
     * 根据员工id查询员工信息
     * @param eid
     * @return
     */
    Employee findEmployeeWithDepartmentByEid(Integer eid);

    /**
     * 根据员工的性别查询员工信息，如果性别为null或者为空字符串，则查询所有员工信息
     * @param gender
     * @return
     */
//    因为是返回多个员工信息，所以用对象返回会装不下，需要用集合装入
    List<Employee> findEmployeeListByGender(String gender);


    /**
     * 1. 如果传入的salary不为空，但是传入的gender为空，则查询salary大于传入的salary的所有员工信息
     *    SELECT * FROM t_employee WHERE salary > #{salary}
     * 2. 如果传入的salary为空，但是传入的gender不为空，则查询gender等于传入的gender的所有员工信息
     *    SELECT * FROM t_employee WHERE gender = #{gender}
     * 3. 如果传入的salary不为空，传入的gender也不为空，则查询salary大于传入的salary并且gender等于传入的gender的所有员工信息
     *    SELECT * FROM t_employee WHERE salary > #{salary} AND gender = #{gender}
     * 4. 如果传入的salary为空，传入的gender也为空，则查询所有员工信息
     *    SELECT * FROM t_employee
     * @param salary
     * @param gender
     * @return
     */

    List<Employee> findEmployeeGtSalaryAndGender(@Param("salary") Double salary ,@Param("gender")String gender);

    /**
     * 修改员工信息，要求如果传入的员工对象的某个属性为null，则不修改该属性
     * @param employee
     */
    void updateEmployee(Employee employee);


    /**
     * 根据salary查询员工列表
     * 1. 如果salary为null，则查询所有员工信息
     * 2. 如果salary不为null，并且小于50000，则查询salary小于传入的salary的所有员工信息
     * 3. 如果salary不为null，并且大于等于50000，则查询salary大于传入的salary的所有员工信息
     * @param salary
     * @return
     */
    List<Employee> findEmployeeListBySalary(Double salary);


    /**
     * 根据eidList查询员工列表
     * @param eidList
     * @return
     */
    List<Employee> findEmployeeListByEIdList(@Param("eidList") List<Integer> eidList);


    /**
     * 批量插入员工信息
     * @param employeeList
     */

    void insertBatche(@Param("employeeList") List<Employee> employeeList);
}
