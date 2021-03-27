<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QUẢN LÝ CÁC HOẠT ĐỘNG THIỆN NGUYỆN</title>
</head>
<body>
	 <center>
        <h1>QUẢN LÝ HOẠT ĐỘNG THIỆN NGUYỆN</h1>
        <h2>
            <a href="/QLHD_ThienNguyen/new">Thêm một hoạt động</a> &nbsp; &nbsp; &nbsp;
			<a href="/QLHD_ThienNguyen/list">Danh sách hoạt động thiện nguyện</a>  &nbsp; &nbsp; &nbsp;
			<a href="/QLHD_ThienNguyen/statistic">Thống kê điểm trung bình của các trưởng đoàn</a>
        </h2>
    </center>
    
    <div align="center">
    	<c:if test="${hoatDong != null}">
    		<form action="update" method="post">
    	</c:if>
    	<c:if test="${hoatDong == null}">
            <form action="insert" method="post">
        </c:if>
	        <table border="1" cellpadding="5">
	            <caption>
	            	<h2>
	                    <c:if test="${hoatDong != null}">Chỉnh sửa hoạt động</c:if>
	                    <c:if test="${hoatDong == null}">Thêm hoạt động</c:if>
                    </h2>
	            </caption>		
	                <c:if test="${hoatDong != null}">
	                    <input type="hidden" name="maHD" value="<c:out value='${hoatDong.maHD}'/>"/>
	                </c:if>
	            <tr>
	                <th align="left">Tên: </th>
	                <td>
	                	<input type="text" name="tenHD" maxlength="500" size="45" value="<c:out value="${hoatDong.tenHD}"/>"/>
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Mô tả: </th>
	                <td>
	                    <input type="text" name="moTaHD" size="45" value="<c:out value="${hoatDong.moTaHD}"/>"/>
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Ngày giờ bắt đầu:</th>
	                <td>
                		<input type="datetime-local" name="ngayGioBD" value="<c:out value="${hoatDong.ngayGioBD.getDateTimeRequest()}"/>" />
	                </td>
	            </tr>
	            	            <tr>
	                <th align="left">Ngày giờ kết thúc:</th>
	                <td>
	                	<input type="datetime-local" name="ngayGioKT" value="<c:out value="${hoatDong.ngayGioKT.getDateTimeRequest()}"/>" />
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Số lượng tối thiểu: </th>
	                <td>
	                    <input min='0' type="number" name="slToiThieuYC" size="4" value="<c:out value="${hoatDong.slToiThieuYC}"/>"onkeypress="return (event.charCode == 8 || event.charCode == 0) ? null : event.charCode >= 48 && event.charCode <= 57"/>
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Số lượng tối đa: </th>
	                <td>
	                    <input min='0' type="number" name="slToiDaYC" size="4" value="<c:out value="${hoatDong.slToiDaYC}"/>"onkeypress="return (event.charCode == 8 || event.charCode == 0) ? null : event.charCode >= 48 && event.charCode <= 57"/>
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Thời hạn đăng ký:</th>
	                <td>
                		<input type="datetime-local" name="thoiHanDK" value="<c:out value="${hoatDong.thoiHanDK.getDateTimeRequest()}"/>" />
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Trạng thái: </th>
	                <td>
	                	<c:if test="${hoatDong == null}">
	                		<select name="trangThai">
		                    	<option value="0" selected="selected">Đang mời đăng ký</option>
		                    	<option value="1">Đã hết hạn đăng ký</option>
		                    	<option value="2">Trưởng đoàn tự hủy</option>
		                    	<option value="3">Đã kết thúc</option>
	                    	</select>
						</c:if>
	                    <c:if test="${hoatDong != null}">
	                    	
	                     	<select name="trangThai">
	                     		<c:choose>
		                    		<c:when test="${hoatDong.trangThai eq '1'}">
		                    			<option value="0">Đang mời đăng ký</option>
		                    			<option value="1" selected="selected">Đã hết hạn đăng ký</option>
				                    	<option value="2">Trưởng đoàn tự hủy</option>
				                    	<option value="3">Đã kết thúc</option>
		                    		</c:when>
		                    		<c:when test="${hoatDong.trangThai eq '2'}">
		                    			<option value="0">Đang mời đăng ký</option>
		                    			<option value="1">Đã hết hạn đăng ký</option>
				                    	<option value="2" selected="selected">Trưởng đoàn tự hủy</option>
				                    	<option value="3">Đã kết thúc</option>
		                    		</c:when>
		                    		<c:when test="${hoatDong.trangThai eq '3'}">
		                    			<option value="0">Đang mời đăng ký</option>
		                    			<option value="1">Đã hết hạn đăng ký</option>
				                    	<option value="2">Trưởng đoàn tự hủy</option>
				                    	<option value="3" selected="selected">Đã kết thúc</option>
		                    		</c:when>
		                    		<c:otherwise>
		                    			<option value="0" selected="selected">Đang mời đăng ký</option>
		                    			<option value="1">Đã hết hạn đăng ký</option>
				                    	<option value="2">Trưởng đoàn tự hủy</option>
				                    	<option value="3">Đã kết thúc</option>
		                    		</c:otherwise>
	                    		</c:choose>
		                    	
	                    	</select>
	                    </c:if>
	                </td>
	            </tr>
	            <tr>
	                <th align="left">Mã thành viên: </th>
	                <td>
	                    <input min="1000" max="1002" type="number" name="maTV" maxlength="4"  width="4" size="4" value="<c:out value="${hoatDong.maTV}"/>" onkeypress="return (event.charCode == 8 || event.charCode == 0) ? null : event.charCode >= 48 && event.charCode <= 57"/>
	                </td>
	            </tr>
	            <c:if test="${hoatDong != null}">
	            	<tr>
		                <th align="left">Lý do hủy đăng ký: </th>
		                <td>
		                    <input type="text" name="lyDoHuyDK" size="45" value="<c:out value="${hoatDong.lyDoHuyDK}"/>"/>
		                </td>
	            	</tr>
				</c:if>
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="Save" />
	                </td>
	            </tr> 
	        </table>
        </form>
    </div>
</body>
</html>