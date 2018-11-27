package com.stefanini.pocexemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo")
public class ExampleController {

	@GetMapping("/teste")
    public void teste() {
        System.out.println("Passou aqui");
    }
}
