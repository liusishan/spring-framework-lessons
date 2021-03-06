package com.easy.thinking.in.spring.ioc.overview.domain;

/**
 * 用户类
 *
 * @author lss
 * @date 2020-02-03 22:50
 * @since
 * @description 用户类
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
