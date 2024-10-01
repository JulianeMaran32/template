package br.com.juhmaran.petshop.template.azure;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository repository;

    @GetMapping("/hello")
    public String getHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return repository.findAll();
    }

}
