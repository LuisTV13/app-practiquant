package com.practiquant.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codusuario;
	private String usuario;
	private String clave;
	private Tipo_Usuario id_tipo;
	
	
	
	public int getCodusuario() {
		return codusuario;
	}
	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Tipo_Usuario getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(Tipo_Usuario id_tipo) {
		this.id_tipo = id_tipo;
	}
	

}
