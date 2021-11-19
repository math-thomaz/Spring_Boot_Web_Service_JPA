package com.maththomaz.webService.repositories;

import com.maththomaz.webService.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
