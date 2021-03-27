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
		<h2>Thống kê điểm trung bình (do các thành viên khác đánh giá) của các trưởng đoàn</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Mã thành viên</th>
                <th>Họ tên thành viên</th>
                <th>Đánh giá</th>
            </tr>
          
            <c:forEach var="statisticDiemTB" items="${listStatisticDiemTB}">
                <tr>
                    <td align="center"><c:out value="${statisticDiemTB.maTV}"></c:out></td>
                    <td><c:out value="${statisticDiemTB.hoTenTV}"></c:out></td>
                    <td><c:out value="${statisticDiemTB.diemTB}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>