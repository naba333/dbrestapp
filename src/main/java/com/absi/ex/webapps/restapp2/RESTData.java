package com.absi.ex.webapps.restapp2;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ejb.EJB;
import java.util.List;


@Path("data")
//@RequestScoped
public class RESTData
{
	//@Context
	//private UriInfo context;

	@EJB
	private OrderDAO orderDAO;

	public RESTData() {}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllOrders()
	{
		return orderDAO.getAll();
	}

	@GET
	@Path("neworder")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> newOrder()
	{
		Order newOrder = new Order();
		newOrder.setGarpsId("X481801212");
		newOrder.setCustomerId("Zam 55");

		return orderDAO.createNewOrder(newOrder);
	}

	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> deleteOrder()
	{
		return orderDAO.removeFirstOrder();
	}

	@GET
	@Path("text")
    @Produces("text/html")
    public String getDataAsText()
	{
		return "Some data as text.";
	}
}