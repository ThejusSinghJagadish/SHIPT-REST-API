package com.shipt.assignment.shiptapi.repository;

import org.springframework.stereotype.Repository;
import com.shipt.assignment.shiptapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
