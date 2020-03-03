package com.easy.thinking.in.spring.ioc.overview.dependency.injection;

import com.easy.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;


/**
 * 依赖注入示例
 * 1.通过名称的方式来注入
 * 2.通过类型来注入
 *
 * @author lss
 * @date 2020-02-03 22:43
 * @description ioc 依赖注入示例
 * @since
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一： 自定义 Bean
        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        // System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject() == applicationContext);

        // 依赖查找（错误）
//        System.out.println(applicationContext.getBean(BeanFactory.class));

        // 依赖来源三：容器内建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean" + environment);
    }

    /**
     * 谁是 IoC 容器 BeanFactory / ApplicationContext
     *
     * @param userRepository
     * @param applicationContext
     */
    private static void whoIsIoCContainer(UserRepository userRepository, ApplicationContext applicationContext) {
        /**
         * ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
         * ConfigurableApplicationContext#getBeanFactory
         * ApplicationContext is BeanFactory
         *
         * ApplicationContext 和 BeanFactory 其实是一类事物，
         * 不过是底层实现上面 ApplicationContext 组合了一个 BeanFactory 的实现，为什么不相等，因为它们两个毕竟是两个对象，
         * 它们两个都复用了 BeanFactory。BeanFactory 是一个底层的 IoC 容器 ApplicationContext 在它基础上增加了一下特性(更容易与 Spring 的AOP集成、国际化的支持、事件的发布等)
         * ApplicationContext 是 BeanFactory 的一个子接口, 是 BeanFactory 的一个超集。
         *
         */
        // 这个表达式为什么不会成立
        System.out.println(userRepository.getBeanFactory() == applicationContext);
    }


}
