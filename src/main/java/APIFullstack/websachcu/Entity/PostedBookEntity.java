package APIFullstack.websachcu.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "user_posted")
public class PostedBookEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_posted_id")
        private Integer postedId;

        @Column(name = "user_id")
        private Integer userId;

        @Column(name = "book_id")
        private Integer bookId;

        @Column(name = "posted_time")
        private Date postedTime;
}
