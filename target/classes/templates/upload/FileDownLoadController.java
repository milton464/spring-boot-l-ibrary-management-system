package com.milton.book.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileDownLoadController {

	String folderPath = "../BookStore/uploads";
	
	@RequestMapping("/show")
	public String showFile(Model model) {
		File folder = new File(folderPath);
		File[]listFiles = folder.listFiles();
		model.addAttribute("listFiles", listFiles);
		return "showFile";
	}
	
	@RequestMapping("/file/{fileName}")
	@ResponseBody
	public void show(@PathVariable("fileName")String fileName,HttpServletResponse response) {
		if(fileName.indexOf(".doc")>-1) response.setContentType("/application/msword");
		if(fileName.indexOf(".docx")>-1) response.setContentType("/application/msword");
		if(fileName.indexOf(".xls")>-1) response.setContentType("/application/vnd.ms-excel");
		if(fileName.indexOf(".csv")>-1) response.setContentType("/application/vnd.ms-excel");
		if(fileName.indexOf(".pdf")>-1) response.setContentType("/application/pdf");
		if(fileName.indexOf(".zip")>-1) response.setContentType("/application/zip");
		if(fileName.indexOf(".ppt")>-1) response.setContentType("/application/ppt");
		
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		response.setHeader("Content-Transfer-Encoding", "Binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(folderPath+fileName);
			int len;
			byte[]buf = new byte[1024];
			while ((len = fis.read(buf))>0) {
				bos.write(buf,0,len);
			}
			bos.close();
			response.flushBuffer();
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
}
