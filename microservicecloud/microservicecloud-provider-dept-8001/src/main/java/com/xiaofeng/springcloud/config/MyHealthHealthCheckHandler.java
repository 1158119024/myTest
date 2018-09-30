package com.xiaofeng.springcloud.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.xiaofeng.springcloud.config.MyHealthIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    private MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus currentStatus){
        Status status=myHealthIndicator.health().getStatus();
        System.out.println(status);
        if(status== Status.UP){
            return InstanceInfo.InstanceStatus.UP;
        }else{
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
