package com.atguigu.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageResult
 * Package: com.atguigu.result
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/10 15:59
 * @Version 1.0
 */


/*
前端需要展示这样的响应，所以需要定义一个实体类
	data:{
			   //假数据!
			   //本页数据
			   data:[
					 {id:1,title:'学习java',completed:true},
					 {id:2,title:'学习html',completed:true},
					 {id:3,title:'学习css',completed:true},
					 {id:4,title:'学习js',completed:true},
					 {id:5,title:'学习vue',completed:true}
				  ],
			   //分页参数
			   pageSize:5, // 每页数据条数 页大小
			   total:39 ,   // 总记录数
			   currentPage:1 // 当前页码
			}

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private List<T> data;
    private Integer pageSize;
    private Long total;
    private Integer currentPage;
}
