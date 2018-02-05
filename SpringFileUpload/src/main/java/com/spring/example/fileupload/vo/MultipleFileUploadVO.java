package com.spring.example.fileupload.vo;

import org.springframework.web.multipart.MultipartFile;

public class MultipleFileUploadVO 
{
	private String fileName1;
	private MultipartFile realFile1;
	
	private String fileName2;
	private MultipartFile realFile2;
	
	public String getFileName1() 
	{
		return fileName1;
	}
	public void setFileName1(String fileName1)
	{
		this.fileName1 = fileName1;
	}
	public MultipartFile getRealFile1() 
	{
		return realFile1;
	}
	public void setRealFile1(MultipartFile realFile1) 
	{
		this.realFile1 = realFile1;
	}
	public String getFileName2() 
	{
		return fileName2;
	}
	public void setFileName2(String fileName2)
	{
		this.fileName2 = fileName2;
	}
	public MultipartFile getRealFile2() 
	{
		return realFile2;
	}
	public void setRealFile2(MultipartFile realFile2) 
	{
		this.realFile2 = realFile2;
	}
}
