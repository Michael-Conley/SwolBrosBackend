package com.swolBros.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mealprep")
public class MealPrep {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="meals")
	private String meals;
	@Column(name="grocerylist")
	private String grocerylist;
	@Column(name="expdate")
	private String expdate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getGrocerylist() {
		return grocerylist;
	}
	public void setGrocerylist(String grocerylist) {
		this.grocerylist = grocerylist;
	}
	public String getExpDate() {
		return expdate;
	}
	public void setExpDate(String expDate) {
		this.expdate = expDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
