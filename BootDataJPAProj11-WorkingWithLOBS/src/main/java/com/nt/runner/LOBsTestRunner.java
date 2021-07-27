package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonySerivceMgmt;

@Component
public class LOBsTestRunner implements CommandLineRunner {
	@Autowired
	private IMatrimonySerivceMgmt service;

	@Override
	public void run(String... args) throws Exception {
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter person name::");
		String name=sc.next();
		System.out.println("Enter person address::");
		String addrs=sc.next();
		System.out.println("Enter Person Photo file complete path::");
		String photoPath=sc.next().replace("?","");
		System.out.println("Enter Person biodata file complete path::");
		String biodataPath=sc.next().replace("?","");
		System.out.println("Is the Person Indian? ");
		boolean indian=sc.nextBoolean();
		//prepare  byte[] representing photo file content
		InputStream is=new FileInputStream(photoPath);
		byte[] photoData=new byte[is.available()];
		photoData=is.readAllBytes();
		//prepare  char[] representing biddata file content
		File file=new File(biodataPath);
		Reader reader=new FileReader(file);
		char bioDataContent[]=new char[(int) file.length()];
		reader.read(bioDataContent);
		
		//prepare Entity class obj
		 MarriageSeeker seeker=new MarriageSeeker(name, addrs,photoData ,
				                                                                                    LocalDateTime.of(1990,11,23,12,45),
				                                                                                   bioDataContent , indian);
		 System.out.println(service.registerMarriageSeeker(seeker));*/
		System.out.println("=============================");
		Optional<MarriageSeeker> opt=service.searchSeekerById(4L);
		if(opt.isPresent()) {
			MarriageSeeker seeker=opt.get();
			System.out.println(seeker.getId()+"  "+seeker.getName()+"  "+seeker.getAddrs()+" "+seeker.isIndian());
			OutputStream os=new FileOutputStream("retrieve_photo.gfif");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer=new FileWriter("retrieve_biodata.txt");
			writer.write(seeker.getBiodata());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("LOBs are retrieved");
		}
		else {
			System.out.println("Records not found");
		}
		

	}

}
