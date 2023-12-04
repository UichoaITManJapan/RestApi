package ra.rest_api_practice.service;

import ra.rest_api_practice.dto.request.CateRequest;
import ra.rest_api_practice.dto.response.CateResponse;

import java.util.List;

public interface CategoriesService {
    List<CateResponse> findAll();
    CateResponse findById(long catalogId);
    CateResponse save(CateRequest cateRequest);
    CateResponse update(CateRequest cateRequest, long catalogId);
    CateResponse delete(long catalogId);
    List<CateResponse> findByCatalogName(String catalogName);
}
