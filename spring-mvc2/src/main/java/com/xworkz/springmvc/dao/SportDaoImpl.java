package com.xworkz.springmvc.dao;

import java.util.List;
import javax.persistence.RollbackException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.springmvc.bean.SportBean;

@Repository
public class SportDaoImpl implements SportDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SportDaoImpl() {
		System.out.println(getClass().getSimpleName() + " bean created");
	}

	public boolean saveSessionFactory(SportBean sportBean) {
		System.out.println("saveSessionFactory(SportBean sportBean) started \n");
		boolean flag = false;
		Session session = sessionFactory.openSession();
		try {

			Transaction transaction = session.beginTransaction();
			session.save(sportBean);
			transaction.commit();

		} catch (RollbackException r) {
			System.out.println(r.getMessage());
		} catch (HibernateException h) {
			System.out.println(h.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {

				session.close();
				System.out.println("Session is closed \n");
				flag = true;
			} else {
				System.out.println("Session is not closed \n");
				flag = false;
			}

		}
		System.out.println("saveSessionFactory(SportBean sportBean) ended \n");

		return flag;
	}

	public SportBean searchBySportName(String sportName) {
		System.out.println("searchBySportName(String sportName) started ");
		Session session = null;
		SportBean sportBeanDaoImpl = null;
		try {

			session = sessionFactory.openSession();
//			int inputnumber = Integer.parseInt(sportName);
			Query query = session.getNamedQuery("SportBean.searchBySportName");
			query.setParameter("inputname", sportName);

			Object object = query.uniqueResult();
			sportBeanDaoImpl = (SportBean) object;

			System.out.println("existing row data are : \n" + sportBeanDaoImpl);
			if (sportBeanDaoImpl != null) {
				return sportBeanDaoImpl;
			} else {
				System.out.println("else block opend because sportBeanDaoImpl is null");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {

				System.out.println("Session is Not closed");
			}
		}
		System.out.println("searchBySportName(String sportName) ended ");
		return sportBeanDaoImpl;
	}

	public List<Object> getAllSportDataDaoImpl() {

		System.out.println("getAllSportDataDaoImpl() started");
		Session session = null;
		List<Object> listBean = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("SportBean.getAllSportDataDaoImpl");
			listBean = query.list();

		} catch (RollbackException r) {
			System.out.println(r.getMessage());
		} catch (HibernateException h) {
			System.out.println(h.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {

				session.close();
				System.out.println("Session is closed \n");

			} else {
				System.out.println("Session is not closed \n");
			}
		}

		System.out.println("getAllSportDataDaoImpl() ended");
		return listBean;

	}

	public Boolean deleteSportBeanBySportName(String sportName) {

		System.out.println("deleteSportBeanBySportName(String sportName)    started in DaoImpl");
		Session session = null;
		Boolean isBeanDeleted = false;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("SportBean.deleteBysportName").setParameter("inputname", sportName);
			int number = query.executeUpdate();
			System.out.println("\n sportBean is deleted  " + number + " row");
			transaction.commit();

			if (number > 0) {
				isBeanDeleted = true;
				System.out.println("Bean is  deleted successfully");
			} else {

				System.out.println("Bean not deleted at all");
			}
		} catch (RollbackException r) {
			System.out.println(r.getMessage());
		} catch (HibernateException h) {
			System.out.println(h.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed \n");

			} else {
				System.out.println("Session is not closed \n");
			}
		}
		System.out.println("deleteSportBeanBySportName(String sportName)    ended in DaoImpl  ");
		return isBeanDeleted;
	}

	public boolean updateSportBeanDao(SportBean sportBean) {
		System.out.println("updateSportBeanDao(SportBean sportBean) started");

		Session session = null;
		Boolean isUpdated = false;
		try {
			System.out.println("sportBean holds data in updateSportBeanDao method" + sportBean);
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("SportBean.updateSportBeanDao");

//			To Re-assign the data From UI Inputs 
			
			query.setParameter("SPORTNAME", sportBean.getSportName())
					.setParameter("NOOFPLAYRES", sportBean.getNoOfPlayers())
					.setParameter("CAPTAINNAME", sportBean.getCaptainName())
					.setParameter("SPORTCOACH", sportBean.getSportCoach())
					.setParameter("SHEDULEDDATE", sportBean.getSheduledDate());

//			TO Update the Query based on Where conditions

			query.setParameter("inputname", sportBean.getSportName())
					.setParameter("inputname", sportBean.getCaptainName())
					.setParameter("inputname", sportBean.getSportCoach())
					.setParameter("inputname", sportBean.getSheduledDate());

			int num = query.executeUpdate();
			transaction.commit();
			if (num > 0) {
				System.out.println("SportBean is updated successfully");
				isUpdated = true;
			} else {
				System.out.println("SportBean is Not updated ");
			}

		} catch (RollbackException r) {
			System.out.println(r.getMessage());
		} catch (HibernateException h) {
			System.out.println(h.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed \n");

			} else {
				System.out.println("Session is not closed \n");
			}
		}

		System.out.println("updateSportBeanDao(SportBean sportBean) ended");
		return isUpdated;
	}
}
