package com.hoatdong.beans;

public class HoatDong {
	
	private int maHD;
	private String tenHD;
	private String moTaHD;
	private DateTime ngayGioBD;
	private DateTime ngayGioKT;
	private int slToiThieuYC;
	private int slToiDaYC;
	private DateTime thoiHanDK;
	private String trangThai;
	private int maTV;
	private String lyDoHuyDK;
	
	/**
	 * The HoatDong constructor
	 */
	public HoatDong() {
	}
	
	/**
	 * The HoatDong constructor
	 * @param maHD
	 */
	public HoatDong(int maHD) {
		this.maHD = maHD;
	}

	/**
	 * The HoatDong constructor
	 * @param tenHD
	 * @param moTaHD
	 * @param ngayGioBD
	 * @param ngayGioKT
	 * @param slToiThieuYC
	 * @param slToiDaYC
	 * @param thoiHanDK
	 * @param trangThai
	 * @param maTV
	 */
	public HoatDong(String tenHD, String moTaHD, DateTime ngayGioBD, DateTime ngayGioKT, int slToiThieuYC,
			int slToiDaYC, DateTime thoiHanDK, String trangThai, int maTV) {
		this.tenHD = tenHD;
		this.moTaHD = moTaHD;
		this.ngayGioBD = ngayGioBD;
		this.ngayGioKT = ngayGioKT;
		this.slToiThieuYC = slToiThieuYC;
		this.slToiDaYC = slToiDaYC;
		this.thoiHanDK = thoiHanDK;
		this.trangThai = trangThai;
		this.maTV = maTV;
	}

	/**
	 * The HoatDong constructor
	 * @param maHD
	 * @param tenHD
	 * @param moTaHD
	 * @param ngayGioBD
	 * @param ngayGioKT
	 * @param slToiThieuYC
	 * @param slToiDaYC
	 * @param thoiHanDK
	 * @param trangThai
	 * @param maTV
	 * @param lyDoHuyDK
	 */
	public HoatDong(int maHD, String tenHD, String moTaHD, DateTime ngayGioBD, DateTime ngayGioKT, int slToiThieuYC,
			int slToiDaYC, DateTime thoiHanDK, String trangThai, int maTV, String lyDoHuyDK, String action) {
		this.maHD = maHD;
		this.tenHD = tenHD;
		this.moTaHD = moTaHD;
		this.ngayGioBD = ngayGioBD;
		this.ngayGioKT = ngayGioKT;
		this.slToiThieuYC = slToiThieuYC;
		this.slToiDaYC = slToiDaYC;
		this.thoiHanDK = thoiHanDK;
		
		if(action == "getAll") {
			switch (trangThai) {
			case "1":
				this.trangThai = "Đã hết hạn đăng ký";
				break;
			case "2":
				this.trangThai = "Trưởng đoàn tự hủy";
				break;
			case "3":
				this.trangThai = "Đã kết thúc";
				break;
			default:
				this.trangThai = "Đang mời đăng ký";
				break;
			}
		} else {
			this.trangThai = trangThai;
		}
			
		this.maTV = maTV;
		this.lyDoHuyDK = lyDoHuyDK;
	}

	/**
	 * The getMaHD getter method of maHD field
	 * @return the maHD
	 */
	public int getMaHD() {
		return maHD;
	}

	/**
	 * The setMaHD setter method of maHD field
	 * @param maHD
	 */
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	/**
	 * The getTenHD getter method of tenHD field
	 * @return the tenHD
	 */
	public String getTenHD() {
		return tenHD;
	}

	/**
	 * The setTenHD setter method of tenHD field
	 * @param tenHD
	 */
	public void setTenHD(String tenHD) {
		this.tenHD = tenHD;
	}

	/**
	 * The getMoTaHD getter method of moTaHD field
	 * @return the moTaHD
	 */
	public String getMoTaHD() {
		return moTaHD;
	}

	/**
	 * The setMoTaHD setter method of moTaHD field
	 * @param moTaHD
	 */
	public void setMoTaHD(String moTaHD) {
		this.moTaHD = moTaHD;
	}

