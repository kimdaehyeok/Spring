package com.spring.example.fileupload.vo;

import org.springframework.web.multipart.MultipartFile;

public class SingleFileUploadVO 
{
	private String fileName;
	private MultipartFile realFile;
	
	public String getFileName() 
	{
		return fileName;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	public MultipartFile getRealFile() 
	{
		return realFile;
	}
	public void setRealFile(MultipartFile realFile) 
	{
		this.realFile = realFile;
	}
}
