package com.spring.cloud.microsrvflowable.config;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/10/15 11:22
 * @version: v1.0
 */
@Configuration
@Slf4j
public class FlowableProcessConfig {

//    @Autowired
//    private DataSourceProperties dataSourceProperties;
//
//    @Bean
//    @Primary
//    protected ProcessEngineConfiguration configuration() {
//
//        List<FlowableEventListener> list = new ArrayList<>();
//        //增加job监听  JobListener()类后面详细分析
//        list.add(new JobListener());
//        //配置监听类型（与JobListener配合）
//        Map<String,List<FlowableEventListener>> map = new HashMap<>();
//        map.put("JOB_EXECUTION_SUCCESS",list);
//        map.put("JOB_EXECUTION_FAILURE",list);
//
//        ProcessEngineConfiguration processEngineConfiguration = StandaloneProcessEngineConfiguration
//                .createStandaloneProcessEngineConfiguration()
//                .setJdbcUrl(dataSourceProperties.getUrl())
//                .setJdbcDriver(dataSourceProperties.getDriverClassName())
//                .setJdbcUsername(dataSourceProperties.getUsername())
//                .setJdbcPassword(dataSourceProperties.getPassword())
//                //如果表不存在，自动创建表
//                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
//                //属性asyncExecutorActivate定义为true，工作流引擎在启动时就建立启动async executor线程池
//                .setAsyncExecutorActivate(false)
//                //流程发布的时候是否生成流程图
//                .setCreateDiagramOnDeploy(true)
//                //生成流程图参数
//                .setProcessDiagramGenerator(new DefaultProcessDiagramGenerator())
//                .setActivityFontName("幼圆")
//                .setAnnotationFontName("幼圆")
//                .setLabelFontName("幼圆");
//        //配置监听
//        processEngineConfiguration.setTypedEventListeners(map);
//
//        return processEngineConfiguration;
//    }

//    @Bean
//    protected ProcessEngine engine() {
//        //创建流程引擎服务启动是初始化一次即可
//        return ProcessEngines.getDefaultProcessEngine();
//    }
}
