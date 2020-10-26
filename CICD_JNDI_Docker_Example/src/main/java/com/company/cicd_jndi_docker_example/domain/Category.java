
package com.company.cicd_jndi_docker_example.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import com.company.cicd_jndi_docker_example.dal.CategoryDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Category
 */
@DAO(CategoryDAO.class)
@Caption("{%name}")
@Entity
@Cacheable(true)
@Table(name = "category", catalog = "sakila")
public class Category implements java.io.Serializable
{
	
	private short             categoryId;
	private String            name;
	private Date              lastUpdate;
	private Set<FilmCategory> filmCategories = new HashSet<FilmCategory>(0);
	
	public Category()
	{
	}
	
	@Caption("CategoryId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "category_id", unique = true, nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public short getCategoryId()
	{
		return this.categoryId;
	}
	
	public void setCategoryId(short categoryId)
	{
		this.categoryId = categoryId;
	}
	
	@Caption("Name")
	@Column(name = "name", nullable = false, columnDefinition = "VARCHAR", length = 25)
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
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
	
	@Caption("FilmCategories")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<FilmCategory> getFilmCategories()
	{
		return this.filmCategories;
	}
	
	public void setFilmCategories(Set<FilmCategory> filmCategories)
	{
		this.filmCategories = filmCategories;
	}
	
}
