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
import com.xworkz.springmvc.bean.SportBean;

@Component
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
			Query query = session.getNamedQuery("SportBean.searchBySportName");
			query.setParameter("sportName", sportName);

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
			Query query = session.getNamedQuery("SportBean.deleteBysportName").setParameter("sportName", sportName);
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
}
