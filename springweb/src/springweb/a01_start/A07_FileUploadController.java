package springweb.a01_start;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import springweb.z03_vo.Repository;

@Controller
public class A07_FileUploadController {
	
	@Value("${upload}")
	private String upload;
	@Value("${uploadTmp}")
	private String uploadTmp;
	
	// http://localhost:8080/springweb/fileExp.do 
	@GetMapping("fileExp.do")
	public String fileExp() {
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	
	@PostMapping("fileExp.do")
	public String fileExp1(Repository rep) {
		// 파일 확인 
		System.out.println("upload: "+upload);
		System.out.println("uploadTmp: "+uploadTmp);
		// 파일 업로드 처리 
		String fname = null;
		File tmpFile =null;
		File orgFile = null;
		
		for(MultipartFile mpf:rep.getReport()) {
			fname = mpf.getOriginalFilename();
			if(fname!=null&& !fname.trim().equals("")) {
				tmpFile = new File(uploadTmp+fname);
				try {
					mpf.transferTo(tmpFile);
					orgFile = new File(upload+fname);
					Files.copy(tmpFile.toPath(), orgFile.toPath());
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("파일 등록에러: "+e.getMessage());
					e.printStackTrace();
				}catch(Exception e) {
					System.out.println("일반에러: "+e.getMessage());
				}
				
			}
		}
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	
}
