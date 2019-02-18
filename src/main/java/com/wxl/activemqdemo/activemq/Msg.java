package com.wxl.activemqdemo.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.MessageCreator;

/**
 * @author wangxiaolong
 * @date 2019/1/28 16:29
 */
public class Msg implements MessageCreator {

  @Override
  public Message createMessage(Session session) throws JMSException {
    return session.createTextMessage("信息内容巴拉巴拉");
  }
}
