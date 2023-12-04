package ra.rest_api_practice.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.rest_api_practice.dto.request.CateRequest;
import ra.rest_api_practice.dto.request.ProRequest;
import ra.rest_api_practice.dto.response.CateResponse;
import ra.rest_api_practice.dto.response.ProResponse;
import ra.rest_api_practice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProResponse>> getAllProduct() {
        List<ProResponse> listPro = productService.findAll();
        return new ResponseEntity<>(listPro, HttpStatus.OK);
    }
    @GetMapping("/{proId}")
    public ResponseEntity<ProResponse> getProductById(@PathVariable String proId) {
        ProResponse product = productService.findById(proId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProResponse> createProduct(@Valid @RequestBody ProRequest proRequest) {
        ProResponse product = productService.save(proRequest);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @PutMapping("/{proId}")
    public ResponseEntity<ProResponse> updateProduct(@RequestBody ProRequest proRequest,@PathVariable String proId) {
        ProResponse product = productService.update(proRequest,proId);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
    @DeleteMapping("/{proId}")
    public ResponseEntity<ProResponse> deleteProduct(@PathVariable String proId) {
        ProResponse product = productService.delete(proId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProResponse>> searchProductName(@PathParam("proName") String proName) {
        List<ProResponse> result = productService.findByProName(proName);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
