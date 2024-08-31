package br.com.ctfera.course.repositories;

import br.com.ctfera.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
