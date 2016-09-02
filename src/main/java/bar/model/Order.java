package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTimeOrdered;

	private int tableNo;

	//bi-directional many-to-one association to Waiter
	@ManyToOne
	@JoinColumn(name="waiterID")
	private Waiter waiter;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="order")
	private List<Orderitem> orderitems;

	public Order() {
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getDateTimeOrdered() {
		return this.dateTimeOrdered;
	}

	public void setDateTimeOrdered(Date dateTimeOrdered) {
		this.dateTimeOrdered = dateTimeOrdered;
	}

	public int getTableNo() {
		return this.tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public Waiter getWaiter() {
		return this.waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setOrder(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setOrder(null);

		return orderitem;
	}

}