package com.teste.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Não não pode ser vazio")
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull(message = "Necessário informar a data de nascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate datanascimento ;

    @Column(length = 14)
    private String cpf;

    @Column
    private Boolean funcionario;

    @OneToMany(mappedBy = "idgerente")
    private Set<Projeto> projetos;

    @ManyToMany(mappedBy = "pessoasProjeto")
    private Set<Projeto> projetoPessoa;

}
