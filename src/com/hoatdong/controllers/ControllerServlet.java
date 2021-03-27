package com.hoatdong.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoatdong.beans.DateTime;
import com.hoatdong.beans.HoatDong;
import com.hoatdong.beans.StatisticDiemTB;
import com.hoatdong.dao.HoatDongDAO;
import com.hoatdong.db.ConnectionDB;

/**
 * ControllerServlet
 *	
 * Version 1.0
 *
 * Date: 15-06-2018
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          	DESCRIPTION
 * -----------------------------------------------------------------------
 * 15-06-2018           Huynh Tan Luc   	Create
 */
@WebServlet(description = "DAOHoatDongServletDescription", urlPatterns = { "/DAOHoatDongServlet" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The doPost overriding method of ControllerServlet class
	 * This method is called when the database is updated. The views will call it.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("The doPost method is called!");
		PrintWriter out = response.getWriter();
		out.print(ConnectionDB.getConnectDB());
		doGet(request, response);
	}
	
	/**
	 * The doGet overriding method of ControllerServlet class
	 * This method is called when the user click to a link (URL)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("The doGet method is called!");

		String action = request.getServletPath();
		
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
            	insertHoatDong(request, response);
                break;
            case "/delete":
                deleteHoatDong(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateHoatDong(request, response);
                break;
            case "/statistic":
            	statisticHoatDong(request, response);
                break;
            default:
                listHoatDong(request, response);
                break;
            }
        } catch (SQLException ex) {
        	throw new ServletException(ex);
    	} catch (ParseException e) {
    		e.printStackTrace();
		}
    }

    private void statisticHoatDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conn = ConnectionDB.getConnectDB();
		
    	List<StatisticDiemTB> listStatisticDiemTB = HoatDongDAO.StatisticDiemTB(conn);
        request.setAttribute("listStatisticDiemTB", listStatisticDiemTB);
        RequestDispatcher rd = request.getRequestDispatcher("StatisticList.jsp");
    	rd.forward(request, response);
//        response.sendRedirect("statistic"); :Remove
    }

	private void listHoatDong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    		Connection conn = ConnectionDB.getConnectDB();
    		
        	List<HoatDong> listHoatDong = HoatDongDAO.getAllHoatDongs(conn);
            request.setAttribute("listHoatDong", listHoatDong);
            RequestDispatcher rd = request.getRequestDispatcher("HoatDongList.jsp");
        	rd.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dr = request.getRequestDispatcher("HoatDongForm.jsp");
        dr.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionDB.getConnectDB();
		
		request.setCharacterEncoding("UTF-8");
    	int maHD = Integer.parseInt(request.getParameter("maHD"));
        HoatDong existingHoatDong = HoatDongDAO.getMaHoatDong(conn, maHD);
        request.setAttribute("hoatDong", existingHoatDong);
        RequestDispatcher rd = request.getRequestDispatcher("HoatDongForm.jsp");
        rd.forward(request, response);
    }
    
    private void insertHoatDong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	Connection conn = ConnectionDB.getConnectDB();
        
    	request.setCharacterEncoding("UTF-8");
        String tenHD = request.getParameter("tenHD");
    	String moTaHD = request.getParameter("moTaHD");
    	
    	DateTime ngayGioBD = new DateTime(request.getParameter("ngayGioBD"));
    	DateTime ngayGioKT = new DateTime(request.getParameter("ngayGioKT"));
    	
    	int slToiThieuYC = Integer.parseInt(request.getParameter("slToiThieuYC"));
    	int slToiDaYC = Integer.parseInt(request.getParameter("slToiDaYC"));
    	
    	DateTime thoiHanDK = new DateTime(request.getParameter("thoiHanDK"));
    	
    	String trangThai = request.getParameter("trangThai");
    	int maTV = Integer.parseInt(request.getParameter("maTV"));
        HoatDong hoatDong = new HoatDong(tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, trangThai, maTV);
        HoatDongDAO.insertHoatDong(conn, hoatDong);

        response.sendRedirect("list");
    }
    
    private void updateHoatDong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ParseException {
    	Connection conn = ConnectionDB.getConnectDB();
    	
    	request.setCharacterEncoding("UTF-8");
    	int maHD = Integer.parseInt(request.getParameter("maHD"));
    	String tenHD = request.getParameter("tenHD");
    	String moTaHD = request.getParameter("moTaHD");
    	
    	DateTime ngayGioBD = new DateTime(request.getParameter("ngayGioBD"));
    	DateTime ngayGioKT = new DateTime(request.getParameter("ngayGioKT"));
    	
    	int slToiThieuYC = Integer.parseInt(request.getParameter("slToiThieuYC"));
    	int slToiDaYC = Integer.parseInt(request.getParameter("slToiDaYC"));
    	
    	DateTime thoiHanDK = new DateTime(request.getParameter("thoiHanDK"));
    	
    	String trangThai = request.getParameter("trangThai");
    	int maTV = Integer.parseInt(request.getParameter("maTV"));
    	String lyDoHuyDK = request.getParameter("lyDoHuyDK");
    	String action = "update";
    	
        HoatDong hoatDong = new HoatDong(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, trangThai, maTV, lyDoHuyDK, action);
        HoatDongDAO.updateHoatDong(conn, hoatDong);

        response.sendRedirect("list");
    }
    
    private void deleteHoatDong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	Connection conn = ConnectionDB.getConnectDB();
    	
    	request.setCharacterEncoding("UTF-8");
    	int maHD = Integer.parseInt(request.getParameter("maHD"));
 
        HoatDong hoatDong = new HoatDong(maHD);
        HoatDongDAO.deleteHoatDong(conn, hoatDong);
        response.sendRedirect("list");
    }
}
