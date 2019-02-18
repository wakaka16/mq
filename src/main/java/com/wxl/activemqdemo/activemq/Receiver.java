package com.wxl.activemqdemo.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author wangxiaolong
 * @date 2019/1/28 16:33
 *
 * activemq消息监听接收处理
 */
//@Component
public class Receiver {
  @JmsListener(destination = "my-destination")
  public void  receivedMessage(String message){
    System.out.println("接受到："+message);
  }

}
