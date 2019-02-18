package com.wxl.activemqdemo;

import com.wxl.activemqdemo.activemq.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
//public class ActivemqDemoApplication implements CommandLineRunner {
//
//  public static void main(String[] args) {
//    SpringApplication.run(ActivemqDemoApplication.class, args);
//  }
//
//  @Autowired
//  private JmsTemplate jmsTemplate;
//  @Autowired
//  private KafkaTemplate kafkaTemplate;
//
//  /**
//   *
//   * @param args
//   * @throws Exception
//   */
//  @Override
//  public void run(String... args) throws Exception {
//    //启动时发送消息到activemq
//    jmsTemplate.send("my-destination",new Msg());
//    //启动时发送消息到kafka
//    kafkaTemplate.send("topic","key","message");
//
//  }
public class ActivemqDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActivemqDemoApplication.class, args);
  }


}

