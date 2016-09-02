package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int articleId;

	private String articleName;

	private BigDecimal articlePrice;

	//bi-directional many-to-one association to Articlecategory
	@ManyToOne
	@JoinColumn(name="articleCategoryId")
	private Articlecategory articlecategory;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="article")
	private List<Orderitem> orderitems;

	public Article() {
	}

	public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return this.articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public BigDecimal getArticlePrice() {
		return this.articlePrice;
	}

	public void setArticlePrice(BigDecimal articlePrice) {
		this.articlePrice = articlePrice;
	}

	public Articlecategory getArticlecategory() {
		return this.articlecategory;
	}

	public void setArticlecategory(Articlecategory articlecategory) {
		this.articlecategory = articlecategory;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setArticle(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setArticle(null);

		return orderitem;
	}

}