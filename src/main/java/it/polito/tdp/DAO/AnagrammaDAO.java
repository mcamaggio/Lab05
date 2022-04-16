package it.polito.tdp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	/**
	 * Il metodo si occupa di verificare se una determinata stringa sia contenuta nel dizionario
	 * @param anagramma - parola da ricercare nel dizionario
	 * @return - il valore di ritorno è un booleano 
	 */
	
	public boolean isCorrect(String anagramma) {
		
		String sql = "SELECT nome FROM parola WHERE nome = ?";
		boolean result;
		
		try {
			Connection conn = ConnectDB.getConnection() ;
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setString(1, anagramma);
			
			ResultSet res = st.executeQuery() ;
			
			if(res.next())
				result = true;
			else
				result = false;
			
			res.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}				
	}

}
