package com.inabif.component;

import org.springframework.stereotype.Component;

import com.inabif.entity.Feriado;
import com.inabif.model.FeriadoModel;

@Component("feriadoConverter")
public class FeriadoConverter {
	
	public Feriado convertFeriadoModel2Feriado(FeriadoModel feriadoModel) {

		Feriado feriado = new Feriado();
		feriado.setFerdescripcion(feriadoModel.getFerdescripcion());
		feriado.setFerejercicio(feriadoModel.getFerejercicio());
		feriado.setFerfechaferiado(feriadoModel.getFerfechaferiado());
		feriado.setFertipoferidado(feriadoModel.getFertipoferidado());
		feriado.setFerubigeo(feriadoModel.getFerubigeo());
		feriado.setIdferiado(feriadoModel.getIdferiado());
	    return feriado;
		
	} 
	public FeriadoModel convertFeriado2FeriadoModel(Feriado feriado) {
		FeriadoModel feriadoModel = new FeriadoModel();
		feriadoModel.setFerdescripcion(feriado.getFerdescripcion());
		feriadoModel.setIdferiado(feriado.getIdferiado());
		feriadoModel.setFerejercicio(feriado.getFerejercicio());
		feriadoModel.setFerfechaferiado(feriado.getFerfechaferiado());
		feriadoModel.setFertipoferidado(feriado.getFertipoferidado());
		feriadoModel.setFerubigeo(feriado.getFerubigeo());
		return feriadoModel;	
	}
}
