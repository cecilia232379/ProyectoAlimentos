package com.inabif.component;

import org.springframework.stereotype.Component;

import com.inabif.entity.Alimento;
import com.inabif.entity.Feriado;
import com.inabif.model.AlimentoModel;
import com.inabif.model.FeriadoModel;

@Component("alimentoConverter")
public class AlimentoConverter {
	
	public Alimento convertAlimentoModel2Alimento(AlimentoModel alimentoModel) {

		Alimento alimento = new Alimento();
		alimento.setAlialmuerzoh(alimentoModel.getAlialmuerzoh());
		alimento.setAlialmuerzom(alimentoModel.getAlialmuerzom());
		alimento.setAlicomidah(alimentoModel.getAlicomidah());
		alimento.setAlicomidam(alimentoModel.getAlicomidam());
		alimento.setAlidesayunoh(alimentoModel.getAlidesayunoh());
		alimento.setAlidesayunom(alimentoModel.getAlidesayunom());
		alimento.setAlidia(alimentoModel.getAlidia());
		alimento.setAlidiacal(alimentoModel.getAlidiacal());
		alimento.setAliidcentroatencion(alimentoModel.getAliidcentroatencion());
		alimento.setAlilinea(alimentoModel.getAlilinea());
		alimento.setAlimescal(alimentoModel.getAlimescal());
		alimento.setAliyearcal(alimentoModel.getAliyearcal());
		alimento.setAliperiodo(alimentoModel.getAliperiodo());
		alimento.setAlisemana(alimentoModel.getAlisemana());
	    return alimento;
		
	} 
	public AlimentoModel convertAlimento2AlimentoModel(Alimento alimento) {
		AlimentoModel alimentoModel = new AlimentoModel();
		alimentoModel.setAlialmuerzoh(alimento.getAlialmuerzoh());
		alimentoModel.setAlialmuerzom(alimento.getAlialmuerzom());
		alimentoModel.setAlicomidah(alimento.getAlicomidah());
		alimentoModel.setAlicomidam(alimento.getAlicomidam());
		alimentoModel.setAlidesayunoh(alimento.getAlidesayunoh());
		alimentoModel.setAlidesayunom(alimento.getAlidesayunom());
		
		alimentoModel.setAlidia(alimento.getAlidia());
		alimentoModel.setAlidiacal(alimento.getAlidiacal());
		alimentoModel.setAliidcentroatencion(alimento.getAliidcentroatencion());
		alimentoModel.setAlilinea(alimento.getAlilinea());
		alimentoModel.setAlimescal(alimento.getAlimescal());
		alimentoModel.setAliyearcal(alimento.getAliyearcal());
		alimentoModel.setAliperiodo(alimento.getAliperiodo());
		alimentoModel.setAlisemana(alimento.getAlisemana());
		return alimentoModel;	
	}
}
