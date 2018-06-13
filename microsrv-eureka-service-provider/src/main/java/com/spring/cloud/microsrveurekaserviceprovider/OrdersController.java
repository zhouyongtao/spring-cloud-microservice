package com.spring.cloud.microsrveurekaserviceprovider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制器
 */
@RestController
@RequestMapping("/v1/orders")
public class OrdersController {

    @RequestMapping("/total")
    public Integer getTotalNum()
    {
        return 100;
    }
}
