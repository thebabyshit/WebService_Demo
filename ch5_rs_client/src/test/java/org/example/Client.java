package org.example;

import org.apache.cxf.jaxrs.client.WebClient;
import org.example.entity.User;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

/**
 * @Author
 * @Date 2022/11/28 14:57
 * @Description
 **/
public class Client {

    @Test
    public  void testSave() {
       User user = new User();
       user.setCity("YC");
       user.setUsername("zhoubo");
       user.setId(11);

        //通过WebClient对象远程调用服务端
        WebClient.create("http://localhost:8001/ws/userService/user")
                .type(MediaType.APPLICATION_JSON)
                .post(user);
    }

    @Test
    public void testGet(){
        User user = WebClient
                .create("http://localhost:8001/ws/userService/user/1")
                .type(MediaType.APPLICATION_JSON)
                .get(User.class);
        System.out.println(user);
    }
}
