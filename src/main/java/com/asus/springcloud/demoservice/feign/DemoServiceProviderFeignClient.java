//package com.asus.springcloud.demoservice.feign;
//
//import com.asus.springcloud.demoservice.feign.hystrix.DemoServiceProviderFeignClientHystrix;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * @author kevinli
// * @date 2018/9/6
// */
//@Service
//@FeignClient(value = "demo-service-provider", fallback = DemoServiceProviderFeignClientHystrix.class)
//public interface DemoServiceProviderFeignClient {
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    String helloFromDemoServiceProvider();
//}
