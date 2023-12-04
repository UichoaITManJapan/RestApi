package ra.rest_api_practice.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rest_api_practice.dto.request.ProRequest;
import ra.rest_api_practice.dto.response.ProResponse;
import ra.rest_api_practice.mapper.ProMapper;
import ra.rest_api_practice.model.Product;
import ra.rest_api_practice.repository.ProductRepository;
import ra.rest_api_practice.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProMapper proMapper;
    @Override
    public List<ProResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product -> proMapper.toResponse(product)).collect(Collectors.toList());
    }

    @Override
    public ProResponse findById(String proId) {
        // Repo --> Entity
        Optional<Product> optional = productRepository.findById(proId);
        if (optional.isPresent()) {
            // entity --> response
            return proMapper.toResponse(optional.get());
        }
        return null;
    }

    @Override
    public ProResponse save(ProRequest proRequest) {
        //Request ---> entity
        // entity --> Response
        return proMapper.toResponse(productRepository.save(proMapper.toEntity(proRequest)));
    }

    @Override
    public ProResponse update(ProRequest proRequest, String proId) {
        Optional<Product> optional = productRepository.findById(proId);
        if (optional.isPresent()) {
            Product proUpdate = optional.get();
            proUpdate.setProName(proRequest.getProName());
            proUpdate.setPrice(proRequest.getPrice());
            proUpdate.setProStatus(proRequest.isProStatus());
            // cập nhật catalogId
            if (proRequest.getCatalog_id() != null) {
                proUpdate.getCatalog().setCatalogId(proRequest.getCatalog_id());
            }
            productRepository.save(proUpdate);
            return proMapper.toResponse(proUpdate);
        }
        return null;
    }

    @Override
    public ProResponse delete(String proId) {
        Optional<Product> optional = productRepository.findById(proId);
        if (optional.isPresent()) {
            Product productDelete = optional.get();
            //cập nhật trạng thái thành true
            productDelete.setProStatus(true);
            productRepository.save(productDelete);

            // tạo đối tượng response với các thông tin trả về
            return ProResponse.builder().proId(productDelete.getProId())
                    .proName(productDelete.getProName())
                    .catalog_id(productDelete.getCatalog() != null ? productDelete.getCatalog().getCatalogId() : null)
                    .catalog_name(productDelete.getCatalog() != null ? productDelete.getCatalog().getCatalogName() : null)
                    .proStatus(productDelete.isProStatus()).build();

        }
        return null;
    }

    @Override
    public List<ProResponse> findByProName(String proName) {
        return productRepository.findByProName(proName).stream()
                .map(product -> proMapper.toResponse(product)).collect(Collectors.toList());
    }
}
