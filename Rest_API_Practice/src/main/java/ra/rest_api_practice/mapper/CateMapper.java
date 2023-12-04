package ra.rest_api_practice.mapper;

import org.springframework.stereotype.Component;
import ra.rest_api_practice.dto.request.CateRequest;
import ra.rest_api_practice.dto.response.CateResponse;
import ra.rest_api_practice.model.Categories;
@Component
public class CateMapper implements GenericMapper<Categories, CateRequest, CateResponse>{
    @Override
    public Categories toEntity(CateRequest cateRequest) {
        return Categories.builder().catalogId(cateRequest.getCatalogId())
                .catalogName(cateRequest.getCatalogName())
                .descriptions(cateRequest.getDescriptions())
                .priority(cateRequest.getPriority())
                .catalogStatus(cateRequest.isCatalogStatus()).build();
    }

    @Override
    public CateResponse toResponse(Categories categories) {
        return CateResponse.builder().catalogId(categories.getCatalogId())
                .catalogName(categories.getCatalogName())
                .descriptions(categories.getDescriptions())
                .priority(categories.getPriority())
                .catalogStatus(categories.isCatalogStatus()).build();
    }
}
