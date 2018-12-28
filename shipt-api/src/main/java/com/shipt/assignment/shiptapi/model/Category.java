package com.shipt.assignment.shiptapi.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "categories")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Size(max = 100)
    private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
	                CascadeType.MERGE
			})
	@JoinTable(
			name = "category_products",
			joinColumns = { @JoinColumn(name = "category_id") },
			inverseJoinColumns = { @JoinColumn(name = "product_id") }
			)
	private Set<Product> products = new HashSet<>();

	public Category(){}
	
	public Category(Long id, @NotNull @Size(max = 100) String name, Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}