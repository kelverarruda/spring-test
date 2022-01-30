package com.teste.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_inicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_previsao_fim;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_fim;

    @Column(length = 5000)
    private String decricao;

    @Column(length = 45)
    private String status;

    @Column
    private Float orcamento;

    @Column(length = 45)
    private String risco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente", foreignKey = @ForeignKey(name = "fk_gerente"))
    private Pessoa idgerente;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "membros",
            joinColumns = @JoinColumn(name = "idprojeto", foreignKey = @ForeignKey(name = "fk_membros_projeto")),
            inverseJoinColumns = @JoinColumn(name = "idpessoa", foreignKey = @ForeignKey(name = "fk_membros_pessoa"))
    )
    private Set<Pessoa> pessoasProjeto;

}
