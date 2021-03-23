package springweb.a01_start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springweb.z03_vo.Repository;

@Controller
public class A07_FileUploadController {
	
	@Autowired(required=false)
	private B02_FileUploadService service;
	
	// http://localhost:8080/springweb/fileExp.do 
	@GetMapping("fileExp.do")
	public String fileExp() {
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	
	@PostMapping("fileExp.do")
	public String fileExp1(Repository rep) {
		service.insertFile(rep);
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	
}
