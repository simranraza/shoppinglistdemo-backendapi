package com.genius.shoppingListDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_ProdcutCategory")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "category_name", length = 128, nullable = false)
    private String categoryName;

    @Column(name = "is_perishable", nullable = false)
    private boolean isPerishable;

    public ProductCategory() {}

    public ProductCategory(Integer id, String categoryName, boolean isPerishable) {
        this.id = id;
        this.categoryName = categoryName;
        this.isPerishable = isPerishable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }
}