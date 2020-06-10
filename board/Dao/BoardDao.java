package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.BoardBean;


public class BoardDao {

	private static final String url = "jdbc:mysql://localhost:3306/board?serverTimezone=JST";

	private static final String user = "root";

	private static final String pw = "Kei0418s";


	public static ArrayList<BoardBean> board_list(){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(url, user, pw);


			String sql = "SELECT * FROM region_board order by time_contribute desc";


			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<BoardBean> list = new ArrayList<BoardBean>();


			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String time_contribute = rs.getString("time_contribute");
				String time_edit = rs.getString("time_edit");
				String content = rs.getString("content");
				String app_file = rs.getString("app_file");


				BoardBean result = new BoardBean(id, name, mail,time_contribute , time_edit ,content,app_file);
				list.add(result);
			}


			return list;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}


		return null;
	}

	public static BoardBean get_board(int key){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(url, user, pw);


			String sql = "SELECT * FROM region_board where id = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, key);






			rs = pstmt.executeQuery();

			ArrayList<BoardBean> list = new ArrayList<BoardBean>();

			BoardBean result = null;

			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String time_contribute = rs.getString("time_contribute");
				String time_edit = rs.getString("time_edit");
				String content = rs.getString("content");
				String app_file = rs.getString("app_file");


				result = new BoardBean(id, name, mail,time_contribute , time_edit ,content,app_file);
			}


			return result;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}


		return null;
	}

	public static void insertboard(BoardBean s){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");



			con = DriverManager.getConnection(url, user, pw);


			String sql = "INSERT INTO region_board(name,mail,time_contribute,content,app_file) VALUES(?,?,?,?,?)";


			pstmt = con.prepareStatement(sql);


			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMail());
			pstmt.setString(3, s.getTime_contribute());
			pstmt.setString(4, s.getContent());
			pstmt.setString(5, s.getApp_file());


			int result = pstmt.executeUpdate();


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

	public static void delete_board(int no){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(url, user, pw);


			String sql = "DELETE FROM region_board WHERE id = ?";


			pstmt = con.prepareStatement(sql);


			pstmt.setInt(1, no);


			int result = pstmt.executeUpdate();
			System.out.println(result + "件削除されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

	public static void set_board(int id, String name, String mail, String time_edit, String content,String app_file){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");



			con = DriverManager.getConnection(url, user, pw);


			String sql = "update region_board set name = ? ,mail = ? ,time_edit = ? ,content = ? where id = ?";


			pstmt = con.prepareStatement(sql);

			System.out.println("1");


			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			pstmt.setString(3, time_edit);
			pstmt.setString(4, content);


			int result = pstmt.executeUpdate();
			System.out.println("2");


		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

	public static BoardBean board_search(int key){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection(url, user, pw);


			String sql = "SELECT * FROM region_board where id = ?";


			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1,key);

			rs = pstmt.executeQuery();

			BoardBean result = null;


			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String time_contribute = rs.getString("time_contribute");
				String time_edit = rs.getString("time_edit");
				String content = rs.getString("content");
				String app_file = rs.getString("app_file");


				result = new BoardBean(id, name, mail,time_contribute , time_edit ,content,app_file);

			}


			return result;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {

			try {

				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}


		return null;
	}



}