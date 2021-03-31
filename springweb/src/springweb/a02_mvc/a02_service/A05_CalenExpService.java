package springweb.a02_mvc.a02_service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a02_mvc.a03_dao.A05_CalenExpDao;
import springweb.z02_vo.Calendar;

@Service
public class A05_CalenExpService {
	@Autowired(required=false)
	private A05_CalenExpDao dao;
	
	public ArrayList<Calendar> calenListExp(){
		return dao.calenListExp();
	}
}
