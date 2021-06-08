package APIFullstack.websachcu.Repository;

import APIFullstack.websachcu.Entity.CategoryEntity;
import APIFullstack.websachcu.Entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    List<CategoryEntity> findAllByCateId(Integer cateId);
    @Query(nativeQuery = true, value = "SELECT category_name FROM category WHERE category_id =:CateId ")
    String findCateNameByNameParamCateId(@Param("CateId") Integer cateId);

//    List<CategoryEntity> findAllByCateId(Integer cateId);

}
