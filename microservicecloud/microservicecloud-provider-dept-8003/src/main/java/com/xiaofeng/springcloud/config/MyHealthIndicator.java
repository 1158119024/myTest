package com.xiaofeng.springcloud.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    private int healthIndicatorErrorCount;

    private int healthIndicatorCount;

    private boolean hasError = false;

    @Override
    public Health health() {
        if (!hasError) {
            healthIndicatorCount++;
            //每检测5次，就返回DOWN
            if (healthIndicatorCount % 5 == 0) {

                hasError = true;
            }
        } else {
            //DOWN计数10次就UP
            healthIndicatorErrorCount++;
            if (healthIndicatorErrorCount > 3) {
                hasError = false;
                healthIndicatorErrorCount = 0;
            }
        }
        if (hasError) {
            return new Health.Builder(Status.DOWN).build();
        }
        return new Health.Builder(Status.UP).build();
    }

}
