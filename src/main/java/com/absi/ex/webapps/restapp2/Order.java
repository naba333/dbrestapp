package com.absi.ex.webapps.restapp2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@Table(name = "orders")
//@NamedQueries({ @NamedQuery(name = "Order.getAll", query = "SELECT o FROM Order o")})
public class Order implements Serializable
{
	@Id
	//@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;

	@Size(max = 10)
	@Column(name = "garps_id")
	private String garpsId;

	@Size(max = 30)
	@Column(name = "customer_id")
	private String customerId;


	public Order() {}

	public Integer getOrderId() { return this.orderId; }
	public void setOrderId(Integer id) { this.orderId = id; }

	public String getGarpsId() { return this.garpsId; }
	public void setGarpsId(String id) { this.garpsId = id; }

	public String getCustomerId() { return this.customerId; }
	public void setCustomerId(String id) { this.customerId = id; }

}