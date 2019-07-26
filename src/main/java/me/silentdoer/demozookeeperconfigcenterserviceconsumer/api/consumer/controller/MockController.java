package me.silentdoer.demozookeeperconfigcenterserviceconsumer.api.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import me.silentdoer.demozookeeperconfigcenterserviceconsumer.api.consumer.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mock")
@Slf4j
public class MockController {

    @Resource
    private IProductService productService;

    @GetMapping("/test")
    public String test() {
        return productService.getSomeThing();
    }

    @GetMapping("/test2")
    public String test2(@RequestParam("user_id") Integer userId) {
        return productService.lalala(userId);
    }
}
