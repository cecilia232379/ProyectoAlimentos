package com.inabif.service;

import java.util.List;
import java.util.Map;

import com.inabif.model.AlimentoModel;
import com.inabif.model.FeriadoModel;
import com.inabif.model.MenuItemModel;



public interface MenuItemService {
//	
//	public abstract List<Object> reporteMesCedifAlimentos(int ano,int mes, int periodo);
	
	public abstract List<MenuItemModel> getMenuItems(int modulo,int perfil);
	
}
