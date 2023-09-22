package com.atguigu.pojos;

import com.atguigu.groups.AddGroup;
import com.atguigu.groups.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Schedule
 * Package: com.atguigu.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 15:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @NotNull(message = "id不能为空",groups = {UpdateGroup.class})
    @Null(message = "id必须为空",groups = {AddGroup.class})
    private Integer id;
    @NotBlank(message = "title不能为空",groups = {UpdateGroup.class,AddGroup.class})
    private String title;

    @NotNull(message = "completed不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private Boolean completed;
}
