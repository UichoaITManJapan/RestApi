package ra.rest_api_practice.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CateResponse {
    private long catalogId;
    private String catalogName;
    private String descriptions;
    private int priority;
    private boolean catalogStatus;
}
