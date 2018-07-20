package com.spring.cloud.microsrveurekaserviceprovider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class MicrosrvEurekaServiceProviderApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String home() {
        return "microsrv-eureka-order-service-provider";
    }

    @PreAuthorize("hasRole('all')")
    @GetMapping("/registered")
    public List<String> getRegistered() {
        List<String> list = discoveryClient.getServices();//discoveryClient.getInstances("STORES");
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());
        for (String s : discoveryClient.getServices()) {
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
            for (ServiceInstance si : serviceInstances) {
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }
        }
        return list;
    }

        public static void main(String[] args) {
        SpringApplication.run(MicrosrvEurekaServiceProviderApplication.class, args);
    }
}