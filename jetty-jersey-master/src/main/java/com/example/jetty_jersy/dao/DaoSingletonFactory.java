package com.example.jetty_jersy.dao;

public class DaoSingletonFactory {
	 private static DAO dao = null;

	    public static DAO getInstance(){
	        if (DaoSingletonFactory.dao == null) {
	            DaoSingletonFactory.dao = new DAO();
	        }

	        return DaoSingletonFactory.dao;
	    }
}

