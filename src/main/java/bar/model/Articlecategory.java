package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the articlecategory database table.
 * 
 */
@Entity
@NamedQuery(name="Articlecategory.findAll", query="SELECT a FROM Articlecategory a")
public class Articlecategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int articleCategoryID;

	private String articleCategoryName;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="articlecategory")
	private List<Article> articles;

	public Articlecategory() {
	}

	public int getArticleCategoryID() {
		return this.articleCategoryID;
	}

	public void setArticleCategoryID(int articleCategoryID) {
		this.articleCategoryID = articleCategoryID;
	}

	public String getArticleCategoryName() {
		return this.articleCategoryName;
	}

	public void setArticleCategoryName(String articleCategoryName) {
		this.articleCategoryName = articleCategoryName;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setArticlecategory(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setArticlecategory(null);

		return article;
	}

}