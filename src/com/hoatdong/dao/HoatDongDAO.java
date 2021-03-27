package com.hoatdong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hoatdong.beans.DateTime;
import com.hoatdong.beans.HoatDong;
import com.hoatdong.beans.StatisticDiemTB;

public class HoatDongDAO {
	
	public static boolean insertHoatDong(Connection conn, HoatDong hoatDong) {
        boolean rowInserted = false;
		String sql = "INSERT INTO [dbo].[HOATDONG]\r\n" + 
				"           ([TenHD]\r\n" + 
				"           ,[MoTaHD]\r\n" + 
				"           ,[NgayGioBD]\r\n" + 
				"           ,[NgayGioKT]\r\n" + 
				"           ,[SLToiThieuYC]\r\n" + 
				"           ,[SLToiDaYC]\r\n" + 
				"           ,[ThoiHanDK]\r\n" + 
				"           ,[TrangThai]\r\n" + 
				"           ,[MaTV])\r\n" + 
				"     VALUES\r\n" + 
				"           (?\r\n" + 
				"           ,?\r\n" + 
				"           ,?\r\n" + 
				"           ,?\r\n" + 
				"           ,?\r\n" + 
				"           ,?\r\n" + 
				"           ,?\r\n" + 
				"           ,?\r\n" + 
				"           ,?)";
        try {
        	PreparedStatement pst = conn.prepareStatement(sql);
        	pst.setString(1, hoatDong.getTenHD());
            pst.setString(2, hoatDong.getMoTaHD());
            pst.setString(3, hoatDong.getNgayGioBD().toString());
            pst.setString(4, hoatDong.getNgayGioKT().toString());
            pst.setInt(5, hoatDong.getSlToiThieuYC());
            pst.setInt(6, hoatDong.getSlToiDaYC());
            pst.setString(7, hoatDong.getThoiHanDK().toString());
            pst.setString(8, hoatDong.getTrangThai());
            pst.setInt(9, hoatDong.getMaTV());
            if (pst.executeUpdate() > 0) rowInserted = true;
            pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return rowInserted;
    }
	
	public static List<HoatDong> getAllHoatDongs(Connection conn) {
        List<HoatDong> listHoatDong = new ArrayList<>();
        String sql = "SELECT [MaHD]\r\n" + 
        		"      ,[TenHD]\r\n" + 
        		"      ,[MoTaHD]\r\n" + 
        		"      ,CONVERT(NVARCHAR(19),NgayGioBD, 21) AS [NgayGioBD]\r\n" + 
        		"      ,CONVERT(NVARCHAR(19),NgayGioKT, 21) AS [NgayGioKT]\r\n" + 
        		"      ,[SLToiThieuYC]\r\n" + 
        		"      ,[SLToiDaYC]\r\n" + 
        		"      ,CONVERT(NVARCHAR(19),ThoiHanDK, 21) AS [ThoiHanDK]\r\n" + 
        		"      ,[TrangThai]\r\n" + 
        		"      ,[MaTV]\r\n" + 
        		"      ,[LyDoHuyDK]\r\n" + 
        		"  FROM [dbo].[HOATDONG]";
        try {
        	PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maHD = rs.getInt("MaHD");
                String tenHD = rs.getString("TenHD");
            	String moTaHD = rs.getString("MoTaHD");
            	
            	DateTime ngayGioBD = new DateTime();
            	ngayGioBD.setDateTime(rs.getString("NgayGioBD"));
            	
            	DateTime ngayGioKT = new DateTime();
            	ngayGioKT.setDateTime(rs.getString("NgayGioKT"));
            	
            	int slToiThieuYC = rs.getInt("SLToiThieuYC");
            	int slToiDaYC = rs.getInt("SLToiDaYC");
            	
            	DateTime thoiHanDK = new DateTime();
            	thoiHanDK.setDateTime(rs.getString("ThoiHanDK"));
            	
            	String trangThai = rs.getString("TrangThai");
            	int maTV = rs.getInt("MaTV");
            	String lyDoHuyDK = rs.getString("LyDoHuyDK");
            	String action = "getAll";
                
                HoatDong hoatDong = new HoatDong(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, trangThai, maTV, lyDoHuyDK, action);
                listHoatDong.add(hoatDong);
            }
            rs.close();
            pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return listHoatDong;
    }
	
	public static boolean updateHoatDong(Connection conn, HoatDong hoatDong) {
        boolean rowUpdated = false;
		String sql = "UPDATE [dbo].[HOATDONG]\r\n" + 
				"   SET [TenHD] = ?\r\n" + 
				"      ,[MoTaHD] = ?\r\n" + 
				"      ,[NgayGioBD] = ?\r\n" + 
				"      ,[NgayGioKT] = ?\r\n" + 
				"      ,[SLToiThieuYC] = ?\r\n" + 
				"      ,[SLToiDaYC] = ?\r\n" + 
				"      ,[ThoiHanDK] = ?\r\n" + 
				"      ,[TrangThai] = ?\r\n" + 
				"      ,[MaTV] = ?\r\n" + 
				"      ,[LyDoHuyDK] = ?\r\n" + 
				" WHERE MaHD = ? "
				+ " UPDATE THAMGIA " + 
				"   SET [MaTV] = ? "
				+ " WHERE MaHD = ? ";
        try {
        	PreparedStatement pst = conn.prepareStatement(sql);
        	pst.setString(1, hoatDong.getTenHD());
        	pst.setString(2, hoatDong.getMoTaHD());
        	pst.setString(3, hoatDong.getNgayGioBD().toString());
        	pst.setString(4, hoatDong.getNgayGioKT().toString());
        	pst.setInt(5, hoatDong.getSlToiThieuYC());
        	pst.setInt(6, hoatDong.getSlToiDaYC());
        	pst.setString(7, hoatDong.getThoiHanDK().toString());
        	pst.setString(8, hoatDong.getTrangThai());
        	pst.setInt(9, hoatDong.getMaTV());
        	pst.setString(10, hoatDong.getLyDoHuyDK());
        	pst.setInt(11, hoatDong.getMaHD());
        	pst.setInt(12, hoatDong.getMaTV());
        	pst.setInt(13, hoatDong.getMaHD());
            if(pst.executeUpdate() > 0) rowUpdated = true;
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return rowUpdated;
    }
	
	public static boolean deleteHoatDong(Connection conn, HoatDong hoatDong) {
        String sql = "DELETE FROM THAMGIA WHERE MaHD = ? "
        		   + "DELETE FROM HOATDONG WHERE MaHD = ?";
        try {
        	PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, hoatDong.getMaHD());
            pst.setInt(2, hoatDong.getMaHD());
            if(pst.executeUpdate() > 0) return true;
            pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return false;
    }
	
	public static HoatDong getMaHoatDong(Connection conn, int maHD) {
        HoatDong hoatDong = null;
        String sql = "SELECT [TenHD]\r\n" + 
        		"		,[MoTaHD]\r\n" + 
        		"		,CONVERT(NVARCHAR(19), NgayGioBD, 120) AS [NgayGioBD]\r\n" + 
        		"		,CONVERT(NVARCHAR(19), NgayGioKT, 120) AS [NgayGioKT]\r\n" + 
        		"		,[SLToiThieuYC]\r\n" + 
        		"		,[SLToiDaYC]\r\n" + 
        		"		,CONVERT(NVARCHAR(19), ThoiHanDK, 120) AS [ThoiHanDK]\r\n" + 
        		"		,[TrangThai]\r\n" + 
        		"		,[MaTV]\r\n" + 
        		"		,[LyDoHuyDK]\r\n" + 
        		"		FROM [dbo].[HOATDONG] WHERE MaHD = ?";
        try {
        	PreparedStatement pst = conn.prepareStatement(sql);
        	pst.setInt(1, maHD);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String tenHD = rs.getNString("TenHD");
            	String moTaHD = rs.getString("MoTaHD");
            	
            	DateTime ngayGioBD = new DateTime();
            	ngayGioBD.setDateTime(rs.getString("NgayGioBD"));
            	DateTime ngayGioKT = new DateTime();
            	ngayGioKT.setDateTime(rs.getString("NgayGioKT"));
            	
            	int slToiThieuYC = rs.getInt("SLToiThieuYC");
            	int slToiDaYC = rs.getInt("SLToiDaYC");
            	
            	DateTime thoiHanDK = new DateTime();
            	thoiHanDK.setDateTime(rs.getString("ThoiHanDK"));
            	
            	String trangThai = rs.getString("TrangThai");
            	int maTV = rs.getInt("MaTV");
            	String lyDoHuyDK = rs.getString("LyDoHuyDK");
            	String action = "getMaHD";
            	
                hoatDong = new HoatDong(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, trangThai, maTV, lyDoHuyDK, action);
            }
            rs.close();
            pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return hoatDong;
    }

	public static List<StatisticDiemTB> StatisticDiemTB(Connection conn) {
		List<StatisticDiemTB> listStatisticDiemTB = new ArrayList<>();
		String sql = "SELECT tg.MaTV, tv.HoTen, DiemTruongDoan AS DiemDanhGiaTB\r\n" + 
				"FROM THANHVIEN AS tv JOIN THAMGIA AS tg ON tv.MaTV = tg.MaTV\r\n" + 
				"ORDER BY DiemDanhGiaTB DESC";
		try {
        	PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
            	String maTV = rs.getString("MaTV");
            	String hoTenTV = rs.getString("HoTen");
            	float diemTB = rs.getFloat("DiemDanhGiaTB");
                
            	StatisticDiemTB statisticDiemTB = new StatisticDiemTB(maTV, hoTenTV, diemTB);
            	listStatisticDiemTB.add(statisticDiemTB);
            }
            rs.close();
            pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStatisticDiemTB;
	}
}