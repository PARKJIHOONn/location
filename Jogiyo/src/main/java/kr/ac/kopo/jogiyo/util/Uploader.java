package kr.ac.kopo.jogiyo.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Uploader {
	final private static String uploadpath = "d://upload/";

	public static boolean upload(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
	         String filename = file.getOriginalFilename();

	         try {
	            file.transferTo(new File(uploadpath + filename));

	        	return true;
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	   
	      } else
	    	  System.out.println("Uploader: file is Empty");
	      	return false;
  }


}
