package com.inabif.service;

import java.util.List;
import java.util.Map;

import com.inabif.model.AlimentoModel;
import com.inabif.model.FeriadoModel;



public interface AlimentoService {
//	
//	public abstract List<Object> reporteMesCedifAlimentos(int ano,int mes, int periodo);
	
	public abstract AlimentoModel addAlimento(AlimentoModel alimentoModel);
	
}
