package APIFullstack.websachcu.Controller.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostBookRequest {
    private Integer id;
    private String title;
    private String author;
    private  String picture ="";
    private String publishYear ="";
    private  String description ="";
    private  Integer price;
    private  Integer categoryId;
    private  String categoryName;
}
