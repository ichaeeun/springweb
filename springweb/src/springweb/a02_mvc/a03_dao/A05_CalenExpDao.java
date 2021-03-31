package springweb.a02_mvc.a03_dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import springweb.z02_vo.Calendar;

@Repository
public interface A05_CalenExpDao {
	// springweb.a02_mvc.a03_dao.A05_CalenExpDao
	public ArrayList<Calendar> calenListExp();
}
