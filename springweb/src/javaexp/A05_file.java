package javaexp;

import java.io.File;

public class A05_file {
	public static void main(String[] args) {
		try {
			String orpath = "/Users/ichaeeun/git/springweb/springweb/src/javaexp";
			String mkDir = "/z02_test";
			boolean b = new File(orpath+mkDir).mkdir(); // 디렉토리 생성 
			String path = orpath+mkDir;
			for(int cnt =1;cnt<10;cnt++) {
				File f = new File(path,"z"+cnt+"_test.txt");
				f.createNewFile();
				System.out.println(f.getName());
				System.out.println(f.exists());
				System.out.println(f.getPath());
				System.out.println(f.length());
			}
			System.out.println(File.separator);
			boolean b2 = new File(path,"z1_test.txt").delete();
			String[] listing = new File(path).list();
			for(String str:listing) {
				System.out.println(str);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
