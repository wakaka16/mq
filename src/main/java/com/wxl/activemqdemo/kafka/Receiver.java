package com.wxl.activemqdemo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author wangxiaolong
 * @date 2019/1/28 16:33
 *
 * activemq消息监听接收处理
 */
public class Receiver {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  @KafkaListener(topics = "topic")
  public void receivedMessage(String message) {
    System.out.println("接受到："+message);
  }


}
