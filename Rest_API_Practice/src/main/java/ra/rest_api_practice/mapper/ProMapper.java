package ra.rest_api_practice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import ra.rest_api_practice.dto.request.ProRequest;
import ra.rest_api_practice.dto.response.ProResponse;
import ra.rest_api_practice.model.Categories;
import ra.rest_api_practice.model.Product;
import ra.rest_api_practice.repository.CategoriesRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProMapper implements GenericMapper<Product, ProRequest, ProResponse>{
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public Product toEntity(ProRequest proRequest) {
        Categories catalog = proRequest.getCatalog_id()!=null ? categoriesRepository
                .findById(proRequest.getCatalog_id()).orElse(null) : null;

        return Product.builder().proId(proRequest.getProId())
                .proName(proRequest.getProName())
                .price(proRequest.getPrice())
                .created(proRequest.getCreated())
                .quantity(proRequest.getQuantity())
                .proStatus(proRequest.isProStatus())
                .catalog(catalog)
                .build();
    }

    @Override
    public ProResponse toResponse(Product product) {
        return ProResponse.builder().proId(product.getProId())
                .proName(product.getProName())
                .price(product.getPrice())
                .created(product.getCreated())
                .quantity(product.getQuantity())
                .proStatus(product.isProStatus())
                .catalog_id(mapCatalogId(product))
                .build();
    }

    private Long mapCatalogId(Product product) {
        return product.getCatalog() != null ? product.getCatalog().getCatalogId() : null;
    }
}
