package com.teste.springboot.service;

import com.teste.springboot.model.Projeto;
import com.teste.springboot.repository.ProjetoRepository;
import com.teste.springboot.utils.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public void salvarProjeto(Projeto projeto) {

        projetoRepository.save(projeto);
    }

    public Projeto listarProjeto(Long id) {
        return projetoRepository.findById(id).get();
    }

    public void removerProjeto(Long id) {
        Projeto projeto = listarProjeto(id);
        if (!projeto.getStatus().equals(EnumStatus.INICIADO.getDescricao()) ||
            !projeto.getStatus().equals(EnumStatus.EM_ANDAMENTO.getDescricao()) ||
            !projeto.getStatus().equals(EnumStatus.ENCERRADO.getDescricao())) {
            projetoRepository.delete(listarProjeto(id));
        }
        else {
            System.out.println("Não pode ser excluído!");
        }
    }
}
