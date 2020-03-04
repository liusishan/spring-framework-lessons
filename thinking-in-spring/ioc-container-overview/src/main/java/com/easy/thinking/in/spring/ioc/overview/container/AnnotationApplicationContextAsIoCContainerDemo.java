package com.easy.thinking.in.spring.ioc.overview.container;

import com.easy.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext} ApplicationContext IoC 容器示例
 *
 * @author lss
 * @date 2020-03-04 11:19
 * @since
 */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        // 将当前类 AnnotationConfigApplicationContext 作为配置类（Configuration Class）
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找
        lookupCollectionByType(applicationContext);
    }

    /**
     * 通过 Java 注解的方式，定义 Bean
     * @return
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("Easy");
        return user;
    }

    /**
     * 通过类型查找集合对象
     *
     * @param beanFactory
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 集合对象：" + users);
        }
    }

}
