package com.tapia.app.repository;

import com.tapia.app.models.Direccion;

import java.sql.SQLException;

public interface IRepositoryDireccion extends IRepository<Direccion> {

    Long guardarReturnId(Direccion direccion) throws SQLException;

}
