package com.jcry.warehouse.service;

import java.util.List;

public interface ICRUD <T> {
	
	T registrar(T obj);
	T modificar(T obj);
	List<T> listarTodo();
	T buscarPorId(Integer id);
	boolean eliminar(Integer id);
	
}