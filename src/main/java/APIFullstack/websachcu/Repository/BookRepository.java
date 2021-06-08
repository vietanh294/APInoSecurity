package APIFullstack.websachcu.Repository;

import APIFullstack.websachcu.Entity.BookEntity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findAllByCategoryId(Integer cateId , Pageable pageable);
    List<BookEntity> findAllByAuthor(String author);
    List<BookEntity> findAllByCategoryIdAndAuthor(Integer cateId, String author);
    List<BookEntity> findAllBy(Pageable pageable);
//    List<CategoryEntity> findAll();
    BookEntity findAllById(Integer bookId);

    @Query(nativeQuery = true, value = "SELECT * FROM book WHERE book_id =:IdB")
    BookEntity findByNameParam(@Param("IdB") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM book WHERE book_id =?1 ")
    BookEntity findByNativeQuery(Integer id);
// Query Lỗi
    @Query(nativeQuery = true, value = "SELECT * FROM book")
    List<BookEntity> findAllByNativeQuery(Pageable pageable);
// Hết Query Lỗi

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE book SET book_name = ?1 WHERE book_id = ?2 ")
    int updateBookByNativeModify(String title, Integer id);
// Query tinh count So luong phan tu

    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM book")
    Integer countTotalItemsNativeQuery();
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM book WHERE category_id =?1 ")
    Integer countTotalItemsByCategoryIdNativeQuery(Integer cateId);
}
