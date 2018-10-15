package com.spring.cloud.microsrvflowable.config;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/10/15 15:26
 * @version: v1.0
 */
public class ManagerTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("经理");
    }

}