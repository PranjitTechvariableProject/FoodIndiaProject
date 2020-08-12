package com.techVariable.FoodIndia.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryVO {
	@Id
	@Column(name="CATEGORY_ID") 
	private int id;
	@Column(name = "CATEGORY_NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoryVO [id=" + id + ", name=" + name + "]";
	}

}
