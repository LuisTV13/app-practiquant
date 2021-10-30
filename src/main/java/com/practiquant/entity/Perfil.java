package com.practiquant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_Perfil")
public class Perfil {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codperfil;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codusuario")
	private Usuario codusuario;
	private String nombre;
	private String apellido;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima" )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fnacim;
	private String resumen;
	
	
	
	public int getCodperfil() {
		return codperfil;
	}
	public void setCodperfil(int codperfil) {
		this.codperfil = codperfil;
	}
	public Usuario getCodusuario() {
		return codusuario;
	}
	public void setCodusuario(Usuario codusuario) {
		this.codusuario = codusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFnacim() {
		return fnacim;
	}
	public void setFnacim(Date fnacim) {
		this.fnacim = fnacim;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	
}
