package ra.rest_api_practice.service;

import ra.rest_api_practice.dto.request.CateRequest;
import ra.rest_api_practice.dto.request.ProRequest;
import ra.rest_api_practice.dto.response.CateResponse;
import ra.rest_api_practice.dto.response.ProResponse;

import java.util.List;

public interface ProductService {
    List<ProResponse> findAll();
    ProResponse findById(String proId);
    ProResponse save(ProRequest proRequest);
    ProResponse update(ProRequest proRequest, String proId);
    ProResponse delete(String proId);
    List<ProResponse> findByProName(String proName);
}
