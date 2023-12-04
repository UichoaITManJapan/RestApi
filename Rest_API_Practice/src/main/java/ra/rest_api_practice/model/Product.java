package ra.rest_api_practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @Column(name = "product_id",columnDefinition = "char(5)")
    private String proId;
    @Column(name = "product_name", columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String proName;
    @Column(nullable = false)
    private float price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private Date created;
    @Column(columnDefinition = "int default 0")
    private int quantity;
    @Column(columnDefinition = "bit default 1")
    private boolean proStatus;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;
}
