
package com.company.cicd_jndi_docker_example.domain;

import com.company.cicd_jndi_docker_example.dal.FilmCategoryDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * FilmCategory
 */
@DAO(FilmCategoryDAO.class)
@Caption("{%id}")
@Entity
@Cacheable(true)
@Table(name = "film_category", catalog = "sakila")
public class FilmCategory implements java.io.Serializable
{
	
	private FilmCategoryId id;
	private Category       category;
	private Film           film;
	private Date           lastUpdate;
	
	public FilmCategory()
	{
	}
	
	@Caption("Id")
	@EmbeddedId
	
	@AttributeOverrides({
		@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")),
		@AttributeOverride(name = "categoryId", column = @Column(name = "category_id", nullable = false, columnDefinition = "TINYINT UNSIGNED"))})
	public FilmCategoryId getId()
	{
		return this.id;
	}
	
	public void setId(FilmCategoryId id)
	{
		this.id = id;
	}
	
	@Caption("Category")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false, columnDefinition = "TINYINT UNSIGNED")
	public Category getCategory()
	{
		return this.category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	@Caption("Film")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Film getFilm()
	{
		return this.film;
	}
	
	public void setFilm(Film film)
	{
		this.film = film;
	}
	
	@Caption("LastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP", length = 26)
	public Date getLastUpdate()
	{
		return this.lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}
	
}
