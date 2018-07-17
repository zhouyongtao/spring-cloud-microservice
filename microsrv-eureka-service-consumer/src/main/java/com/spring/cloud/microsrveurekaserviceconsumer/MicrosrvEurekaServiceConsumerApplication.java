package com.spring.cloud.microsrveurekaserviceconsumer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.stereotype.Component;
import java.util.Map;

@SpringCloudApplication
public class MicrosrvEurekaServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvEurekaServiceConsumerApplication.class, args);
    }

    @Component
    public class StoreIntegration {

        @HystrixCommand(fallbackMethod = "defaultName")
        public Object getStores(Map<String, Object> parameters) {
            //do stuff that might fail\
            return  "irving";
        }

        public Object defaultName(Map<String, Object> parameters) {
            return "no name";
        }
    }
}