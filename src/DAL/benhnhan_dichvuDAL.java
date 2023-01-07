package DAL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.*;

import javax.swing.JOptionPane;

//import DAL.databaseConnect;
import DTO.benhnhan_dichvu;

public class benhnhan_dichvuDAL {

	private Connection connection;

	public benhnhan_dichvuDAL() {

	}

//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke
	public List<benhnhan_dichvu> findAll() {
		List<benhnhan_dichvu> list = new ArrayList<benhnhan_dichvu>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from benhnhan_dichvu";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					benhnhan_dichvu std = new benhnhan_dichvu(resultSet.getInt("SOPHIEU_SD"), resultSet.getInt("MA_BN"),
							resultSet.getString("NGAY_SD"), resultSet.getInt("SOLUONGDV"), resultSet.getInt("MADV"));
					list.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return list;
	}

	public boolean insert(benhnhan_dichvu p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "insert into benhnhan_dichvu(SOPHIEU_SD, MA_BN, NGAY_SD, SOLUONGDV, MADV) values (?, ?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setInt(1, p.getSphieuSD());
				statement.setInt(2, p.getMaBN());
				statement.setString(3, p.getNgaySD());
				statement.setInt(4, p.getSoluongDV());
				statement.setInt(5, p.getMaDV());

				if (statement.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return result;
	}

	// sửa oke
	public boolean update(benhnhan_dichvu p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "update benhnhan_dichvu set MA_BN=?, NGAY_SD=?, SOLUONGDV=?, MADV=? where SOPHIEU_SD = ?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setInt(1, p.getMaBN());
				statement.setString(2, p.getNgaySD());
				statement.setInt(3, p.getSoluongDV());
				statement.setInt(4, p.getMaDV());
				statement.setInt(5, p.getSphieuSD());

				if (statement.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "delete from benhnhan_dichvu where SOPHIEU_SD=?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setInt(1, id);

				if (statement.executeUpdate() >= 1) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return result;
	}

	public List<benhnhan_dichvu> findById(int bienLaiCode) {
		List<benhnhan_dichvu> list = new ArrayList<benhnhan_dichvu>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from benhnhan_dichvu where MA_BN like ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, bienLaiCode);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					benhnhan_dichvu std = new benhnhan_dichvu(resultSet.getInt("SOPHIEU_SD"), resultSet.getInt("MA_BN"),
							resultSet.getString("NGAY_SD"), resultSet.getInt("SOLUONGDV"), resultSet.getInt("MADV"));
					list.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return list;
	}

	public boolean hasBenhNhanDichVu(benhnhan_dichvu p) {
		boolean result = false;

		if (openConnection()) {
			try {
				// query
				String sql = "select * from benhnhan_dichvu where SOPHIEU_SD=" + p.getSphieuSD();
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				result = resultSet.next();
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}

		return result;
	}
	
	public int getMaPhieumax() {
		int Id = -1;

		if (openConnection()) {
			try {
				// query
				String sql = "select MAX(SOPHIEU_SD) from benhnhan_dichvu";
				PreparedStatement statement = connection.prepareCall(sql);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Id = resultSet.getInt("MAX(SOPHIEU_SD)") + 1;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return Id;
	}


	// hàm kết nối và đóng csdl
	public boolean openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbv?useSSL=false", "root", "");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
