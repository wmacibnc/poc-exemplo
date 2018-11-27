package com.stefanini.pocautenticacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

	@GetMapping("/")
    public void teste() {
        System.out.println("Passou aqui");
    }
}
