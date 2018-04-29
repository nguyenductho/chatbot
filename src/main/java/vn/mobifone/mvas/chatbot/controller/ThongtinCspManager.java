package vn.mobifone.mvas.chatbot.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import vn.mobifone.mvas.chatbot.entity.ThongtinCsp;

public class ThongtinCspManager {
	
	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public ThongtinCsp create(ThongtinCsp thongtinCsp) {
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(thongtinCsp);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("CREATED SUCCESS");
		return thongtinCsp;
	}
	
	public void update(long id, ThongtinCsp thongtinCsp) {
		
		thongtinCsp.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(thongtinCsp);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("UPDATED SUCCESS");
	}
	
	public void delete(long id) {
		ThongtinCsp thongtinCsp = new ThongtinCsp();
		thongtinCsp.setId(id);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(thongtinCsp);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("DELETED SUCCESS");
	}	
	
	public ThongtinCsp read(long id) {
		Session session = sessionFactory.openSession();
		ThongtinCsp thongtinCsp = session.get(ThongtinCsp.class, id);
		if(thongtinCsp != null) {
			System.out.println("Id: "+ thongtinCsp.getId());
			System.out.println("Service Name: " + thongtinCsp.getServicename());
			System.out.println("shortcode: " + thongtinCsp.getShortcode());
			System.out.println("partner: " + thongtinCsp.getPartner());
			System.out.println("sale contact: " + thongtinCsp.getSalecontact());
			System.out.println("incharge: " + thongtinCsp.getIncharge());
			System.out.println("mobisale: " + thongtinCsp.getMobisale());
			
		} else {
			System.out.println("no objected found with that id");
		}
		
		session.close();
		
		return thongtinCsp;
		
	}
	
	public ThongtinCsp readByServiceName(String serviceName) {

		Session session = sessionFactory.openSession();
		
		String hql = "FROM ThongtinCsp TTCSP WHERE TTCSP.servicename = :servicename";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("servicename",serviceName);
		
		List<ThongtinCsp> results = query.list();
		
		ThongtinCsp thongtinCsp = new ThongtinCsp();
		
		if (results.size() > 0)		{
			thongtinCsp = (ThongtinCsp) results.get(0);
			if(thongtinCsp != null) {
				System.out.println("Id: "+ thongtinCsp.getId());
				System.out.println("Service Name: " + thongtinCsp.getServicename());
				System.out.println("shortcode: " + thongtinCsp.getShortcode());
				System.out.println("partner: " + thongtinCsp.getPartner());
				System.out.println("sale contact: " + thongtinCsp.getSalecontact());
				System.out.println("incharge: " + thongtinCsp.getIncharge());
				System.out.println("mobisale: " + thongtinCsp.getMobisale());
				
			} else {
				System.out.println("no objected found with that id");
			}
		}

		session.close();
		
		return thongtinCsp;
		
	}
	
	
	public List<ThongtinCsp> searchForName(String serviceName){	
		Session session = sessionFactory.openSession();

		String hql = "SELECT TTCSP FROM ThongtinCsp TTCSP WHERE lower(TTCSP.servicename) like  lower('%" + serviceName.toLowerCase() + "%')";
		Query query = session.createQuery(hql);
		
		List<ThongtinCsp> results = query.list();
		
		session.close();
		return results;
		
	}
	
	public List<ThongtinCsp> getAllThongtinCsp(){	
		Session session = sessionFactory.openSession();

		String hql = "FROM ThongtinCsp";
		Query<ThongtinCsp> query = session.createQuery(hql);
		List<ThongtinCsp> results = query.list();
		
		session.close();
		return results;
		
	}

}
