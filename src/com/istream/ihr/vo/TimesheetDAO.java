package com.istream.ihr.vo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.istream.ihr.orm.Employee;
import com.istream.ihr.orm.TimeSheet;
import com.istream.ihr.orm.TimeSheetTaskAs;

 
@Repository
public class TimesheetDAO {
 

private SessionFactory sessionFactory;
 
public SessionFactory getSessionFactory() {
return sessionFactory;
}
 
@Autowired
public void setSessionFactory(SessionFactory sessionFactory) {
this.sessionFactory = sessionFactory;
}
 
public void saveEmployee(Employee person) {
Session session = getSessionFactory().openSession();
session.saveOrUpdate(person);

}
 
public List<Employee> selectAll() {
Session session = getSessionFactory().openSession();
Criteria criteria = session.createCriteria(Employee.class);
List<Employee> persons = (List<Employee>) criteria.list();
return persons;
}
 
	public List<Employee> searchEmployee(String name, String client) {
	Session session = getSessionFactory().openSession();
	List<Employee> persons= null;
	
	if(client!=null && !"".equals(client.trim())){
		
		String hql = "from Employee e where e.employeeId  in " + 
                "(select ec.employee.employeeId from EmpClientAs ec where ec.client.clientId  in"+
				"(select c.clientId from Client c where c.name like  :searchKey "+ "))";
		
		Query q = session.createQuery(hql);
		if(name!=null && !"".equals(name.trim())){
			hql += " and (e.firstName like :searchName  or e.lastName like :searchName )";
			
			q.setParameter("searchName", "%"+name+"%");
		}
		
		q.setParameter("searchKey", "%"+client+"%");
		
        persons = q.list(); 
		
	} else
	{
		Criteria criteria = session.createCriteria(Employee.class);
		if(name!=null && !"".equals(name.trim())){
			Criterion  Cr1=Restrictions.like("firstName", "%"+name+"%");
			Criterion  Cr2=Restrictions.like("lastName", "%"+name+"%");
			criteria.add(Restrictions.or(Cr1,Cr2));
		}
		persons = (List<Employee>) criteria.list();
	}
	return persons;
	}

	public void saveTimeSheet(TimeSheet timeSheet) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(timeSheet);
		for (TimeSheetTaskAs timeSheetTaskAs : timeSheet.getTimeSheetTaskAses()) {
			session.saveOrUpdate(timeSheetTaskAs);
		}
		session.getTransaction().commit();
		session.close();
	}
}
