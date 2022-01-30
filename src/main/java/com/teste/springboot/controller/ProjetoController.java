package com.teste.springboot.controller;

import com.teste.springboot.model.Projeto;
import com.teste.springboot.service.PessoaService;
import com.teste.springboot.service.ProjetoService;
import com.teste.springboot.utils.EnumRisco;
import com.teste.springboot.utils.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ModelAndView listarProjetos() {
        ModelAndView mv = new ModelAndView("projetos/listar-projetos");
        return mv;
    }

    @PostMapping(value = "/salvar")
    public String salvarProjeto(Projeto projeto) {
        projetoService.salvarProjeto(projeto);
        return "redirect:/projetos";
    }

    @GetMapping(value = "/cadastrar")
    public ModelAndView cadastrarProjeto() {
        ModelAndView mv = new ModelAndView("projetos/form-projeto");
        mv.addObject("title", "Novo Projeto");
        mv.addObject("projeto", new Projeto());
        mv.addObject("pessoas", pessoaService.listarPessoas());
        mv.addObject("status", EnumStatus.values());
        mv.addObject("riscos", EnumRisco.values());
        return mv;
    }

    @GetMapping(value = "/editar")
    public ModelAndView editarProjeto(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("projetos/form-projeto");
        mv.addObject("title", "Editar Projeto");
        mv.addObject("projeto", projetoService.listarProjeto(id));
        mv.addObject("pessoas", pessoaService.listarPessoas());
        mv.addObject("status", EnumStatus.values());
        mv.addObject("riscos", EnumRisco.values());
        return mv;
    }

    @GetMapping(value = "/{id}")
    public String removerProjeto(@PathVariable Long id) {
        projetoService.removerProjeto(id);
        return "redirect:/projetos";
    }

}
