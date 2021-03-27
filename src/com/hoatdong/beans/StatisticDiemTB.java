package com.hoatdong.beans;

/**
 * StatisticDiemTB
 *
 * Version 1.0
 *
 * Date: 18-06-2018
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          	DESCRIPTION
 * -----------------------------------------------------------------------
 * 18-06-2018           Huynh Tan Luc   	Create
 */
public class StatisticDiemTB {
	private String maTV;
	private String hoTenTV;
	private float diemTB;
	
	/**
	 * The StatisticDiemTB constructor
	 */
	public StatisticDiemTB() {
	}

	/**
	 * The StatisticDiemTB constructor
	 * @param maTV
	 * @param hoTenTV
	 * @param diemTB
	 */
	public StatisticDiemTB(String maTV, String hoTenTV, float diemTB) {
		this.maTV = maTV;
		this.hoTenTV = hoTenTV;
		this.diemTB = diemTB;
	}

	/**
	 * The getMaTV getter method of maTV field
	 * @return the maTV
	 */
	public String getMaTV() {
		return maTV;
	}

	/**
	 * The setMaTV setter method of maTV field
	 * @param maTV
	 */
	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}

	/**
	 * The getHoTenTV getter method of hoTenTV field
	 * @return the hoTenTV
	 */
	public String getHoTenTV() {
		return hoTenTV;
	}

	/**
	 * The setHoTenTV setter method of hoTenTV field
	 * @param hoTenTV
	 */
	public void setHoTenTV(String hoTenTV) {
		this.hoTenTV = hoTenTV;
	}

	/**
	 * The getDiemTB getter method of diemTB field
	 * @return the diemTB
	 */
	public float getDiemTB() {
		return diemTB;
	}

	/**
	 * The setDiemTB setter method of diemTB field
	 * @param diemTB
	 */
	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	/**
	 * The toString overriding method of com.hoatdong.beans.StatisticDiemTB class
	 */
	@Override
	public String toString() {
		return "StatisticDiemTB [maTV=" + maTV + ", HoTenTV=" + hoTenTV + ", diemTB=" + diemTB + "]";
	}
	
}
