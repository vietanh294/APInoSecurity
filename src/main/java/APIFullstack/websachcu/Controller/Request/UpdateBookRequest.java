package APIFullstack.websachcu.Controller.Request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateBookRequest {
    private Integer id;
    private String title;
    private String author;
    //    private String avatar;
//    private Integer categoryId;
}
