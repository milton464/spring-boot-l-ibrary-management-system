package com.milton.book.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	@RequestMapping("/admin/uploadBook")
	public String uploadPage(Model model) {
		
		return "upload";
	}
	
	@RequestMapping("/admin/upload")
	public String upload(Model model,@RequestParam("files")MultipartFile[]files) {
		StringBuilder fileName = new StringBuilder();
		for(MultipartFile file:files) {
			Path fileNameandPath = Paths.get(uploadDirectory,file.getOriginalFilename());
			fileName.append(file.getOriginalFilename()+" ");
			try {
				Files.write(fileNameandPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("msg","file uploaded successfully"+fileName.toString());
		return "uploadSuccess";
	}
}
