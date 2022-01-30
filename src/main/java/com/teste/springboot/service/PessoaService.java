package com.teste.springboot.service;

import com.teste.springboot.model.Pessoa;
import com.teste.springboot.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public void salvarPessoa(@Valid Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}
