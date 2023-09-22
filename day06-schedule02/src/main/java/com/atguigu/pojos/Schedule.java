package com.atguigu.pojos;

import com.atguigu.groups.AddGroup;
import com.atguigu.groups.UpdateGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public class Schedule {

    @Null(message = "id must be null", groups = {AddGroup.class})
    @NotNull(message = "is must not be null", groups = {UpdateGroup.class})
    private Integer id;

    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @Size(min = 1, max = 6, groups = {AddGroup.class, UpdateGroup.class})
    private String title;

    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    private Boolean completed;

    public Schedule(Integer id, String title, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Schedule() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }


}
