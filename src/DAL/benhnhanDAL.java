package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.benhnhan;

public class benhnhanDAL {
	private Connection connection; 
	public benhnhanDAL() {
		
	}

	public List<benhnhan> findAll() {
		List<benhnhan> benh_nhanList = new ArrayList<benhnhan>();
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "select * from benhnhan";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	benhnhan std = new benhnhan(resultSet.getInt("MABN"), 
	                        resultSet.getString("TENBN"), resultSet.getString("NGAYSINH"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("SDT"), resultSet.getString("GIOITINH"),resultSet.getInt("SOGIUONG"),resultSet.getInt("SOPHONG"));
	            	benh_nhanList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return benh_nhanList;
	}
	
	public boolean insert(benhnhan p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into benhnhan(MABN, TENBN, NGAYSINH,DIACHI,SDT,GIOITINH,SOGIUONG,SOPHONG) values (?, ?, ?,?, ?,?,?,?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getMabn());
	            statement.setString(2, p.getTenbn());
	            statement.setString(3, p.getNgaysinh());
	            statement.setString(4, p.getDiachi());
	            statement.setString(5, p.getSdt());
	            statement.setString(6, p.getGioitinh());
	            statement.setInt(7, p.getSogiuong());
	            statement.setInt(8, p.getSophong());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	
	 // s???a oke
	public boolean update(benhnhan p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "update benhnhan set TENBN=?, NGAYSINH=?, DIACHI=?, SDT=?, GIOITINH=?, SOGIUONG=?, SOPHONG=? where MABN = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getMabn());
	            statement.setString(2, p.getTenbn());
	            statement.setString(3, p.getNgaysinh());
	            statement.setString(4, p.getDiachi());
	            statement.setString(5, p.getSdt());
	            statement.setString(6, p.getGioitinh());
	            statement.setInt(7, p.getSogiuong());
	            statement.setInt(8, p.getSophong());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	public boolean delete(int id) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "delete from benhnhan where MABN = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, id);
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	public List<benhnhan> findByFullName(String benh_nhanName) {
		List<benhnhan> benh_nhanList = new ArrayList<benhnhan>();
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "select * from benhnhan where TENBN like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%"+benh_nhanName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {    
	            	benhnhan std = new benhnhan(resultSet.getInt("MABN"), 
	            			 resultSet.getString("TENBN"), resultSet.getString("NGAYSINH"), 
		                        resultSet.getString("DIACHI"),resultSet.getString("SDT"), resultSet.getString("GIOITINH"),resultSet.getInt("SOGIUONG"),resultSet.getInt("SOPHONG"));
	            	benh_nhanList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return benh_nhanList;
	}
	public List<String> getbenh_nhanList() {
		List<String> benh_nhanList = new ArrayList<String>();
		
		if(openConnection()) {
			try {  
	            //query
	            String sql = "select * from benhnhan";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("TENBN");
	            	benh_nhanList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return benh_nhanList;
	}
	 // check tr??ng m??
	 public boolean hasbenh_nhanCode(int benh_nhanCode) {
		 boolean result = false;
		 
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select * from benhnhan where MABN=" + benh_nhanCode;
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            result = resultSet.next();
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
		 
		 return result;
	 }
	 // h??m k???t n???i v?? ????ng csdl 
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
			 if(connection!=null) {
				 connection.close();
			 } 
		 } catch(SQLException e) {
			 System.out.println(e);
		 }
	 }
	 public benhnhan getbenhnhan(int id) {
		 benhnhan std = null;
		 if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbv?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from benhnhan where MABN = ?" ;
		            PreparedStatement statement = connection.prepareCall(sql);
		            statement.setInt(1, id);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {    
		            	std = new benhnhan(resultSet.getInt("MABN"), 
		            			 resultSet.getString("TENBN"), resultSet.getString("NGAYSINH"), 
			                     resultSet.getString("DIACHI"),resultSet.getString("SDT"), resultSet.getString("GIOITINH"),resultSet.getInt("SOGIUONG"),resultSet.getInt("SOPHONG"));
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
		 return std;
	 }
	 public int getMaBNMax() {
		 int Id = -1;
		 if (openConnection()) {
				try {
					// query
					String sql = "select MAX(MABN) from benhnhan";
					PreparedStatement statement = connection.prepareCall(sql);

					ResultSet resultSet = statement.executeQuery();

					while (resultSet.next()) {
						Id = resultSet.getInt("MAX(MABN)") + 1;
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
