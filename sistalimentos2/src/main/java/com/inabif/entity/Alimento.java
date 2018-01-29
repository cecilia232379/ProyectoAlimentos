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
@Table(name="TFALIMENTOS")
public class Alimento {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALIMENTOS_SEQ")
    @SequenceGenerator(sequenceName = "TFALIMENTOS_SEQ", allocationSize = 1, name = "ALIMENTOS_SEQ")
	private int idalimentos;
	
	@Column(name="aliperiodo")
	private int aliperiodo;
	
	
	@Column(name="aliidcentroatencion")
	private int aliidcentroatencion;
	
	
	@Column(name="alidia")
	private int alidia;
	
	@Column(name="alidiacal")
	private int alidiacal;
	
	@Column(name="alimescal")
	private int alimescal;
	
	@Column(name="aliyearcal")
	private int aliyearcal;
	
	@Column(name="alisemana")
	private int alisemana;
	
	@Column(name="alilinea")
	private int alilinea;
	
	@Column(name="alidesayunoh")
	private int alidesayunoh;
	
	@Column(name="alidesayunom")
	private int alidesayunom;
	
	@Column(name="alialmuerzoh")
	private int alialmuerzoh;
	
	@Column(name="alialmuerzom")
	private int alialmuerzom;
	
	@Column(name="aliloncheh")
	private int aliloncheh;
	
	@Column(name="alilonchem")
	private int alilonchem;
	
	
	@Column(name="alicomidah")
	private int alicomidah;
	
	@Column(name="alicomidam")
	private int alicomidam;
	
	@Column(name="alifecharegistro")
	private Date alifecharegistro;
	
	@Column(name="alifechamodifica")
	private Date alifechamodifica;

	public int getIdalimentos() {
		return idalimentos;
	}

	public void setIdalimentos(int idalimentos) {
		this.idalimentos = idalimentos;
	}

	public int getAliperiodo() {
		return aliperiodo;
	}

	public void setAliperiodo(int aliperiodo) {
		this.aliperiodo = aliperiodo;
	}

	public int getAliidcentroatencion() {
		return aliidcentroatencion;
	}

	public void setAliidcentroatencion(int aliidcentroatencion) {
		this.aliidcentroatencion = aliidcentroatencion;
	}

	public int getAlidia() {
		return alidia;
	}

	public void setAlidia(int alidia) {
		this.alidia = alidia;
	}

	public int getAlidiacal() {
		return alidiacal;
	}

	public void setAlidiacal(int alidiacal) {
		this.alidiacal = alidiacal;
	}

	public int getAlimescal() {
		return alimescal;
	}

	public void setAlimescal(int alimescal) {
		this.alimescal = alimescal;
	}

	public int getAliyearcal() {
		return aliyearcal;
	}

	public void setAliyearcal(int aliyearcal) {
		this.aliyearcal = aliyearcal;
	}

	public int getAlisemana() {
		return alisemana;
	}

	public void setAlisemana(int alisemana) {
		this.alisemana = alisemana;
	}

	public int getAlilinea() {
		return alilinea;
	}

	public void setAlilinea(int alilinea) {
		this.alilinea = alilinea;
	}

	public int getAlidesayunoh() {
		return alidesayunoh;
	}

	public void setAlidesayunoh(int alidesayunoh) {
		this.alidesayunoh = alidesayunoh;
	}

	public int getAlidesayunom() {
		return alidesayunom;
	}

	public void setAlidesayunom(int alidesayunom) {
		this.alidesayunom = alidesayunom;
	}

	public int getAlialmuerzoh() {
		return alialmuerzoh;
	}

	public void setAlialmuerzoh(int alialmuerzoh) {
		this.alialmuerzoh = alialmuerzoh;
	}

	public int getAlialmuerzom() {
		return alialmuerzom;
	}

	public void setAlialmuerzom(int alialmuerzom) {
		this.alialmuerzom = alialmuerzom;
	}

	public int getAliloncheh() {
		return aliloncheh;
	}

	public void setAliloncheh(int aliloncheh) {
		this.aliloncheh = aliloncheh;
	}

	public int getAlilonchem() {
		return alilonchem;
	}

	public void setAlilonchem(int alilonchem) {
		this.alilonchem = alilonchem;
	}

	public int getAlicomidah() {
		return alicomidah;
	}

	public void setAlicomidah(int alicomidah) {
		this.alicomidah = alicomidah;
	}

	public int getAlicomidam() {
		return alicomidam;
	}

	public void setAlicomidam(int alicomidam) {
		this.alicomidam = alicomidam;
	}

	public Date getAlifecharegistro() {
		return alifecharegistro;
	}

	public void setAlifecharegistro(Date alifecharegistro) {
		this.alifecharegistro = alifecharegistro;
	}

	public Date getAlifechamodifica() {
		return alifechamodifica;
	}

	public void setAlifechamodifica(Date alifechamodifica) {
		this.alifechamodifica = alifechamodifica;
	}
	

}
