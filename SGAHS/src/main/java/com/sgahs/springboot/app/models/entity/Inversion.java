package com.sgahs.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "inversiones")
public class Inversion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String folio;

	private Double monto;

	private String descripcion;

	private Integer plazo;

	@NotNull
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaInicio;

	@NotNull
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaFin;

	@Column(name = "cd_estatus_inversion")
	private Integer cdEstatusInversion;

	@Column(name = "cd_app_inversion")
	private Integer cdAppInversion;

	@Column(name = "cd_estatus")
	private Integer cdEstatus;

	@Column(name = "cd_tipo_movimiento")
	private Integer cdTipoMovimiento;

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getCdEstatusInversion() {
		return cdEstatusInversion;
	}

	public void setCdEstatusInversion(Integer cdEstatusInversion) {
		this.cdEstatusInversion = cdEstatusInversion;
	}

	public Integer getCdAppInversion() {
		return cdAppInversion;
	}

	public void setCdAppInversion(Integer cdAppInversion) {
		this.cdAppInversion = cdAppInversion;
	}

	public Integer getCdEstatus() {
		return cdEstatus;
	}

	public void setCdEstatus(Integer cdEstatus) {
		this.cdEstatus = cdEstatus;
	}

	public Integer getCdTipoMovimiento() {
		return cdTipoMovimiento;
	}

	public void setCdTipoMovimiento(Integer cdTipoMovimiento) {
		this.cdTipoMovimiento = cdTipoMovimiento;
	}

}
