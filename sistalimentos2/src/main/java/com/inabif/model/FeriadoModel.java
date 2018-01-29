package com.inabif.model;

import java.util.Date;

import javax.persistence.Column;

public class FeriadoModel {
	
	@Override
	public String toString() {
		return "FeriadoModel [idferiado=" + idferiado + ", ferejercicio=" + ferejercicio + ", fertipoferidado="
				+ fertipoferidado + ", ferfechaferiado=" + ferfechaferiado + ", ferdescripcion=" + ferdescripcion
				+ ", ferubigeo=" + ferubigeo + "]";
	}
	private int idferiado;
	private int ferejercicio;
	private int fertipoferidado;
	private Date ferfechaferiado;
	private String ferdescripcion;
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
