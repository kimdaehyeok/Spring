package com.spring.example.fileupload.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.example.fileupload.vo.MultipleFileUploadVO;

@Service
public class MultipleFileUploadModelAttributeService 
{
	public void saveMultipleFileUpload(MultipleFileUploadVO multipleFileUploadVO, HttpSession httpSession) throws IOException
	{
		String filePath = httpSession.getServletContext().getRealPath("/") + "MultipleFile/";
		String fileName1 = multipleFileUploadVO.getFileName1();
		String fileName2 = multipleFileUploadVO.getFileName2();
		
		MultipartFile file1 = multipleFileUploadVO.getRealFile1();
		MultipartFile file2 = multipleFileUploadVO.getRealFile2();
		
		System.out.println("File Path 1 : " + filePath + fileName1);
		System.out.println("File Path 2 : " + filePath + fileName2);
		
  
		saveFile(filePath, file1, fileName1);
		saveFile(filePath, file2, fileName2);
	}
	
	public void saveFile(String filePath, MultipartFile file, String fileName) throws IOException
	{
		byte fileByteArray[] = file.getBytes();  
        
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + fileName));  
        
        bout.write(fileByteArray);  
        bout.flush();  
        bout.close();
	}
}
