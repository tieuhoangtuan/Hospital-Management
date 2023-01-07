package BLL;

import java.util.*;

import DAL.dichVuDAL;
import DAL.bacsiDAL;
import DTO.*;

public class dichvuBLL {
	dichVuDAL dvDAL = new dichVuDAL();
	
	public List<dichvu> getAlldichvu() {
		return dvDAL.findAll();
	}
	
	public String adddichvu(dichvu p) {
		if(dvDAL.insert(p)) {
			return "Thêm dịch vụ thành công";
		}
		return "Thêm dịch vụ không thành công";
	}
	
	public String deletedichvu(dichvu d) {
		if(dvDAL.delete(d.getMaDV())) {
			return "Thêm dịch vụ thành công";
		}
		return "Xóa dịch vụ không thành công";
	}
	
	public String editdichvu(dichvu p) {
		if(dvDAL.update(p)) {
			return "Sửa dịch vụ thành công";
		}
		return "Sửa dịch vụ không thành công";
	}
	
	public List<String> getdichvuList() {
		return dvDAL.getdichVuList();
	}
	
	public dichvu getdichvu(int id) {
		return dvDAL.getdichvu(id);
	}
}
