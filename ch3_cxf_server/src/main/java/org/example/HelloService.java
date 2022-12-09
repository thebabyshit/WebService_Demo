package org.example;

import javax.jws.WebService;

/**
 * @Author
 * @Date 2022/11/23 11:11
 * @Description 对外发布服务的接口
 **/
@WebService
public interface HelloService {
    /**
     * 对外发布服务的接口的操作/方法
     */
    public String sayHello(String name);
}
