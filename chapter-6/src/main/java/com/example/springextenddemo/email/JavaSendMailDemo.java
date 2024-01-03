package com.example.springextenddemo.email;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Java 发送邮件
 */
public class JavaSendMailDemo {


    /**
     * 邮箱账户
     */
    public static String emailAddress = "changhe626@163.com";
    /**
     * 授权码
     */
    public static String emailPassword = "OTLXYXXOELTJRMSO";

    // 发件人邮箱的 SMTP 服务器地址
    public static String smtpHost = "smtp.163.com";


    public static void main(String[] args) throws Exception {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.host", smtpHost);
        // 是否需要请求认证
        props.setProperty("mail.smtp.auth", "true");
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 观察详细的发送日志
        session.setDebug(true);
        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, emailAddress, "1507775353@qq.com");
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        //5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        transport.connect(emailAddress, emailPassword);
        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        // 7. 关闭连接
        transport.close();
        System.out.println("完成邮件的发送");
    }


    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session            和服务器交互的会话
     * @param sendMailAddress    发件人邮箱
     * @param receiveMailAddress 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMailAddress,
                                                String receiveMailAddress) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMailAddress, "紫龙神", "UTF-8"));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAddress, "你好", "UTF-8"));
        // 4. Subject: 邮件主题
        message.setSubject("你好,请问你吃饭了没有啊", "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("你好,许久不见,想问问你吃饭了没有啊", "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }

}