	/**
	 * The getNgayGioBD getter method of ngayGioBD field
	 * @return the ngayGioBD
	 */
	public DateTime getNgayGioBD() {
		return ngayGioBD;
	}

	/**
	 * The setNgayGioBD setter method of ngayGioBD field
	 * @param ngayGioBD
	 */
	public void setNgayGioBD(DateTime ngayGioBD) {
		this.ngayGioBD = ngayGioBD;
	}

	/**
	 * The getNgayGioKT getter method of ngayGioKT field
	 * @return the ngayGioKT
	 */
	public DateTime getNgayGioKT() {
		return ngayGioKT;
	}

	/**
	 * The setNgayGioKT setter method of ngayGioKT field
	 * @param ngayGioKT
	 */
	public void setNgayGioKT(DateTime ngayGioKT) {
		this.ngayGioKT = ngayGioKT;
	}

	/**
	 * The getSlToiThieuYC getter method of slToiThieuYC field
	 * @return the slToiThieuYC
	 */
	public int getSlToiThieuYC() {
		return slToiThieuYC;
	}

	/**
	 * The setSlToiThieuYC setter method of slToiThieuYC field
	 * @param slToiThieuYC
	 */
	public void setSlToiThieuYC(int slToiThieuYC) {
		this.slToiThieuYC = slToiThieuYC;
	}

	/**
	 * The getSlToiDaYC getter method of slToiDaYC field
	 * @return the slToiDaYC
	 */
	public int getSlToiDaYC() {
		return slToiDaYC;
	}

	/**
	 * The setSlToiDaYC setter method of slToiDaYC field
	 * @param slToiDaYC
	 */
	public void setSlToiDaYC(int slToiDaYC) {
		this.slToiDaYC = slToiDaYC;
	}

	/**
	 * The getThoiHanDK getter method of thoiHanDK field
	 * @return the thoiHanDK
	 */
	public DateTime getThoiHanDK() {
		return thoiHanDK;
	}

	/**
	 * The setThoiHanDK setter method of thoiHanDK field
	 * @param thoiHanDK
	 */
	public void setThoiHanDK(DateTime thoiHanDK) {
		this.thoiHanDK = thoiHanDK;
	}

	/**
	 * The getTrangThai getter method of trangThai field
	 * @return the trangThai
	 */
	public String getTrangThai() {
		return trangThai;
	}

	/**
	 * The setTrangThai setter method of trangThai field
	 * @param trangThai
	 */
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	/**
	 * The getMaTV getter method of maTV field
	 * @return the maTV
	 */
	public int getMaTV() {
		return maTV;
	}

	/**
	 * The setMaTV setter method of maTV field
	 * @param maTV
	 */
	public void setMaTV(int maTV) {
		this.maTV = maTV;
	}

	/**
	 * The getLyDoHuyDK getter method of lyDoHuyDK field
	 * @return the lyDoHuyDK
	 */
	public String getLyDoHuyDK() {
		return lyDoHuyDK;
	}

	/**
	 * The setLyDoHuyDK setter method of lyDoHuyDK field
	 * @param lyDoHuyDK
	 */
	public void setLyDoHuyDK(String lyDoHuyDK) {
		this.lyDoHuyDK = lyDoHuyDK;
	}

	/**
	 * The toString overriding method of com.hoatdong.beans.HoatDong class
	 */
	@Override
	public String toString() {
		return "HoatDong [maHD=" + maHD + ", tenHD=" + tenHD + ", moTaHD=" + moTaHD + ", ngayGioBD=" + ngayGioBD
				+ ", ngayGioKT=" + ngayGioKT + ", slToiThieuYC=" + slToiThieuYC + ", slToiDaYC=" + slToiDaYC
				+ ", thoiHanDK=" + thoiHanDK + ", trangThai=" + trangThai + ", maTV=" + maTV + ", lyDoHuyDK="
				+ lyDoHuyDK + "]";
	}

}
