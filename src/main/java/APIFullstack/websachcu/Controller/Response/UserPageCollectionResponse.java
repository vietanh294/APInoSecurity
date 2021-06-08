package APIFullstack.websachcu.Controller.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserPageCollectionResponse {
    private Integer bookId;
    private String bookTitle;
    private String publishYear;
    private String userPostedPhone;
    private Integer bookPrice;
    private String bookPicture;
}
