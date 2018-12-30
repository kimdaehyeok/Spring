<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 출력</title>
</head>
<body>
	<h2>UserInfo - UserVo</h2>
	<form>
		<table border="1">
			<tr>
				<td>이름</td>
				<td>${userVo.userName}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${userVo.address}</td>
			</tr>
		</table>
		<input type="submit" name="submit" value="뷰" />
	</form>
	
	<h2>UserInfo - Method ModelAttribute</h2>
	<form>
		<table border="1">
			<tr>
				<td>이름</td>
				<td>${methodModelAttribute.userName}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${methodModelAttribute.address}</td>
			</tr>
		</table>
		<input type="submit" name="submit" value="뷰" />
	</form>

	<h2>UserInfo - Parameter ModelAttribute</h2>
	<form>
		<table border="1">
			<tr>
				<td>이름</td>
				<td>${parameterModelAttribute.userName}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${parameterModelAttribute.address}</td>
			</tr>
		</table>
		<input type="submit" name="submit" value="뷰" />
	</form>
</body>
</html>

