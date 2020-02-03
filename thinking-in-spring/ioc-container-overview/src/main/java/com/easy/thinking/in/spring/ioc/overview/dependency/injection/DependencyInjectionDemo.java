package com.easy.thinking.in.spring.ioc.overview.dependency.injection;

import com.easy.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
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
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一： 自定义 Bean
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        // System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());
        // System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject() == beanFactory);

        // 依赖查找（错误）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三：容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean" + environment);
    }


}
