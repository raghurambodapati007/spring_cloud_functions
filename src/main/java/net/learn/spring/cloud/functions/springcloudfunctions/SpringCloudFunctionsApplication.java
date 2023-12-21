package net.learn.spring.cloud.functions.springcloudfunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionsApplication implements CommandLineRunner {

	@Autowired
	FunctionCatalog functionCatalog;

	@Value("${spring.cloud.stream.function.definition}")
	private String functionChain;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionsApplication.class, args);
	}

	@Bean
	public Function<String,String> workFlow(){
		return functionCatalog.lookup(functionChain);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start here");
		workFlow().apply("RaGhU_RaM_BoDaPaTi");
	}
}
