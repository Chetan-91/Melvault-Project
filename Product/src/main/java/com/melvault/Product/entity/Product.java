package com.melvault.Product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.HttpStatus;

@Entity
@Table(name="Production_TBL")
public class Product {

 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String name;
 private Integer salary;	
 private Integer age;
 private Integer exp;
 
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Integer getExp() {
	return exp;
}
public void setExp(Integer exp) {
	this.exp = exp;
}
 
 


}
