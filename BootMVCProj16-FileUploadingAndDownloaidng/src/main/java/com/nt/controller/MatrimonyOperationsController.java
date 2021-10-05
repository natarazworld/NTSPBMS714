package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.model.MarriageSeeker;
import com.nt.service.IMatrimonyMgmtService;

@Controller
public class MatrimonyOperationsController {
	@Autowired
   private IMatrimonyMgmtService   service;
	@Autowired
	private Environment  env;
	
	@GetMapping("/")
	public  String  showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String   showProfileFormPage(@ModelAttribute("profile") MarriageSeeker seeker) {
		 return "marriage_seeker_register";
	}
	
	@PostMapping("/register")
	public  String    performFileUpload(@ModelAttribute("profile")MarriageSeeker seeker, Map<String,Object> map)throws Exception {
  	//get Folder location to store uploaded files
		String  location=env.getProperty("upload.store");
		File    locationStore=new File(location);
		//create location folder if is not already avaiable
		if(!locationStore.exists())
			   locationStore.mkdir();
		//get the oginal names of the uploading files
		MultipartFile resumeFile=seeker.getResume();
		MultipartFile photoFile=seeker.getPhoto();
		String resumeFileName=resumeFile.getOriginalFilename();
		String  photoFileName=photoFile.getOriginalFilename();
		//Create InputStreams representing the Uploaded files
		InputStream resumeIStream=resumeFile.getInputStream();
		InputStream photoIStream=photoFile.getInputStream();
		//create OutputStreams pointing destionation file on the server machine file system
		OutputStream resumeOStream=new FileOutputStream(location+"/"+resumeFileName);
		OutputStream photoOStream=new FileOutputStream(location+"/"+photoFileName);
		//complete operaton among the streams
		IOUtils.copy(resumeIStream, resumeOStream);
		IOUtils.copy(photoIStream, photoOStream);
		//close streams
		resumeIStream.close(); resumeOStream.close();
		photoIStream.close(); photoOStream.close();
		//create Entity class object
		MarriageSeekerInfo info=new MarriageSeekerInfo();
		info.setProfileName(seeker.getProfileName());
		info.setGender(seeker.getGender());
		info.setResumePath(location+"/"+resumeFileName);
		info.setPhotoPath(location+"/"+photoFileName);
		//  use service
		   String msg=service.registerProfile(info);
		 //create model attributes
		   map.put("resumeFile",resumeFileName);
		   map.put("photoFile",photoFileName);
		   map.put("resultMsg",msg);
      
		   //return LVN
		   return "show_result";
	}
	
	
	@GetMapping("/display")
	public   String   displayProfiles(Map<String,Object> map) {
		Iterable<MarriageSeekerInfo> seekersList=service.getAllProfiles();
		map.put("seekersInfo",seekersList);
		//return LVN
		return  "show_profiles";
	}

	@Autowired
	private ServletContext sc;
	@GetMapping("/download")
	public   String  fileDownload(@RequestParam("file") String filePath,
			                                                 HttpServletResponse res)throws Exception{
		//create java.io.File object pointing to the file to download
		File file=new File(filePath);
		//get the length of the file and make it as the response content  length
		res.setContentLengthLong(file.length());
		//get the MIME of the file to be downloaded and make it as the response content  type
		String mimeType=sc.getMimeType(filePath);
		mimeType=mimeType!=null?mimeType:"application/octet-stream";
		res.setContentType(mimeType);
		//create InputStream pointing to the file to be downloaded
		InputStream is=new FileInputStream(filePath);
		//create OutputStream pointing to the response object
		OutputStream os=res.getOutputStream();
		//give instruction to browser to make the recieved content as the downloadable file
		res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		// copy file to be download content to response object
		 IOUtils.copy(is, os);
		 //close streams
		 is.close();
		 os.close();
		return null;  // This indicates response should go to browser directly 
		                         //with out taking the support of  ViewResolver and View comps.
	}
	
	
}
