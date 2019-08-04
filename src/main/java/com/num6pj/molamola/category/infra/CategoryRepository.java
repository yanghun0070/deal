package com.num6pj.molamola.category.infra;

import com.num6pj.molamola.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

