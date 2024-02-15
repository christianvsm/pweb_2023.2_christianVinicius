package br.christian.cadpessoas_christian.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.christian.cadpessoas_christian.repositories.PessoaRepository;
import br.christian.cadpessoas_christian.model.Pessoa;

@Controller
@RequestMapping("/")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepo;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepo = pessoaRepo;
    }

    // raiz do site localhost:8080/
    @GetMapping
    public String index() {
        return "index.html";
    }

    @GetMapping("/listarPessoas")
    public ModelAndView listarPessoas(){
        List<Pessoa> todasAsPessoas = pessoaRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("listarPessoas");
        modelAndView.addObject("todasAsPessoas", todasAsPessoas);
        return modelAndView;
    }

    @GetMapping("/adicionarPessoa")
    public ModelAndView adicionarPessoa(){
        ModelAndView modelAndView = new ModelAndView("adicionarPessoa");
        modelAndView.addObject(new Pessoa());
        return modelAndView;
    }

    @PostMapping("/adicionarPessoa")
    public String adicionarPessoa(Pessoa p){
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoas";
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerPessoa(@PathVariable("id") long id){
        Pessoa aRemover = pessoaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido" + id));
        pessoaRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarPessoas");
    }


}
