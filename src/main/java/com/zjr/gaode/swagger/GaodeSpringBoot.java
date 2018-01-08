package com.zjr.gaode.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 15:35 2018/1/8
 * @Description: Spring Boot应用程序在启动后，会遍历CommandLineRunner接口的实例并运行它们的run方法。
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.zjr.gaode"})
public class GaodeSpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
