
package com.company.cicd_jndi_docker_example.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import com.company.cicd_jndi_docker_example.dal.FilmDAO;
import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Film
 */
@DAO(FilmDAO.class)
@Caption("{%title}")
@Entity
@Cacheable(true)
@Table(name = "film", catalog = "sakila")
public class Film implements java.io.Serializable
{
	
	private Short             filmId;
	private Language          languageByLanguageId;
	private Language          languageByOriginalLanguageId;
	private String            title;
	private String            description;
	private Date              releaseYear;
	private short             rentalDuration;
	private BigDecimal        rentalRate;
	private Short             length;
	private BigDecimal        replacementCost;
	private String            rating;
	private String            specialFeatures;
	private Date              lastUpdate;
	private Set<Inventory>    inventories    = new HashSet<Inventory>(0);
	private Set<FilmActor>    filmActors     = new HashSet<FilmActor>(0);
	private Set<FilmCategory> filmCategories = new HashSet<FilmCategory>(0);
	
	public Film()
	{
	}
	
	@Caption("FilmId")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "film_id", unique = true, nullable = false, columnDefinition = "SMALLINT UNSIGNED")
	public Short getFilmId()
	{
		return this.filmId;
	}
	
	public void setFilmId(Short filmId)
	{
		this.filmId = filmId;
	}
	
	@Caption("LanguageByLanguageId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public Language getLanguageByLanguageId()
	{
		return this.languageByLanguageId;
	}
	
	public void setLanguageByLanguageId(Language languageByLanguageId)
	{
		this.languageByLanguageId = languageByLanguageId;
	}
	
	@Caption("LanguageByOriginalLanguageId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "original_language_id", columnDefinition = "TINYINT UNSIGNED")
	public Language getLanguageByOriginalLanguageId()
	{
		return this.languageByOriginalLanguageId;
	}
	
	public void setLanguageByOriginalLanguageId(Language languageByOriginalLanguageId)
	{
		this.languageByOriginalLanguageId = languageByOriginalLanguageId;
	}
	
	@Caption("Title")
	@Column(name = "title", nullable = false, columnDefinition = "VARCHAR")
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	@Caption("Description")
	@Column(name = "description", columnDefinition = "TEXT", length = 65535)
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	@Caption("ReleaseYear")
	@Temporal(TemporalType.DATE)
	@Column(name = "release_year", columnDefinition = "YEAR", length = 4)
	public Date getReleaseYear()
	{
		return this.releaseYear;
	}
	
	public void setReleaseYear(Date releaseYear)
	{
		this.releaseYear = releaseYear;
	}
	
	@Caption("RentalDuration")
	@Column(name = "rental_duration", nullable = false, columnDefinition = "TINYINT UNSIGNED")
	public short getRentalDuration()
	{
		return this.rentalDuration;
	}
	
	public void setRentalDuration(short rentalDuration)
	{
		this.rentalDuration = rentalDuration;
	}
	
	@Caption("RentalRate")
	@Column(name = "rental_rate", nullable = false, columnDefinition = "DECIMAL", precision = 4)
	public BigDecimal getRentalRate()
	{
		return this.rentalRate;
	}
	
	public void setRentalRate(BigDecimal rentalRate)
	{
		this.rentalRate = rentalRate;
	}
	
	@Caption("Length")
	@Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
	public Short getLength()
	{
		return this.length;
	}
	
	public void setLength(Short length)
	{
		this.length = length;
	}
	
	@Caption("ReplacementCost")
	@Column(name = "replacement_cost", nullable = false, columnDefinition = "DECIMAL", precision = 5)
	public BigDecimal getReplacementCost()
	{
		return this.replacementCost;
	}
	
	public void setReplacementCost(BigDecimal replacementCost)
	{
		this.replacementCost = replacementCost;
	}
	
	@Caption("Rating")
	@Column(name = "rating", columnDefinition = "ENUM", length = 5)
	public String getRating()
	{
		return this.rating;
	}
	
	public void setRating(String rating)
	{
		this.rating = rating;
	}
	
	@Caption("SpecialFeatures")
	@Column(name = "special_features", columnDefinition = "SET", length = 54)
	public String getSpecialFeatures()
	{
		return this.specialFeatures;
	}
	
	public void setSpecialFeatures(String specialFeatures)
	{
		this.specialFeatures = specialFeatures;
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
	
	@Caption("Inventories")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<Inventory> getInventories()
	{
		return this.inventories;
	}
	
	public void setInventories(Set<Inventory> inventories)
	{
		this.inventories = inventories;
	}
	
	@Caption("FilmActors")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<FilmActor> getFilmActors()
	{
		return this.filmActors;
	}
	
	public void setFilmActors(Set<FilmActor> filmActors)
	{
		this.filmActors = filmActors;
	}
	
	@Caption("FilmCategories")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<FilmCategory> getFilmCategories()
	{
		return this.filmCategories;
	}
	
	public void setFilmCategories(Set<FilmCategory> filmCategories)
	{
		this.filmCategories = filmCategories;
	}
	
}
