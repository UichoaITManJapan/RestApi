package ra.rest_api_practice.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rest_api_practice.dto.request.CateRequest;
import ra.rest_api_practice.dto.response.CateResponse;
import ra.rest_api_practice.mapper.CateMapper;
import ra.rest_api_practice.model.Categories;
import ra.rest_api_practice.repository.CategoriesRepository;
import ra.rest_api_practice.service.CategoriesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CateMapper cateMapper;
    @Override
    public List<CateResponse> findAll() {
        return categoriesRepository.findAll().stream()
                .map(categories -> cateMapper.toResponse(categories)).collect(Collectors.toList());
    }

    @Override
    public CateResponse findById(long catalogId) {
        Optional<Categories> optional = categoriesRepository.findById(catalogId);
        if (optional.isPresent()) {
            return cateMapper.toResponse(optional.get());
        }
        return null;
    }

    @Override
    public CateResponse save(CateRequest cateRequest) {
        //CateRequest --> Categories --> CateResponse
        return cateMapper.toResponse(categoriesRepository.save(cateMapper.toEntity(cateRequest)));
    }

    @Override
    public CateResponse update(CateRequest cateRequest, long catalogId) {
        Optional<Categories> optional = categoriesRepository.findById(catalogId);
        if (optional.isPresent()) {
            //CateRequest --> Categories --> CateResponse
            Categories cateUpdate = optional.get();
            cateUpdate.setCatalogId(cateRequest.getCatalogId());
            cateUpdate.setCatalogName(cateRequest.getCatalogName());
            cateUpdate.setDescriptions(cateRequest.getDescriptions());
            cateUpdate.setPriority(cateRequest.getPriority());
            cateUpdate.setCatalogStatus(cateRequest.isCatalogStatus());
            return cateMapper.toResponse(categoriesRepository.save(cateUpdate));
        }
        return null;
    }

    @Override
    public CateResponse delete(long catalogId) {
        Optional<Categories> optional = categoriesRepository.findById(catalogId);
        if (optional.isPresent()) {
            Categories cateUpdateStatus = optional.get();
            // cập nhật trạng thái thành 0
            cateUpdateStatus.setCatalogStatus(true);
            categoriesRepository.save(cateUpdateStatus);
            return cateMapper.toResponse(cateUpdateStatus);
        }
        return null;
    }

    @Override
    public List<CateResponse> findByCatalogName(String catalogName) {
        return categoriesRepository.findByCatalogName(catalogName).stream()
                .map(categories -> cateMapper.toResponse(categories)).collect(Collectors.toList());
    }
}
