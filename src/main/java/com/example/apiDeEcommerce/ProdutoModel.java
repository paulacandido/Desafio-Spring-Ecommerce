package com.example.apiDeEcommerce;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_Produto")
@Getter
@Setter
public class ProdutoModel {
//Crie uma model com os atributos necessários + get seters+ anotações
	
	@Id
	private int idProduto;
	@Size(min=3, max=7)
	private float valor;
	private String tituloProduto;
	private String urlImagem;
	private String busca;
	
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private LojaModel loja;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private UsuarioModel usuario;
}
