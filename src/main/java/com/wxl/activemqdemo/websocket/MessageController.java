package com.wxl.activemqdemo.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiaolong
 * @date 2019/2/18 9:48
 */
@RestController
public class MessageController {
  @Autowired
  private SimpMessagingTemplate template;

  /**
   * 1、接收客户端"/app/chat"的消息
   * 2、发送到所有订阅了"/topic/messages"的用户
   * @param inputMessage
   * @return
   * @throws Exception
   */
  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public OutputMessage receiveAndSend(InputMessage inputMessage) throws Exception {
    System.out.println("get message (" + inputMessage.getText() + ") from client!");
    System.out.println("send messages to all subscribers!");
    String time = new SimpleDateFormat("HH:mm").format(new Date());
    return new OutputMessage(inputMessage.getFrom(), inputMessage.getText(), time);
  }

  /**
   * 1、接收客户端"/app/chat_user"的消息
   * 2、直接从服务端发送消息给指定客户端（发送到所有订阅了"/topic/" + inputMessage.getFrom()的用户）
   * @param inputMessage
   * @param headerAccessor
   * @throws Exception
   */
  @MessageMapping("/chat_user")
  public void sendToSpecifiedUser(@Payload InputMessage inputMessage, SimpMessageHeaderAccessor headerAccessor) throws Exception {
    System.out.println("get message from client (" + inputMessage.getFrom() + ")");
    System.out.println("send messages to the specified subscriber!");
    String time = new SimpleDateFormat("HH:mm").format(new Date());
    this.template.convertAndSend("/topic/" + inputMessage.getFrom(), new OutputMessage(inputMessage.getFrom(), inputMessage.getText(), time));
  }
}
