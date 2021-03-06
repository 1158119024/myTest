package com.xiaofeng.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套   客户端负载均衡   的工具。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * IRule：根据特定算法中从服务列表中选取一个要访问的服务
     *  RoundRobinRule: 轮询(默认)
     *  RandomRule: 随机
     *  AvailabilityFilteringRule: 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
     *  WeightedResponseTimeRule: 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大，被选中的概率越高。
                        刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule
     * RetryRule: 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
     * BestAvailableRule: 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一下并发量最小的服务
     * ZoneAvoidanceRule: 默认规则，复合判断server所在区域的性能和server的可用性选择服务器
     * @return
     */
//    @Bean
//    public IRule getRule(){
////        return new AvailabilityFilteringRule();
////        return new RetryRule();
//        return new RoundRobinRule();
//    }

}
