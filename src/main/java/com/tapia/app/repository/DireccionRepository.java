package com.tapia.app.repository;

import com.tapia.app.models.Direccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DireccionRepository implements IRepositoryDireccion {

    private Connection conn;

    public DireccionRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Direccion> listar() throws SQLException {
        return null;
    }

    @Override
    public Direccion getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Direccion direccion) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public Long guardarReturnId(Direccion direccion) throws SQLException {
        String sql = "";
        int executeUpdate;
        long resultado = -1L;

        sql = "insert into direcciones (ID_DIRECCCION, calle, numInt,numExt, colonia)"+
                "cp, estado, pais"+
                "values(SEQUENCE20.NEXTVAL,?,?,?,?,?,?,?)";

        try(PreparedStatement stmt =
                    conn.prepareStatement(sql, new String[]{"ID_DIRECCION"})){
            stmt.setString(1,direccion.getCalle());
            stmt.setInt(2, direccion.getNumInt());
            stmt.setInt(3,direccion.getNumExt());
            stmt.setString(4,direccion.getColonia());
            stmt.setString(5,direccion.getCp());
            stmt.setString(6,direccion.getEstado());
            stmt.setString(7,direccion.getPais());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                resultado = rs.getLong(1);
            }
        }
        return resultado;
    }
}
