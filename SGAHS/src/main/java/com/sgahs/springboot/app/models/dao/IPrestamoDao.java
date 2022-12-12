package com.sgahs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sgahs.springboot.app.models.entity.Prestamo;

public interface IPrestamoDao extends CrudRepository<Prestamo, String> {

}
