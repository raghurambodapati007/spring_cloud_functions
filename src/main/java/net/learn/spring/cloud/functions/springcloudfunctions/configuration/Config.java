package net.learn.spring.cloud.functions.springcloudfunctions.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Config {

    @Bean
    public Function<String,String> upperCase(){
        return input -> {
            System.out.println("In upperCase");
            return input.toUpperCase();
        };
    }

    @Bean
    public Function<String,String> lowerCase(){
        return input -> {
            System.out.println("In lowerCase");
            return input.toUpperCase();
        };
    }

    @Bean
    public Function<String,String> appendString(){
        return input -> {
            System.out.println("In appendString");
            var response = input.concat("_Learn_Spring_cloud_function");
            System.out.println("Response after final stage is : "+response);
            return response;
        };
    }

}
