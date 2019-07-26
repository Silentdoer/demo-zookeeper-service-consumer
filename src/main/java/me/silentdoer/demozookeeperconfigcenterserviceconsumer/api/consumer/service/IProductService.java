package me.silentdoer.demozookeeperconfigcenterserviceconsumer.api.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign和Ribbon的最大区别在于Ribbon是直接在RestTemplate里指定要请求的服务名（如product-service），而
 * Feign则是通过写一个接口，然后在这个接口上做一些配置，定义来实现访问某个服务（具体是哪个服务实例由Feign内部自己去做Select）
 * 有点像Mybatis的Mapper接口；
 * 这里通过value指定这个ServiceApi要访问的服务是哪个
 *
 * Feign有点像RPC框架里的WebService，这个IProductService就像是product-service的一个代理一样
 */
@Service
@RequestMapping("/mock")
@FeignClient("product-service"/*专门用于请求product-service*/)
public interface IProductService {

    @GetMapping("/get_some_thing")
    String getSomeThing();

    /**
     * 注意，这里的方法签名要和服务提供者对应的接口方法签名完全一样（路径要匹配），注解什么的也是;
     * 当然，不要上面的RequestMapping也行，但是这里的每个XxxMapping就都要加/mock
     */
    @GetMapping("/lalala")
    String lalala(@RequestParam("user_id") Integer userId);
}
