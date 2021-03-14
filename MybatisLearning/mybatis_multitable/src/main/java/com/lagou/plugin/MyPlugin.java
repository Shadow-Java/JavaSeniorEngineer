package com.lagou.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * 自定义插件：实现拦截器方法
 */
@Intercepts({
        @Signature(type = StatementHandler.class,method = "prepare",
        args = {Connection.class,Integer.class})
})
public class MyPlugin implements Interceptor {
    /**
     * 拦截方法：只要被拦截的目标对象的目标方法被执行时，每次都会执行intercept方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("对方法进行了增强。。。实现了分页 分表");
        return invocation.proceed();//原方法执行
    }

    /**
     * 主要为了把当前拦截器生成代理存到拦截链中
     * @param
     * @return
     */
    public Object plugin(Object target) {
        Object o = Plugin.wrap(target,this);
        return o;
    }

    /**
     * 获取配置文件参数
     * @param properties
     */
    public void setProperties(Properties properties) {
        System.out.println("获取到的配置文件的参数:"+properties);
    }
}
