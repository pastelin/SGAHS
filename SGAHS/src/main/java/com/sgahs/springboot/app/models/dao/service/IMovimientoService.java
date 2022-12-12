package com.sgahs.springboot.app.models.dao.service;

import java.util.List;

import com.sgahs.springboot.app.models.entity.Ahorro;
import com.sgahs.springboot.app.models.entity.CatalogoAppInversion;
import com.sgahs.springboot.app.models.entity.Gasto;
import com.sgahs.springboot.app.models.entity.GastoRecurrente;
import com.sgahs.springboot.app.models.entity.Inversion;
import com.sgahs.springboot.app.models.entity.Prestamo;

public interface IMovimientoService {
	
	List<GastoRecurrente> findAllGastoRecurrente();
	void saveGastoRecurrente(GastoRecurrente gastoRecurrente);
	
	List<Gasto> findAllGasto();
	void saveGasto(Gasto gasto);
	
	List<Inversion> findAllInversion();
	void saveInversion(Inversion inversion);
	void updateInversion(Inversion inversion);
	
	List<Ahorro> findAllAhorro();
	void saveAhorro(Ahorro ahorro);
	
	List<Prestamo> findAllPrestamo();
	
	Prestamo findPrestamoByFolio(String folio);
	Inversion findInversionByFolio(String folio);
	
	void savePrestamo(Prestamo prestamo);
	
	List<CatalogoAppInversion> findAllCatalogoInversion();
}
