package com.wusd.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序的启动引导类, 也是主要的SPring配置类
 * @SpringBootApplication: 开启组件扫描和自动配置
 * @Configuration: 标明该类使用Spring基于Java的配置
 * @ComponetScan: 启用组件扫描, 例如: @Controller
 * @EnableAutoConfiguration: 开启自动配置
 */
@SpringBootApplication
public class ReadingListApplication {

	public static void main(String[] args) {
		// 负责启动引导应用程序
		SpringApplication.run(ReadingListApplication.class, args);
	}

}
