package cn.zhangpeng.springcxf.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther:zhangpeng
 * @Date:2019/8/12
 * @Description:cn.zhangpeng.springcxf
 * @Version:1.0
 */

public class Test {
    public static void main(String[] args) {
        //测试客户端
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath:spring-cxf.xml");
        WeatherService cxfClient = (WeatherService) classPathXmlApplicationContext.getBean("cxfClient");
        String weather= cxfClient.getWeatherMethod("shanghai");
        System.out.println(weather);

    }
    //测试使用webclient客户端访问restfulservice
    @org.junit.Test
    public void testRestfulCliet(){
        //!!!注意设置reader provider ：将jax-rs中的 json转换为object
        JacksonJsonProvider jacksonJsonProvider=new JacksonJsonProvider();
        List<JacksonJsonProvider> list =new ArrayList<JacksonJsonProvider>();
        list.add(jacksonJsonProvider);
        WebClient webClient = WebClient.create("http://localhost:8088/springcxf/ws/userService/user/getUserList/1" ,list);
       //指定accept的content-type和type 发送的content-type
        //获取集合
        Collection<? extends User> collection = webClient.type(MediaType.TEXT_HTML).accept(MediaType.APPLICATION_JSON).getCollection(User.class);
        System.out.println(collection);
        WebClient webClient1 = WebClient.create("http://localhost:8088/springcxf/ws/userService/user/getUser/1" ,list);
        //获取单个
        User user = webClient1.type(MediaType.TEXT_HTML).accept(MediaType.APPLICATION_JSON).get(User.class);
        System.out.println(user);

    }
}
