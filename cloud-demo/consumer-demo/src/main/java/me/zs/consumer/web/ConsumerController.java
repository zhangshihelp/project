package me.zs.consumer.web;

import me.zs.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // 发现服务的类
    // @Autowired
    // private DiscoveryClient discoveryClient;

    // 使用轮询的方式获取服务
    // @Autowired(required = false)
    // private RibbonLoadBalancerClient client;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        // 第一种，写死的方式
        // 根据服务id获取实例
        // List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 从实例中取出ip和端口
        // ServiceInstance instance = instances.get(0);

        // 第二种，默认采用轮询的方式获取服务
        // ServiceInstance instance = client.choose("user-service");

        // String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;

        // 第三种,采用拦截器拦截请求，找到user-service服务实例(轮询)
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
