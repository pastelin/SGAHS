package com.sgahs.springboot.app.models.dao;

import com.sgahs.springboot.app.models.entity.Inversion;

public interface ICustomMovimientoRepository {

	Double obtenerAhorroTotal();
	Double obtenerPrestamoTotal();
	Double obtenerInversionTotal();
	Double obtenerGastoDisponible();
	void actualizarInversion(Inversion inversion);
	Double obtenerGastoMensual();
	
}
