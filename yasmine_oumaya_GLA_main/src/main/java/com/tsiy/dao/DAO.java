package com.tsiy.dao;

import java.util.List;

public interface DAO<T> {

	List<T> getAll();

	T getElement(String name);

	void addElement(T elt);

	void deleteElement(String name);

	void editElement(String name, T elt);// il vaut mieux faire string pr pouvoir accéder aux noms

}
