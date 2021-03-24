package springweb.a01_start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		// Repository 에 name="content"와 name="report"배열을 
		// 받을 수 있는 property 선언 
		service.insertFile(rep);
		return "WEB-INF/views/a01_start/a15_fileExp.jsp";
	}
	// ex) 업로드된 파일 리스트 fileList.do 
	// http://localhost:8080/springweb/fileList.do 
	@RequestMapping("fileList.do")
	public String fileList(Model d) {
		d.addAttribute("flist",service.fileList());
		return "WEB-INF/views/a01_start/a16_fileList.jsp";
	}
	// ex) 파일 다운 처리 	fileDown.do 
	// http://localhost:8080/springweb/fileDown.do 
	@RequestMapping("fileDown.do")
	public String fileDown(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadFile",fname);
		return "downloadviewer";
	}
}







