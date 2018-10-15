package com.spring.cloud.microsrvflowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicrosrvFlowableApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvFlowableApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner init(final RepositoryService repositoryService,
//                                  final RuntimeService runtimeService,
//                                  final TaskService taskService) {
//
//        return f -> {
//            System.out.println("Number of process definitions : "
//                    + repositoryService.createProcessDefinitionQuery().count());
//            System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//            runtimeService.startProcessInstanceByKey("oneTaskProcess");
//            System.out.println("Number of tasks after process start: "
//                    + taskService.createTaskQuery().count());
//        };
//    }
}