package com.inabif.component;

import org.springframework.stereotype.Component;

import com.inabif.entity.Periodo;
import com.inabif.model.PeriodoModel;


@Component("periodoConverter")
public class PeriodoConverter {
	
	public Periodo convertPeriodoModel2Periodo(PeriodoModel periodoModel) {

		Periodo periodo = new Periodo();
		periodo.setIdperiodo(periodoModel.getIdperiodo());
		periodo.setPerfecfin(periodoModel.getPerfecfin());
		periodo.setPerfecinicio(periodoModel.getPerfecinicio());
		periodo.setPersemana(periodoModel.getPersemana());
		periodo.setPeryeart(periodoModel.getPeryeart());
		periodo.setPereliminado(periodoModel.getPereliminado());
		return periodo;
		
	} 
	public PeriodoModel convertPeriodo2PeriodoModel(Periodo periodo) {
		PeriodoModel periodoModel = new PeriodoModel();
		periodoModel.setIdperiodo(periodo.getIdperiodo());
		periodoModel.setPerfecfin(periodo.getPerfecfin());
		periodoModel.setPerfecinicio(periodo.getPerfecinicio());
		periodoModel.setPersemana(periodo.getPersemana());
		periodoModel.setPeryeart(periodo.getPeryeart());
		periodoModel.setPereliminado(periodo.getPereliminado());
		return periodoModel;	
	}
}
