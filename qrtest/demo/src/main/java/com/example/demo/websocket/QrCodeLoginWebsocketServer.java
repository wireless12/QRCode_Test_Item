package com.example.demo.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.example.demo.utils.TokenUtil;



@Component
@ServerEndpoint("/websocket/{sid}")
public class QrCodeLoginWebsocketServer {

  private static AtomicInteger onlineSessionClientCount = new AtomicInteger(0);

  /**
   * 存放所有在线的客户端
   */
  private static Map<String, Session> onlineSessionClientMap = new ConcurrentHashMap<>();

  private String sid;
  private Session session;
  @OnOpen
  public void onOpen(@PathParam("sid") String sid, Session session) {
      /**
       * session.getId()：当前session会话会自动生成一个id，从0开始累加的。
       */
      //加入 Map中。将页面的sid和session绑定或者session.getId()与session
      onlineSessionClientMap.put(sid, session);

      //在线数加1
      onlineSessionClientCount.incrementAndGet();
      this.sid = sid;
      this.session = session;
  }

  /**
   * 连接关闭调用的方法。由前端<code>socket.close()</code>触发
   *
   * @param sid
   * @param session
   */
  @OnClose
  public void onClose(@PathParam("sid") String sid, Session session) {
    System.out.println(123);
      //onlineSessionIdClientMap.remove(session.getId());
      // 从 Map中移除
      onlineSessionClientMap.remove(sid);
      System.out.println("连接关闭" + sid);
      //在线数减1
      onlineSessionClientCount.decrementAndGet();
  }

  /**
   * 收到客户端消息后调用的方法。由前端<code>socket.send</code>触发
   * * 当服务端执行toSession.getAsyncRemote().sendText(xxx)后，前端的socket.onmessage得到监听。
   *
   * @param message
   * @param session
   */
  @OnMessage
  public void onMessage(String message, Session session) {
      /**
       * html界面传递来得数据格式，可以自定义.
       * {"sid":"user-1","message":"hello websocket"}
       * 由于是简单演示，固仅自定义了字符串格式
       */
      System.out.println(message);
      String token = message.split("&&&&")[1];
      String loginId = message.split("&&&&")[0];
//        String toSid = jsonObject.getString("sid");
//        String msg = jsonObject.getString("message");
        System.out.println(loginId);
      String userData = TokenUtil.getUserData(token);
      sendToOne(loginId,userData);
      sendToOne(sid, "200");
  }

  /**
   * 发生错误调用的方法
   *
   * @param session
   * @param error
   */
  @OnError
  public void onError(Session session, Throwable error) {
    //   System.out.println("发生错误");
    //   error.printStackTrace();
  }

  /**
   * 群发消息
   *
   * @param message 消息
   */
  private void sendToAll(String message) {
      // 遍历在线map集合
      onlineSessionClientMap.forEach((onlineSid, toSession) -> {
          // 排除掉自己
          if (!sid.equalsIgnoreCase(onlineSid)) {
              toSession.getAsyncRemote().sendText(message);
          }
      });
  }

  /**
   * 指定发送消息
   *
   * @param toSid
   * @param message
   */
  private void sendToOne(String toSid, String message) {
      // 通过sid查询map中是否存在
      System.out.println(message);
      Session toSession = onlineSessionClientMap.get(toSid);
      if (toSession == null) {
          return;
      }
      // 异步发送
      toSession.getAsyncRemote().sendText(message);
      /*
      // 同步发送
      try {
          toSession.getBasicRemote().sendText(message);
      } catch (IOException e) {
          log.error("发送消息失败，WebSocket IO异常");
          e.printStackTrace();
      }*/
  }
}
