package APIFullstack.websachcu.Controller.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserPagePostedResponse {
    private Integer bookId;
    private String bookTitle;
    private String publishYear;
    private Date postedDate;
    private Integer bookPrice;
    private String bookPicture;
}
