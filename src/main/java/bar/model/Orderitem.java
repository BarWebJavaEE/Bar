package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the orderitem database table.
 * 
 */
@Entity
@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderitemID;

	private byte complete;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetimeCompleted;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetimeOrdered;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="orderitemArticleID")
	private Article article;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderID")
	private Order order;

	public Orderitem() {
	}

	public int getOrderitemID() {
		return this.orderitemID;
	}

	public void setOrderitemID(int orderitemID) {
		this.orderitemID = orderitemID;
	}

	public byte getComplete() {
		return this.complete;
	}

	public void setComplete(byte complete) {
		this.complete = complete;
	}

	public Date getDatetimeCompleted() {
		return this.datetimeCompleted;
	}

	public void setDatetimeCompleted(Date datetimeCompleted) {
		this.datetimeCompleted = datetimeCompleted;
	}

	public Date getDatetimeOrdered() {
		return this.datetimeOrdered;
	}

	public void setDatetimeOrdered(Date datetimeOrdered) {
		this.datetimeOrdered = datetimeOrdered;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}