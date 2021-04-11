package com.example.apiDeEcommerce;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_Loja")
@Getter
@Setter
public class LojaModel {
	//Crie uma model com os atributos necessários + get seters+ anotações
	@Id
	private int idLoja;
	private String nomeLoja;
	private String descricao;
	
	@OneToMany(mappedBy = "usuario")
	Set<InscricaoModel> fk_usuario;
	
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("loja")
	private List <ProdutoModel> produto;
}
