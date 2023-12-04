package ra.rest_api_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.rest_api_practice.model.Categories;
import ra.rest_api_practice.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    @Query("select p from Product p where p.proName like %?1%")
    List<Product> findByProName(String proName);
}
