package com.teste.springboot.api;

import com.teste.springboot.model.Projeto;
import com.teste.springboot.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projetos")
public class ProjetosRestController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> listarProjetos() {

        return projetoService.listarProjetos();
    }


}
