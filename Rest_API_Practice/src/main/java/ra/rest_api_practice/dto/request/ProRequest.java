package ra.rest_api_practice.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProRequest {
    private String proId;
    @NotNull(message = "Tên sản phẩm không được để null!")
    private String proName;
    @NotNull(message = "Giá sản phẩm không được để null!")
    private float price;
    private Date created;
    private int quantity;
    private boolean proStatus;
    @NotNull(message = "Mã danh mục không được để null!")
    private long catalog_id;
    public Long getCatalog_id() {
        return catalog_id;
    }
}
