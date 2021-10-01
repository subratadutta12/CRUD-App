package com.springboot.springbootfirstapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
	
	@Id
	@GeneratedValue  //auto generate the primary key,i.e. id
	private int id;
	private String name;
	private int quantity;
	private double price;
	
	public Product(String name,int quantity,double price)
	{
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
}
