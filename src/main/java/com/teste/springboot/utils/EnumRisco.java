package com.teste.springboot.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumRisco {

    BAIXO_RISCO("Baixo Risco"),
    MEDIO_RISCO("Médio Risco"),
    ALTO_RISCO("Alto Risco");

    private String descricao;

}
