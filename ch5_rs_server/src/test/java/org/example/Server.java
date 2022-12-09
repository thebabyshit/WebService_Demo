package org.example;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.example.service.UserServiceImpl;

/**
 * @Author
 * @Date 2022/11/28 14:50
 * @Description
 **/
public class Server {
    public static void main(String[] args) {
        //创建发布服务的工厂
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();

        //设置服务地址
        factoryBean.setAddress("http://localhost:8001/ws/");

        //设置服务类
        factoryBean.setServiceBean(new UserServiceImpl());

        //添加日志输入输出拦截器
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        //发布服务
        factoryBean.create();

        System.out.println("服务发布成功");
    }

}
