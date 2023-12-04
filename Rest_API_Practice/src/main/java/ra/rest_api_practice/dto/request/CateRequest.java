package ra.rest_api_practice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CateRequest {
    private long catalogId;
    @NotNull(message = "Tên danh mục không được để null!")
//    @UniqueElements(message = "Tên danh mục không được trùng!")
    private String catalogName;
    private String descriptions;
    private int priority;
    private boolean catalogStatus;
}
