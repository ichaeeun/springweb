package springweb.z03_vo;

import org.springframework.web.multipart.MultipartFile;

// springweb.z03_vo.Repository
public class Repository {
	private String content;
	private MultipartFile[] report;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile[] getReport() {
		return report;
	}
	public void setReport(MultipartFile[] report) {
		this.report = report;
	}
	
	
}
