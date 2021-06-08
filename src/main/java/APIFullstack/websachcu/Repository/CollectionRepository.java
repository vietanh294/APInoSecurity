package APIFullstack.websachcu.Repository;

import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CollectionRepository extends JpaRepository<CollectionEntity,Integer> {
    List<CollectionEntity> findAllByUserIdAndLikeStatus(Integer userId,Integer likeStatus);

    @Query(nativeQuery = true, value = "SELECT *  FROM user_collection WHERE user_id =:IdB limit 1")
    CollectionEntity findByNameParam(@Param("IdB") Integer userId);

    @Query(nativeQuery = true, value = "SELECT *  FROM user_collection WHERE user_id =?1 and book_id =?2 ")
    CollectionEntity findByNativeQueryUserAndBookId( Integer userId,Integer bookId);

}
