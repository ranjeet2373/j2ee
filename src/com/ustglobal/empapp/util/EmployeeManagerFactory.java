package com.ustglobal.empapp.util;

import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dao.EmployeeDao;

public class EmployeeManagerFactory {
	
	private EmployeeManagerFactory() {}
	
	public static EmployeeDao getEmployeeDAO() {
		
		return new EmployeeDAOImpl();
		
	}

}
