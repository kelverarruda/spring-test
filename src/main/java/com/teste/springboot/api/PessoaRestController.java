package com.teste.springboot.api;

import com.teste.springboot.model.Pessoa;
import com.teste.springboot.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaRestController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.salvarPessoa(pessoa);
    }

}
