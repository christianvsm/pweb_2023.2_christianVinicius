package br.christian.cadpessoas_christian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PessoaController {
    //raiz do site localhost:8080/
    @GetMapping
    public String index(){
        return "index.html";
    }


}
