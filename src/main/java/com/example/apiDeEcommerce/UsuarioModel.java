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
@Table(name="tb_Usuario")
@Getter
@Setter
public class UsuarioModel {
@Id
private int idUsuario;
private String usuario;
private String senha;

@OneToMany(mappedBy = "loja")
Set<InscricaoModel> fk_loja;

@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
@JsonIgnoreProperties("usuario")
private List <ProdutoModel> produto;
}
