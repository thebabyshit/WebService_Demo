package org.example;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @Author
 * @Date 2022/11/23 11:21
 * @Description
 **/
public class Client {
    public static void main(String[] args) {
        //服务接口访问地址: http://localhost:8000/ws/hello

        //创建cxf代理工厂
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();

        //设置远程访问服务端地址
        factoryBean.setAddress("http://localhost:8000/ws/hello");


        //设置接口类型
        factoryBean.setServiceClass(HelloService.class);

        //生成接口代理对象
        HelloService helloService = factoryBean.create(HelloService.class);

        //代理对象调用
        System.out.println(helloService.getClass());
        String msg = helloService.sayHello("NXU2022");
        System.out.println(msg);
    }
}
