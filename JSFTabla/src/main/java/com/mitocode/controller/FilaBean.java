package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.mitocode.model.Fila;
import com.mitocode.service.ITablaService;
import com.mitocode.service.impl.TablaServiceImpl;

@ManagedBean
@ViewScoped
public class FilaBean {

	private List<Fila> lstFilas;
	private ITablaService service;
	private Fila fila;

	@PostConstruct
	public void init() {
		fila = new Fila();
		lstFilas = new ArrayList<>();
		service = new TablaServiceImpl();
		this.listarFilas();
	}

	public void listarFilas() {
		try {
			lstFilas = service.getFilas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			service.actualizarFila(fila);
			context.addMessage(null, new FacesMessage("Exito", "Se actualizó"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Error", e.getMessage()));
		}finally{
			this.listarFilas();
		}
	}

	public List<Fila> getLstFilas() {
		return lstFilas;
	}

	public void setLstFilas(List<Fila> lstFilas) {
		this.lstFilas = lstFilas;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

}
