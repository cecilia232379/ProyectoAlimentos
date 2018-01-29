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
@Table(name="TFPERIODOS")
public class Periodo {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERIODO_SEQ")
    @SequenceGenerator(sequenceName = "TFPERIODOS_SEQ", allocationSize = 1, name = "PERIODO_SEQ")
	private int idperiodo;
	@Column(name="peryeart")
	private int peryeart;
	
	
	@Column(name="persemana")
	private int persemana;
	
	
	@Column(name="perfecinicio")
	private Date perfecinicio;
	@Column(name="perfecfin")
	private Date perfecfin;
	@Column(name="pereliminado")
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
