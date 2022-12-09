package org.example;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.example.impl.HelloServiceImpl;

/**
 * @Author
 * @Date 2022/11/23 11:14
 * @Description
 **/
public class Server {
    public static void main(String[] args) {
        //发布服务的工厂
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

        //设置服务地址
        factoryBean.setAddress("http://localhost:8000/ws/hello");

        //设置服务类
        factoryBean.setServiceBean(new HelloServiceImpl());

        //添加日志输入输出拦截器
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        factoryBean.create();
        System.out.println("发布服务成功!!!");
    }
}
