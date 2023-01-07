package BLL;

import java.text.ParseException;
import java.util.*;

import javax.swing.JOptionPane;

import DTO.benhnhan_dichvu;
import DTO.bienlai;
import DAL.benhnhan_dichvuDAL;
import DAL.bienlaiDAL;

public class benhnhan_dichvuBLL {
	benhnhan_dichvuDAL blDAL = new benhnhan_dichvuDAL();
	
	public List<benhnhan_dichvu> getAllBill() {
		return blDAL.findAll();
	}
	
	public String addPhieu(benhnhan_dichvu p) {
		if(blDAL.hasBenhNhanDichVu(p)) {
			return "Số của phiếu này đã bị trùng. Vui lòng thử lại";
		}
		if(blDAL.insert(p)) {
			return "Thêm phiếu thành công";
		}
		return "Thêm phiếu không thành công";
	}
	
	public String deletePhieu(int id) {
		if(blDAL.delete(id)) {
			JOptionPane.showMessageDialog(null, id);
			return "Xóa phiếu thành công";
		}
		return "Xóa phiếu không thành công";
	}
	
	public String editPhieu(benhnhan_dichvu p) {
//		if(!blDAL.hasEmployee(p)) {
//			return "Mã nhân viên này không tồn tại. Vui lòng kiểm tra lại";
//		}
		if(blDAL.update(p)) {
			return "Sửa phiếu thành công";
		}
		return "Sửa phiếu không thành công";
	}
	
	
	public List<benhnhan_dichvu> searchBienLaiByCode(int maBenhNhan) {
		return blDAL.findById(maBenhNhan);
	}
	
	public int getMaPhieumax() {
		return blDAL.getMaPhieumax();
	}
	
}
