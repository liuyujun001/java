package com.example.springextenddemo.appender;


import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

/**
 * 自定义实现appender
 * @Plugin注解：是为了在之后配置log4j2.xml时，指定的Appender Tag
 */
@Plugin(name = "myAppender", category = "Core", elementType = "appender", printObject = true)
public class MyLog4j2Appender extends AbstractAppender {

    String printString;

    /**
     *构造函数 可自定义参数 这里直接传入一个常量并输出
     *
     */
    protected MyLog4j2Appender(String name, Filter filter, Layout<? extends Serializable> layout,
                               String printString) {
        super(name, filter, layout);
        this.printString = printString;
    }

    /**
     * 重写append()方法：这里面需要实现具体的逻辑，日志的去向。
     * 自定义实现输出
     * 获取输出值：event.getMessage().toString()
     * @param event
     */
    @Override
    public void append(LogEvent event) {
        if (event != null && event.getMessage() != null) {
            //格式化输出
            System.out.print("自定义appender"+printString + "：" + getLayout().toSerializable(event));
        }
    }


    /**
     * 接收log4j2-spring.xml中的配置项
     * @PluginAttribute 是xml节点的attribute值，如<book name="sanguo"></book> 这里的name是attribute
     * @PluginElement  表示xml子节点的元素，
     * 如
     *     <book name="sanguo">
     *         <PatternLayout pattern="[%d{HH:mm:ss:SSS}] [%p] - %l - %m%n"/>
     *     </book>
     *   其中，PatternLayout就是的Layout,其实就是{@link Layout}的实现类。
     */
    @PluginFactory
    public static MyLog4j2Appender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginAttribute("printString") String printString) {

        if (name == null) {
            LOGGER.error("no name defined in conf.");
            return null;
        }
        //默认使用 PatternLayout
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        //使用自定义的Appender
        return new MyLog4j2Appender(name, filter, layout, printString);
    }

    @Override
    public void start() {
        System.out.println("log4j2-start方法被调用");
        super.start();
    }

    @Override
    public void stop() {
        System.out.println("log4j2-stop方法被调用");
        super.stop();
    }
}