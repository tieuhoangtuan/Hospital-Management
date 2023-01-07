package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.khambenh;

public class khambenhDAL {
	private Connection connection;

	public khambenhDAL() {

	}

//	List<bac_si> bac_siList = new ArrayList<bac_si>();
	// lấy tất cả oke
	public List<khambenh> findAll() {
		List<khambenh> khambenhList = new ArrayList<khambenh>();

		if (openConnection()) {
			try {
				// query

				String sql = "SELECT SOPHIEUKHAM, NGAYKHAM, TRIEUTRUNG, MABS, MABN, TENBENH, khambenh.MADV, THANHTOAN, GIA FROM khambenh,dichvu WHERE khambenh.MADV = dichvu.MADV";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					khambenh std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), resultSet.getString("NGAYKHAM"),
							resultSet.getString("TRIEUTRUNG"), resultSet.getInt("MABS"), resultSet.getInt("MABN"),
							resultSet.getString("TENBENH"), resultSet.getInt("MADV"), resultSet.getInt("THANHTOAN"), resultSet.getInt("GIA"));
					khambenhList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return khambenhList;
	}

	public List<khambenh> findThanhToan() {
		List<khambenh> khambenhList = new ArrayList<khambenh>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from khambenh";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					khambenh std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), resultSet.getString("NGAYKHAM"),
							resultSet.getString("TRIEUTRUNG"), resultSet.getInt("MABS"), resultSet.getInt("MABN"),
							resultSet.getString("TENBENH"), resultSet.getInt("MADV"), resultSet.getInt("THANHTOAN"));
					khambenhList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return khambenhList;
	}

	public boolean insert(khambenh p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "insert into khambenh(SOPHIEUKHAM, NGAYKHAM,TRIEUTRUNG,MABS,MABN,TENBENH,MADV,THANHTOAN) values (?, ?, ?, ?,?,?,?,?)";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, p.getSophieukham());
				statement.setString(2, p.getNgaykham());
				statement.setString(3, p.getTrieutrung());
				statement.setInt(4, p.getMabs());
				statement.setInt(5, p.getMabn());
				statement.setString(6, p.getTenbenh());
				statement.setInt(7, p.getMadv());
				statement.setInt(8, 0);

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
	public boolean update(khambenh p) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "update khambenh set NGAYKHAM=?, TRIEUTRUNG=?, MABS=?, MABN=?, TENBENH=?, MADV=? where SOPHIEUKHAM = ?";
				PreparedStatement statement = connection.prepareCall(sql);

				statement.setString(1, p.getNgaykham());
				statement.setString(2, p.getTrieutrung());
				statement.setInt(3, p.getMabs());
				statement.setInt(4, p.getMabn());
				statement.setString(5, p.getTenbenh());
				statement.setInt(6, p.getMadv());
				statement.setInt(7, p.getSophieukham());

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
	
	public boolean updatethanhtoan(int maBN) {
		boolean result = false;
		if (openConnection()) {
			try {
				// query
				String sql = "update khambenh set THANHTOAN = ?  where MABN = ? ";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, 1);
				statement.setInt(2, maBN);

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
				String sql = "delete from khambenh where SOPHIEUKHAM = ?";
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
	// search
	public List<khambenh> findBysophieukham(int maBN) {
		List<khambenh> khambenhList = new ArrayList<khambenh>();

		if (openConnection()) {
			try {
				// query
				String sql = "SELECT SOPHIEUKHAM, NGAYKHAM, TRIEUTRUNG, MABS, MABN, TENBENH, khambenh.MADV, THANHTOAN, GIA FROM khambenh,dichvu WHERE khambenh.MADV = dichvu.MADV AND MABN = ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, maBN);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					khambenh std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), resultSet.getString("NGAYKHAM"),
							resultSet.getString("TRIEUTRUNG"), resultSet.getInt("MABS"), resultSet.getInt("MABN"),
							resultSet.getString("TENBENH"), resultSet.getInt("MADV"), resultSet.getInt("THANHTOAN"), resultSet.getInt("GIA"));
					khambenhList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return khambenhList;
	}
	
	//tính tiền cho thầy
	public int prince(int maBN) {
		int prince = 0;
		if (openConnection()) {
			try {
				//cái giá phải trả
				
				// query
				String sql = "SELECT SOPHIEUKHAM, NGAYKHAM, TRIEUTRUNG, MABS, MABN, TENBENH, khambenh.MADV, THANHTOAN, GIA FROM khambenh,dichvu WHERE khambenh.MADV = dichvu.MADV AND THANHTOAN = 0 AND MABN = ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, maBN);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					prince += resultSet.getInt("GIA");
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return prince;
	}

	public List<String> getkhambenhList() {
		List<String> khambenhList = new ArrayList<String>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from khambenh";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					String std = resultSet.getString("SOPHIEUKHAM");
					khambenhList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return khambenhList;
	}

	// check trùng mã sản phẩm
	public boolean hasSophieukham(int sophieukham) {
		boolean result = false;

		if (openConnection()) {
			try {
				// query
				String sql = "select * from khambenh where SOPHIEUKHAM=" + sophieukham;
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

	public khambenh getkhambenh(int id) {
		khambenh std = null;
		if (openConnection()) {
			try {
				// query
				String sql = "select * from khambenh where SOPHIEUKHAM = ?";
				PreparedStatement statement = connection.prepareCall(sql);
				statement.setInt(1, id);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), resultSet.getString("NGAYKHAM"),
							resultSet.getString("TRIEUTRUNG"), resultSet.getInt("MABS"), resultSet.getInt("MABN"),
							resultSet.getString("TENBENH"), resultSet.getInt("MADV"), resultSet.getInt("THANHTOAN"));
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return std;
	}

	public List<String> getbenhnhanList() {
		List<String> benhnhanList = new ArrayList<String>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from benhnhan";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					String std = resultSet.getString("TENBN");
					benhnhanList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return benhnhanList;
	}

	public List<String> getbacsiList() {
		List<String> bacsiList = new ArrayList<String>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from bacsi";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					String std = resultSet.getString("TENBS");
					bacsiList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return bacsiList;
	}

	public List<String> getMabenh() {
		List<String> mabenhList = new ArrayList<String>();

		if (openConnection()) {
			try {
				// query
				String sql = "select * from benh";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					String std = resultSet.getString("TEN_BENH");
					mabenhList.add(std);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return mabenhList;
	}

	public int getData(String table, String dataToGet, String name, String col) {
		int data = 0;
		if (openConnection()) {
			try {
				// query
				String sql = "select " + dataToGet + " from " + table + " where " + col + " = '" + name + "' ";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					data = resultSet.getInt(dataToGet);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}

		return data;
	}

	public String getData1(String table, String dataToGet, String name, String col) {
		String data = "";
		if (openConnection()) {
			try {
				// query
				String sql = "select " + dataToGet + " from " + table + " where " + col + " =  " + name + " ";
				Statement statement = connection.createStatement();

				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
					data = resultSet.getString(dataToGet);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}

		return data;
	}

	public int getSPKMAx() {
		int Id = -1;

		if (openConnection()) {
			try {
				// query
				String sql = "select MAX(SOPHIEUKHAM) from khambenh";
				PreparedStatement statement = connection.prepareCall(sql);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Id = resultSet.getInt("MAX(SOPHIEUKHAM)") + 1;
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return Id;
	}

}
