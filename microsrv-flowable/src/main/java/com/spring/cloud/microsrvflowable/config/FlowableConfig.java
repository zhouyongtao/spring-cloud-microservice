package com.spring.cloud.microsrvflowable.config;

import lombok.extern.slf4j.Slf4j;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Configuration;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/10/15 11:22
 * @version: v1.0
 */
@Configuration
@Slf4j
public class FlowableConfig implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {

    @Override
    public void configure(SpringProcessEngineConfiguration engineConfiguration) {
        engineConfiguration.setActivityFontName("微软雅黑");
        engineConfiguration.setLabelFontName("微软雅黑");
        engineConfiguration.setAnnotationFontName("微软雅黑");
    }
}