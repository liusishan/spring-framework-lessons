package com.easy.thinking.in.spring.ioc.overview.domain;

import com.easy.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * 超级用户
 *
 * @author lss
 * @date 2020-02-03 23:26
 * @description 超级用户
 * @since
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
            "address='" + address + '\'' +
            "} " + super.toString();
    }
}
