package com.istream.ihr.vo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.istream.ihr.orm.Employee;
import com.istream.ihr.orm.Project;
import com.istream.ihr.orm.TimeSheet;
import com.istream.ihr.util.DAOUtil;

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
		List<Employee> persons = null;

		if (client != null && !"".equals(client.trim())) {

			String hql = "from Employee e where e.employeeId  in "
					+ "(select ec.employee.employeeId from EmpClientAs ec where ec.client.clientId  in"
					+ "(select c.clientId from Client c where c.name like  :searchKey " + "))";

			Query q = session.createQuery(hql);
			if (name != null && !"".equals(name.trim())) {
				hql += " and (e.firstName like :searchName  or e.lastName like :searchName )";

				q.setParameter("searchName", "%" + name + "%");
			}

			q.setParameter("searchKey", "%" + client + "%");

			persons = q.list();

		} else {
			Criteria criteria = session.createCriteria(Employee.class);
			if (name != null && !"".equals(name.trim())) {
				Criterion Cr1 = Restrictions.like("firstName", "%" + name + "%");
				Criterion Cr2 = Restrictions.like("lastName", "%" + name + "%");
				criteria.add(Restrictions.or(Cr1, Cr2));
			}
			persons = (List<Employee>) criteria.list();
		}
		return persons;
	}

	public void saveTimeSheet(TimeSheet timeSheet) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(timeSheet);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<TimeSheet> getTimeSheets(Long employeeId, Integer month,  Integer year) {
		Session session = getSessionFactory().openSession();
		String hql = "SELECT time_sheet.Time_sheet_id, " +
			    "time_sheet.Time_sheet_date, " +
			    "time_sheet.Billed_Hours, " +
			    "time_sheet.Non_Billed_Hours, " +
			    "time_sheet.Note, " +
			    "time_sheet.Employee_id, " +
			    "time_sheet.Status, " +
			    "time_sheet.project_id, " +
			    "time_sheet.Creation_ts, " +
			    "time_sheet.Last_update_ts, " +
			    "time_sheet.Description" +
			" FROM ihr.time_sheet time_sheet" +
			" WHERE month(Time_sheet_date) = :month " +
			         " AND YEAR(Time_sheet_date) = :year " +
			         " AND Employee_id = :employeeId";
		Query q = session.createSQLQuery(hql)
				.setParameter("month", month)
				.setParameter("year", year)
				.setParameter("employeeId", employeeId);
		
		List<Object> resultList = q.list();
		
		List<TimeSheet> timeSheets = null;	        
	        if (resultList.size() > 0) {
	        	timeSheets = new LinkedList<TimeSheet>();
	            ListIterator<Object> resultListIterator = (ListIterator<Object>) resultList.listIterator();
	            while(resultListIterator.hasNext()) {
	                Object[] row = (Object[]) resultListIterator.next();
	                TimeSheet timeSheet = new TimeSheet();
	                timeSheet.setTimeSheetId(DAOUtil.getInteger(row[0]));
	                timeSheet.setTimeSheetDate(DAOUtil.getDateFromSqlDate(row[1]));
	                timeSheet.setBilledHours(DAOUtil.getInteger(row[2]));
	                timeSheet.setNonBilledHours(DAOUtil.getInteger(row[3]));
	                timeSheet.setNote(DAOUtil.getString(row[4]));
	                Employee e = new Employee();
	                e.setEmployeeId(DAOUtil.getInteger(row[5]));
	                timeSheet.setEmployee(e);
	                timeSheet.setStatus(DAOUtil.getString(row[6]));
	                Project project = new Project();
	                project.setProjectId(DAOUtil.getInteger(row[7]));
	                timeSheet.setProject(project);
	                timeSheet.setTimeSheetDate(DAOUtil.getDate(row[8]));
	                timeSheet.setTimeSheetDate(DAOUtil.getDate(row[9]));
	                timeSheet.setDescription(DAOUtil.getString(row[10]));
	                timeSheets.add(timeSheet);
	                
	            }
	        }
	        return timeSheets;
		
	}
}
