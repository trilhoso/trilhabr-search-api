package br.com.trilhabr.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.trilhabr.api.model.Local;

public class LocalRepository {

	@Autowired
	DataSource ds;
	
	private final static String SQL_LIST_LOCAIS = "";

	public Local getLocalById() {
		Local local = null;
		
		try {
			Statement st = ds.getConnection().createStatement();
			ResultSet rs = st.executeQuery(SQL_LIST_LOCAIS);
			
			if (rs.first()) {
				locais = new ArrayList<Local>();
				
				while (rs.next()) {
					Local local = new Local();
					local.setLatitude(rs.getString("latitude"));
					local.setLongitude(rs.getString("longitude"));
					locais.add(local);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return locais;
	}
	
	public List<Local> list() {
		List<Local> locais = null;
		
		try {
			Statement st = ds.getConnection().createStatement();
			ResultSet rs = st.executeQuery(SQL_LIST_LOCAIS);
			
			if (rs.first()) {
				locais = new ArrayList<Local>();
				
				while (rs.next()) {
					Local local = new Local();
					local.setLatitude(rs.getString("latitude"));
					local.setLongitude(rs.getString("longitude"));
					locais.add(local);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return locais;
	}

}
