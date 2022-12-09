package org.example.impl;

import org.example.HelloService;

/**
 * @Author
 * @Date 2022/11/23 11:13
 * @Description
 **/
public class HelloServiceImpl implements HelloService
{
    @Override
    public String sayHello(String name) {
        return "Halo:"+name;
    }
}
