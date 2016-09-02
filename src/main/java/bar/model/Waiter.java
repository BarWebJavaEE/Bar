package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the waiter database table.
 * 
 */
@Entity
@NamedQuery(name="Waiter.findAll", query="SELECT w FROM Waiter w")
public class Waiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int waiterId;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="waiter")
	private List<Order> orders;

	//bi-directional one-to-one association to Employee
	@OneToOne
	@JoinColumn(name="waiterId")
	private Employee employee;

	public Waiter() {
	}

	public int getWaiterId() {
		return this.waiterId;
	}

	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setWaiter(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setWaiter(null);

		return order;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}