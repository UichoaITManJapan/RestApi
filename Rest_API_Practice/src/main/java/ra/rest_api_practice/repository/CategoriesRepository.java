package ra.rest_api_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.rest_api_practice.dto.response.CateResponse;
import ra.rest_api_practice.model.Categories;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {
    @Query("select c from Categories c where c.catalogName like %?1%")
    List<Categories> findByCatalogName(String catalogName);
}
