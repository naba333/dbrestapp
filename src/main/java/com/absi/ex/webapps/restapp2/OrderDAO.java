package com.absi.ex.webapps.restapp2;

import com.absi.ex.webapps.restapp2.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.Stateless;
import javax.transaction.UserTransaction;
import javax.annotation.Resource;
import javax.transaction.SystemException;
import javax.transaction.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.NotSupportedException;
import javax.transaction.HeuristicRollbackException;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;

@Stateless
//@ApplicationScoped
public class OrderDAO
{
	@PersistenceContext(unitName = "MyPU")
	private EntityManager em;

	//@Resource
	//private UserTransaction ut;

	public List<Order> getAll()
	{
		return em.createQuery("select o from Order o").getResultList();
	}

	//public List<Order> createNewOrder(Order newOrder)
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Order> createNewOrder(Order newOrder)
	{
		em.persist(newOrder);
		em.flush();
		return em.createQuery("select o from Order o").getResultList();
	}

	public List<Order> removeFirstOrder()
	{
		List<Order> ordersList = em.createQuery("select o from Order o").getResultList();
		if(!ordersList.isEmpty())
			em.remove(ordersList.get(0));

		return em.createQuery("select o from Order o").getResultList();
	}
}