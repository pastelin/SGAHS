package com.sgahs.springboot.app.models.dao.service;

import com.sgahs.springboot.app.models.entity.Inversion;

public interface ICustomMovimientoService {

	Double obtenerAhorroTotal();
	Double obtenerPrestamoTotal();
	Double obtenerInversionTotal();
	Double obtenerGastoDisponible();
	void actualizarInversion(Inversion inversion);
	Double obtenerGastoMensual();
}
