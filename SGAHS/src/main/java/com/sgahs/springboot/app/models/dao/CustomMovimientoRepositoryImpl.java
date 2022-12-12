package com.sgahs.springboot.app.models.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.sgahs.springboot.app.models.entity.Inversion;

	@Repository
	public class CustomMovimientoRepositoryImpl implements ICustomMovimientoRepository {
	
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public Double obtenerAhorroTotal() {
			
			BigDecimal ahorroTotal = (BigDecimal) entityManager.createNativeQuery("select SUM(monto) from ahorros where cd_estatus = 1").getSingleResult();
			BigDecimal inversionTotal = (BigDecimal) entityManager.createNativeQuery("select SUM(monto) from ahorros where cd_estatus = 3").getSingleResult();
			Double ahorro = ahorroTotal != null ? ahorroTotal.doubleValue() : 0.0; 
			Double inversion = inversionTotal != null ? inversionTotal.doubleValue() : 0.0; 
			
			return ahorro - inversion;
		}

		@Override
		public Double obtenerPrestamoTotal() {
			
			BigDecimal prestamoTotal = (BigDecimal) entityManager.createNativeQuery("select SUM(monto_prestado - monto_pagado) from prestamos where cd_estatus = 1").getSingleResult();
			
			return prestamoTotal != null ? prestamoTotal.doubleValue() : 0.0;
			
		}

		@Override
		public Double obtenerInversionTotal() {
			
			BigDecimal inversionTotal = (BigDecimal) entityManager.createNativeQuery("select SUM(monto - monto_retirado) from inversiones where cd_estatus = 1").getSingleResult();
			
			return inversionTotal != null ? inversionTotal.doubleValue() : 0.0;
		}

		@Override
		public Double obtenerGastoDisponible() {
			
			BigDecimal montoDisponible = (BigDecimal) entityManager.createNativeQuery("select SUM(monto) from gastos where cd_estatus = 1 and cd_tipo_movimiento_gasto = 1").getSingleResult();
			BigDecimal montoGastado = (BigDecimal) entityManager.createNativeQuery("select SUM(monto) from gastos where cd_estatus = 1 and cd_tipo_movimiento_gasto = 2").getSingleResult();
			
			montoGastado = montoGastado != null ? montoGastado : BigDecimal.valueOf(0.0);
			
			return montoDisponible != null ? montoDisponible.doubleValue() - montoGastado.doubleValue() : 0.0;
		}
		
		@Override
		public void actualizarInversion(Inversion inversion) {
			
			StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("call spu_inversion");
			sp.setParameter(1, inversion.getFolio());
			sp.setParameter(2, inversion.getMonto());
			sp.setParameter(3, inversion.getDescripcion());
			sp.setParameter(4, inversion.getFechaCreacion());
			sp.setParameter(5, inversion.getCdEstatus());
			sp.setParameter(6, inversion.getCdAppInversion());
			sp.setParameter(7, inversion.getMontoRetirado());
			
			sp.execute();
		}

		@Override
		public Double obtenerGastoMensual() {
			LocalDate date = LocalDate.now();
			int month = date.getMonthValue();
			int year = date.getYear();
			
			Query query = entityManager.createNativeQuery("select sum(monto) from gastos where cd_tipo_movimiento_gasto = 2 and cd_estatus = 1 and month(fecha_creacion) = ? and year(fecha_creacion) = ?");
			query.setParameter(1, month);
			query.setParameter(2, year);
			
			BigDecimal result = (BigDecimal) query.getSingleResult();
			return result != null ? result.doubleValue() : 0.0 ;
		}
	}
