package com.mitocode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mitocode.dao.TablaDAO;
import com.mitocode.model.Celda;
import com.mitocode.model.Columna;
import com.mitocode.model.Fila;

public class TablaDAOImpl implements TablaDAO {

	private Connection cx;

	public TablaDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public List<Fila> getFilas() throws Exception {
		List<Fila> filas = new ArrayList<>();
		try {
			Statement statement = cx.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM fila order by id");
			while (resultSet.next()) {
				Fila fila = new Fila();
				fila.setId(resultSet.getInt("id"));
				fila.setDescripcion(resultSet.getString("descripcion"));
				filas.add(fila);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Columna> getColumnas() throws Exception {
		List<Columna> columnas = new ArrayList<>();
		try {
			Statement statement = cx.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM columna order by id");
			while (resultSet.next()) {
				Columna columna = new Columna();
				columna.setId(resultSet.getInt("id"));
				columna.setDescripcion(resultSet.getString("descripcion"));
				columna.setNivel(resultSet.getInt("nivel"));
				columna.setAncho(resultSet.getInt("ancho"));
				columna.setAlto(resultSet.getInt("alto"));
				columnas.add(columna);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnas;
	}

	@Override
	public List<Celda> getCeldas() throws Exception {
		List<Celda> celdas = new ArrayList<>();
		try {
			Statement statement = cx.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM celda");
			while (resultSet.next()) {
				Celda celda = new Celda();
				celda.setIdFila(resultSet.getInt("idfila"));
				celda.setIdColumna(resultSet.getInt("idcolumna"));
				celda.setValor(resultSet.getString("valor"));
				celdas.add(celda);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return celdas;
	}

	@Override
	public void actualizarFila(Fila fila) throws Exception {
		try {
			String sql = "UPDATE FILA SET DESCRIPCION = ? WHERE ID = ?";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setString(1, fila.getDescripcion());
			preparedStatement.setInt(2, fila.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
