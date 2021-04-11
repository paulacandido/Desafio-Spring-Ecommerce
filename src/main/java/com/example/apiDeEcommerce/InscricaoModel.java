package com.example.apiDeEcommerce;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_Informacao")
@Getter
@Setter
public class InscricaoModel {
	//Crie uma model com os atributos necessários + get seters+ anotações
	@Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    LojaModel loja;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    UsuarioModel usuario;
}
