package ra.rest_api_practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Categories {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long catalogId;
    @Column(columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String catalogName;
    @Column(columnDefinition = "text")
    private String descriptions;
    private int priority;
    @Column(name = "catalog_status",columnDefinition = "bit default 1")
    private boolean catalogStatus;
    @OneToMany(mappedBy = "catalog")
    private List<Product> listProduct;
}
