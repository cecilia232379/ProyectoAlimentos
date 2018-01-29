package com.inabif.model;

import java.util.Date;

import javax.persistence.Column;

public class PeriodoModel {
	
	private int idperiodo;
	private int peryeart;
	private int persemana;
	private Date perfecinicio;
	private Date perfecfin;
	private int pereliminado;
	public int getIdperiodo() {
		return idperiodo;
	}
	public void setIdperiodo(int idperiodo) {
		this.idperiodo = idperiodo;
	}
	public int getPeryeart() {
		return peryeart;
	}
	public void setPeryeart(int peryeart) {
		this.peryeart = peryeart;
	}
	public int getPersemana() {
		return persemana;
	}
	public void setPersemana(int persemana) {
		this.persemana = persemana;
	}
	public Date getPerfecinicio() {
		return perfecinicio;
	}
	public void setPerfecinicio(Date perfecinicio) {
		this.perfecinicio = perfecinicio;
	}
	public Date getPerfecfin() {
		return perfecfin;
	}
	public void setPerfecfin(Date perfecfin) {
		this.perfecfin = perfecfin;
	}
	public int getPereliminado() {
		return pereliminado;
	}
	public void setPereliminado(int pereliminado) {
		this.pereliminado = pereliminado;
	}
	
	
	
}
