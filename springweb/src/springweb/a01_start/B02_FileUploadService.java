package springweb.a01_start;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springweb.a02_mvc.a03_dao.Z01_ExpDao;
import springweb.z03_vo.FileVo;
import springweb.z03_vo.Repository;

@Service
public class B02_FileUploadService {
	@Value("${upload}")
	private String upload;
	@Value("${uploadTmp}")
	private String uploadTmp;
	
	@Autowired(required=false)
	private Z01_ExpDao dao;
	
	public void insertFile(Repository rep) {
		
		System.out.println("##파일명##");
		System.out.println(rep.getReport()[0].getOriginalFilename());
		System.out.println("upload: "+upload);
		System.out.println("uploadTmp: "+uploadTmp);
		// 파일 업로드 처리 
		String fname = null;
		File tmpFile =null;
		File orgFile = null;
		System.out.println("파일갯수: "+rep.getReport().length);
		// 임시파일 객체 
		File pathFile = new File(uploadTmp);
		for(File f:pathFile.listFiles()) {
			System.out.println("삭제할 파일: "+f.getName());
			f.delete();
		}
		
		for(MultipartFile mpf:rep.getReport()) {
			fname = mpf.getOriginalFilename();
			if(fname!=null&& !fname.trim().equals("")) {
				tmpFile = new File(uploadTmp+fname);
				try {
					mpf.transferTo(tmpFile);
					orgFile = new File(upload+fname);
					Files.copy(tmpFile.toPath(), orgFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
					dao.insertFile(new FileVo(rep.getContent(),fname));
					
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
	}
	
	public ArrayList<FileVo> fileList(){
		return dao.fileList();
	}
}
