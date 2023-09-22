package com.atguigu.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名:com.atguigu.pojos
 *
 * @author Leevi
 * 日期2023-09-03  10:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private Integer id;
    private String title;
    private Boolean completed;
}
