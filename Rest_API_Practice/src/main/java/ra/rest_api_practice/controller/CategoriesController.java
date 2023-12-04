package ra.rest_api_practice.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.rest_api_practice.dto.request.CateRequest;
import ra.rest_api_practice.dto.response.CateResponse;
import ra.rest_api_practice.service.CategoriesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping
    public ResponseEntity<List<CateResponse>> getAllCategory() {
        List<CateResponse> listCate = categoriesService.findAll();
        return new ResponseEntity<>(listCate, HttpStatus.OK);
    }
    @GetMapping("/{catalogId}")
    public ResponseEntity<CateResponse> getCatalogById(@PathVariable long catalogId) {
        CateResponse category = categoriesService.findById(catalogId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CateResponse> createCatalog(@Valid @RequestBody CateRequest cateRequest) {
        CateResponse category = categoriesService.save(cateRequest);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }
    @PutMapping("/{catalogId}")
    public ResponseEntity<CateResponse> updateCatalog(@RequestBody CateRequest cateRequest,@PathVariable long catalogId) {
        CateResponse category = categoriesService.update(cateRequest,catalogId);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }
    @DeleteMapping("/{catalogId}")
    public ResponseEntity<CateResponse> deleteCatalog(@PathVariable long catalogId) {
        CateResponse category = categoriesService.delete(catalogId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<CateResponse>> searchCatalogName(@PathParam("catalogName") String catalogName) {
        List<CateResponse> result = categoriesService.findByCatalogName(catalogName);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
