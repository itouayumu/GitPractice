package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.acount;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class acountdao {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerAccount(acount account) {
		String sql = "INSERT INTO account2 VALUES(default, ?, ?, ?, ?,?,?,? )";
		int result = 0;
		
		
		String salt = GenerateSalt.getSalt(32);
		
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		
	

		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getName());
			pstmt.setInt(2, account.getAge());
			pstmt.setString(3, account.getGen());
			pstmt.setInt(4, account.getPhon());
			pstmt.setString(5, account.getMail());
			pstmt.setString(6, salt);
			pstmt.setString(7, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM account2 WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
public static List<acount> selectAllacount(){
	
		
		
		
		
		List<acount> result = new ArrayList<>();
		String sql = "SELECT * FROM account2";
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			
			
			try (ResultSet rs = pstmt.executeQuery()){
				
			
				while(rs.next()) {

					String id = rs.getString("id");
					String name = rs.getString("name");
					String age = rs.getString("age");
					String gen = rs.getString("gen");
					String phon = rs.getString("phon");

					int ID = Integer.parseInt(id);
					int Age = Integer.parseInt(age);
					int Phon = Integer.parseInt(phon);
					
				

					
					
					acount acount = new acount (ID, name, Age,gen,Phon,null,null, null, null);
					
					
					result.add(acount);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			e.printStackTrace();
		}

	
		return result;
	}
	

	public static acount login(String mail, String hashedPw) {
		String sql = "SELECT * FROM account2 WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int id = rs.getInt("id");
					
					String name = rs.getString("name");
					String age = rs.getString("age");
					String gen = rs.getString("gen");
					String phon = rs.getString("phon");


					int Age = Integer.parseInt(age);
					int Phon = Integer.parseInt(phon);
					
					
					return new acount(id, name, Age,gen,Phon,null,null, null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
public static int deleteacount(String mail) {
		
		String sql = "DELETE FROM account2 WHERE mail = ?";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, mail);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;

		}
	
	
}
