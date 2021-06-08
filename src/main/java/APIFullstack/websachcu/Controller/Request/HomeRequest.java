package APIFullstack.websachcu.Controller.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HomeRequest {
    private Integer categoryIde;
    private String orderBy = "title";
    private String direction = "ASC";
    private Integer pageNumber = 1;
    private Integer totalPages =0;
}
