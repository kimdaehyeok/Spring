package com.spring.example.fileupload.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.example.fileupload.vo.MultipleFileUploadVO;

@Service
public class MultipartHttpServletRequestService 
{
	public void saveFile(MultipartFile file, String fileName, HttpSession httpSession) throws IOException
	{
		String filePath = httpSession.getServletContext().getRealPath("/") + "MultipartHttpServletRequestFile/";
		
		byte fileByteArray[] = file.getBytes();  
        
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + fileName));  
        
        bout.write(fileByteArray);  
        bout.flush();  
        bout.close();
	}
}
