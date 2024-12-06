package com.sunbeam.daos;


import java.sql.Connection;

import com.sunbeam.utils.DbUtils;




public abstract class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = DbUtils.getConnection();
	}
	public void close() throws Exception {
		con.close();
	}
}
