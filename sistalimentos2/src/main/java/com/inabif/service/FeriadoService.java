package com.inabif.service;

import java.util.List;


import com.inabif.model.FeriadoModel;

public interface FeriadoService {
	
	public abstract FeriadoModel addFeriado(FeriadoModel feriadoModel);
	
	public abstract  List<FeriadoModel> listAllFeriados();
	
	public abstract List<FeriadoModel> findFeriadosByYear(int ano);
	
	public abstract FeriadoModel findFeriadosByIdModel(int id);
	
	public abstract void removeFeriado(int id);

}
