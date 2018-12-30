<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<title>Image File Upload</title>
</head>
<body>
	<h1>Single File ModelAttribute Upload Example</h1>

	<form method="post" action="/SpringFileUpload/singleFileModelAttributeUpload.do" enctype="multipart/form-data">
		<p>
			<label for="image">Choose Image</label>
		</p>
		<p>
			<input name="fileName" type="text" />
		</p>
		<p>
			<input name="realFile" type="file" />
		</p>
		<p>
			<input type="submit" value="Upload">
		</p>
	</form>
</body>
</html>