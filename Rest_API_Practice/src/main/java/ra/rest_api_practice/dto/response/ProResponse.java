package ra.rest_api_practice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProResponse {
    private String proId;
    private String proName;
    private float price;
    private Date created;
    private int quantity;
    private boolean proStatus;
    private long catalog_id;
    private String catalog_name;
}
