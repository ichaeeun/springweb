package springweb.z03_vo;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

// springweb.z03_vo.Repository
public class Repository {
	private String content;
	private MultipartFile[] report;
	private ArrayList<FileVo> fileInfo;
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
	public ArrayList<FileVo> getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(ArrayList<FileVo> fileInfo) {
		this.fileInfo = fileInfo;
	}
	
	
}
