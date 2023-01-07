package DTO;

public class khambenh {
	private int sophieukham;
	private String ngaykham;
	private String trieutrung;
	private String tenbenh;
	private int madv;
	private int mabn;
	private int mabs;
	private int thanhtoan;
	private int gia;
	
	public int getGia() {
		return gia;
	}


	public void setGia(int gia) {
		this.gia = gia;
	}


	public khambenh(int sophieukham, String ngaykham, String trieutrung, int mabs, int mabn, String tenbenh, int madv,
			int thanhtoan, int gia) {
		super();
		this.sophieukham = sophieukham;
		this.ngaykham = ngaykham;
		this.trieutrung = trieutrung;
		this.tenbenh = tenbenh;
		this.madv = madv;
		this.mabn = mabn;
		this.mabs = mabs;
		this.thanhtoan = thanhtoan;
		this.gia = gia;
	}


	public khambenh(int sophieukham, String ngaykham, String trieutrung, int mabs, int mabn, String tenbenh, int madv,
			int thanhtoan) {
		super();
		this.sophieukham = sophieukham;
		this.ngaykham = ngaykham;
		this.trieutrung = trieutrung;
		this.tenbenh = tenbenh;
		this.madv = madv;
		this.mabn = mabn;
		this.mabs = mabs;
		this.thanhtoan = thanhtoan;
	}


	public int getThanhtoan() {
		return thanhtoan;
	}


	public void setThanhtoan(int thanhtoan) {
		this.thanhtoan = thanhtoan;
	}


	public khambenh(){
		super();
		this.sophieukham=0;
		this.ngaykham=null;
		this.trieutrung=null;
		this.tenbenh=null;
		this.madv=0;
	}

	
	public int getMabn() {
		return mabn;
	}

	public void setMabn(int mabn) {
		this.mabn = mabn;
	}

	public int getMabs() {
		return mabs;
	}

	public void setMabs(int mabs) {
		this.mabs = mabs;
	}

	public int getSophieukham() {
		return sophieukham;
	}

	public void setSophieukham(int sophieukham) {
		this.sophieukham = sophieukham;
	}

	public String getNgaykham() {
		return ngaykham;
	}

	public void setNgaykham(String ngaykham) {
		this.ngaykham = ngaykham;
	}

	public String getTrieutrung() {
		return trieutrung;
	}

	public void setTrieutrung(String trieutrung) {
		this.trieutrung = trieutrung;
	}

	public String getTenbenh() {
		return tenbenh;
	}

	public void setTenbenh(String tenbenh) {
		this.tenbenh = tenbenh;
	}

	public int getMadv() {
		return madv;
	}

	public void setMadv(int madv) {
		this.madv = madv;
	}
	
}
