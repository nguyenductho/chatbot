package vn.mobifone.mvas.chatbot.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import vn.mobifone.mvas.chatbot.entity.BriefInfo;

public class BriefInfoManager {

	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public BriefInfo create(BriefInfo briefInfo) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(briefInfo);
		session.getTransaction().commit();
		session.close();
		System.out.println("CREATED SUCCESS");
		return briefInfo;
	
	}

	public BriefInfo update(long id, BriefInfo briefInfo) {

		briefInfo.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(briefInfo);
		session.getTransaction().commit();
		session.close();

		System.out.println("UPDATED SUCCESS");
		return briefInfo;
	}

	public void delete(long id) {
		BriefInfo briefInfo = new BriefInfo();
		briefInfo.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(briefInfo);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("DELETED SUCCESS");
	}

	public BriefInfo read(long id) {
		Session session = sessionFactory.openSession();
				
		BriefInfo briefInfo = session.get(BriefInfo.class, id);
				
		if (briefInfo != null) {
			System.out.println("Id: " + briefInfo.getId());
			System.out.println("Service Name: " + briefInfo.getName());
			System.out.println("Brief Info: " + briefInfo.getBriefinfo());

		} else {
			System.out.println("no objected found with that id");
		}

		session.close();

		return briefInfo;

	}

	public BriefInfo readByName(String name) {

		Session session = sessionFactory.openSession();

		String hql = "FROM BriefInfo bi WHERE lower(bi.name) = lower( :name)";

		Query query = session.createQuery(hql);

		query.setParameter("name", name);

		List<BriefInfo> results = query.list();

		BriefInfo briefInfo = new BriefInfo();
		
		if (results.size() > 0) {
			briefInfo = (BriefInfo) results.get(0);
			if (briefInfo != null) {
				System.out.println("Id: " + briefInfo.getId());
				System.out.println("Service Name: " + briefInfo.getName());
				System.out.println("Brief Info: " + briefInfo.getBriefinfo());

			} else {
				System.out.println("no objected found with that name");
			}
		}

		session.close();

		return briefInfo;

	}

	public List<BriefInfo> searchForName(String name) {
		Session session = sessionFactory.openSession();
		
		String hql = "SELECT bi FROM BriefInfo bi WHERE lower(bi.name) like  lower('%" + name.toLowerCase() + "%')";
		Query<BriefInfo> query = session.createQuery(hql);

		// query.setParameter("name",name);

		List<BriefInfo> results = query.list();

		session.close();
		return results;

	}
	
	public List<BriefInfo> getAllBriefInfo() {
		Session session = sessionFactory.openSession();
		
		String hql = "FROM BriefInfo";
		Query<BriefInfo> query = session.createQuery(hql);
		List<BriefInfo> results = query.list();

		session.close();
		return results;

	}


}
