package com.inabif.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TGFERIADO")
public class Feriado {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FERIADO_SEQ")
    @SequenceGenerator(sequenceName = "TGFERIADO_SEQ", allocationSize = 1, name = "FERIADO_SEQ")
	private int idferiado;
	@Column(name="ferejercicio")
	private int ferejercicio;
	
	
	@Column(name="fertipoferiado")
	private int fertipoferidado;
	
	
	@Column(name="ferfechaferiado")
	private Date ferfechaferiado;
	@Column(name="ferdescripcion")
	private String ferdescripcion;
	@Column(name="ferubigeo")
	private String ferubigeo;
	
	public int getIdferiado() {
		return idferiado;
	}
	public void setIdferiado(int idferiado) {
		this.idferiado = idferiado;
	}
	public int getFerejercicio() {
		return ferejercicio;
	}
	public void setFerejercicio(int ferejercicio) {
		this.ferejercicio = ferejercicio;
	}
	public int getFertipoferidado() {
		return fertipoferidado;
	}
	public void setFertipoferidado(int fertipoferidado) {
		this.fertipoferidado = fertipoferidado;
	}
	public Date getFerfechaferiado() {
		return ferfechaferiado;
	}
	public void setFerfechaferiado(Date ferfechaferiado) {
		this.ferfechaferiado = ferfechaferiado;
	}
	public String getFerdescripcion() {
		return ferdescripcion;
	}
	public void setFerdescripcion(String ferdescripcion) {
		this.ferdescripcion = ferdescripcion;
	}
	public String getFerubigeo() {
		return ferubigeo;
	}
	public void setFerubigeo(String ferubigeo) {
		this.ferubigeo = ferubigeo;
	}
	
	

}
