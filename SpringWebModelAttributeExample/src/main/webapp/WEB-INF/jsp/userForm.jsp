<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 입력</title>
</head>
<body>
	<h2>UserInfo Get Method</h2>
	<form action="userInfoGet.do" method="GET">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"
					value="${userVo.userName}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${userVo.address}" /></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="전송" />
	</form>
	
	<h2>UserInfo Post Method</h2>
	<form action="userInfoPost.do" method="Post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"
					value="${userVo.userName}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${userVo.address}" /></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="전송" />
	</form>
</body>
</html>

