package com.atguigu;

import com.atguigu.mapper.DepartmentMapper;
import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojos.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MybatisTest
 * Package: com.atguigu
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/9 17:52
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:spring-persist.xml")
public class MybatisTest {
   @Autowired
    private EmployeeMapper employeeMapper;

   @Autowired
   private DepartmentMapper departmentMapper;

   @Test
   public void test01(){
       employeeMapper.findEmployeeWithDepartmentByEid(1);
   }

   @Test
   public void test02(){
       employeeMapper.findEmployeeListByGender("女");
   }


   @Test
   public void test03(){
       employeeMapper.findEmployeeGtSalaryAndGender(20000d,"null");
   }

   @Test
   public void test04(){
       Employee employee = new Employee();
        employee.setEid(27);
        employee.setSalary(20000d);
        employee.setTel("1591917419");



       employeeMapper.updateEmployee(employee);
   }

   @Test
   public void test05(){
       employeeMapper.findEmployeeListBySalary(20000d);
   }


   @Test
   public void test06(){
       List<Integer> eidList = List.of(1,2,3,4,5,6,7);
       employeeMapper.findEmployeeListByEIdList(eidList);
   }

   @Test
   public void test07(){
       List<Employee> employeeList = new ArrayList<>();
       for (int i = 0; i < 10 ; i++){
           employeeList.add(new Employee(null,"test"+i,10000d+i,"男","188888745"+i,"北京",1,null));
       }

       employeeMapper.insertBatche(employeeList);
   }

   @Test
   public void test08(){
       departmentMapper.findDepartmentWithEmployeeListById(1);
   }

}
