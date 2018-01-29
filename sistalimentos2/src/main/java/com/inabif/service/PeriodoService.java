package com.inabif.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inabif.entity.Periodo;
import com.inabif.model.PeriodoModel;

public interface PeriodoService {
	
	public abstract PeriodoModel addPeriodo(PeriodoModel periodoModel);
	
	public abstract  List<PeriodoModel> listAllPeriodos();
	
	public abstract List<PeriodoModel> findPeriodosByYear(int ano);
	
	public abstract List<PeriodoModel> findPeriodosByYearAndMonth(int ano,int mes);
	
	public abstract PeriodoModel findPeriodosByIdModel(int id);
	
	public abstract void removePeriodo(int id);
	
	public abstract Page<Periodo> findPeriodosByYear(int year,Pageable pageable);

}
