package APIFullstack.websachcu.Controller.Response;

import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Getter @Setter
public class BookListResponse {
    private Integer code;
    private String message;
    private List<BookEntity> data;
    private List<CategoryEntity> categoryData;
}
