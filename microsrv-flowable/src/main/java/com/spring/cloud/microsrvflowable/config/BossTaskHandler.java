package com.spring.cloud.microsrvflowable.config;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/10/15 15:27
 * @version: v1.0
 */
public class BossTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("老板");
    }
}