package com.wxl.activemqdemo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author wangxiaolong
 * @date 2019/2/18 9:47
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

  /**
   * registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL。
   * websocket连接地址
   * @param stompEndpointRegistry
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
    // 添加服务端点，可以理解为某一服务的唯一key值
    stompEndpointRegistry.addEndpoint("/chatApp");
    //当浏览器支持sockjs时执行该配置
    stompEndpointRegistry.addEndpoint("/chatApp").setAllowedOrigins("*").withSockJS();
  }

  /**
   * 配置消息代理（接受到消息后，将消息进行处理的流程）
   * @param config
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    // 配置（接受）订阅消息地址（前缀）为topic的消息
    config.enableSimpleBroker("/topic");
    // Broker（接收）消息地址（前缀）与MessageController中的MessageMapping配合使用，相当于/app/**的url
    config.setApplicationDestinationPrefixes("/app");
  }
}