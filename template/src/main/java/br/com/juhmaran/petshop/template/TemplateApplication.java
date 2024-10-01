package br.com.juhmaran.petshop.template;

import br.com.juhmaran.petshop.template.azure.Todo;
import br.com.juhmaran.petshop.template.azure.TodoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@OpenAPIDefinition(info = @Info(
        title = "PetShop API",
        version = "1.0.0",
        description = "API for managing pets"))
@EnableDiscoveryClient
@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> basicsApplicationListener(TodoRepository repository) {
        return event -> repository
                .saveAll(Stream.of("A", "B", "C")
                        .map(name -> new Todo(
                                "configuration",
                                "congratulations, you have set up correctly!",
                                true))
                        .toList())
                .forEach(System.out::println);
    }

}
