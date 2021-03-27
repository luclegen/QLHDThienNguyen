<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>QUẢN LÝ CÁC HOẠT ĐỘNG THIỆN NGUYỆN</title>
</head>
<body>
	<center>
		<h1>QUẢN LÝ CÁC HOẠT ĐỘNG THIỆN NGUYỆN</h1>
		<h2>
			<a href="/QLHD_ThienNguyen/new">Thêm một hoạt động</a> &nbsp; &nbsp; &nbsp;
			<a href="/QLHD_ThienNguyen/list">Danh sách hoạt động thiện nguyện</a>  &nbsp; &nbsp; &nbsp;
			<a href="/QLHD_ThienNguyen/statistic">Thống kê điểm trung bình của các trưởng đoàn</a>
		</h2>
	</center>
	
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Danh sách hoạt động thiện nguyện</h2></caption>
            <tr>
                <th>Mã hoạt động</th>
                <th>Tên</th>
                <th>Mô tả</th>
                <th>Ngày giờ bắt đầu</th>
                <th>Ngày giờ kết thúc</th>
                <th>Số lượng tối thiểu</th>
                <th>Số lượng tối đa</th>
                <th>Thời hạn đăng ký</th>
                <th>Trạng thái</th>
                <th>Mã thành viên</th>
<!--                 <th>Lý do hủy đăng ký</th> -->
                <th>Actions</th>
            </tr>
          
            <c:forEach var="hoatDong" items="${listHoatDong}">
                <tr>
                    <td align="center"><c:out value="${hoatDong.maHD}"></c:out></td>
                    <td><c:out value="${hoatDong.tenHD}"></c:out></td>
                    <td><c:out value="${hoatDong.moTaHD}"></c:out></td>
                    
                    <td><c:out value="${hoatDong.ngayGioBD.getDateTime()}"></c:out></td>
                    <td><c:out value="${hoatDong.ngayGioKT.getDateTime()}"></c:out></td>
                    
                    <td align="right"><c:out value="${hoatDong.slToiThieuYC}"></c:out></td>
                    <td align="right"><c:out value="${hoatDong.slToiDaYC}"></c:out></td>
                    
                    <td><c:out value="${hoatDong.thoiHanDK.getDateTime()}"></c:out></td>
                    
                    <td><c:out value="${hoatDong.trangThai}"></c:out></td>
                    <td align="center"><c:out value="${hoatDong.maTV}"></c:out></td>
<%--                     <td><c:out value="${hoatDong.lyDoHuyDK}"></c:out></td> --%>
                    <td>
                        <a href="edit?maHD=<c:out value="${hoatDong.maHD}"/>">Edit</a> <!--"/edit?id=" is Specifies the URL for the link: Phần chỉ rõ của URL -->
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?maHD=<c:out value="${hoatDong.maHD}" />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>