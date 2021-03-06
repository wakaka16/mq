package com.wxl.activemqdemo.websocket;

import java.util.Date;

/**
 * @author wangxiaolong
 * @date 2019/2/18 9:49
 */
public class InputMessage {
  private String from;//来源
  private String text;//内容
  private Date time;//时间

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
