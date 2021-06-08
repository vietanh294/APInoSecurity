package APIFullstack.websachcu.Repository;


import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findAllByUserPhone(String hone);
    List<UserEntity> findAllByUserEmail(String email);
//    List<UserEntity> findAllByUserPhoneOrUserEmail(String phone ,String email);
    UserEntity findAllByUserPhoneOrUserEmail(String phone ,String email);

    @Query(nativeQuery = true, value = "SELECT user_password FROM user WHERE user_phone =?1 or user_email =?2")
    String findPassByNativeQuery(String userPhone,String  userEmail);

    @Query(nativeQuery = true, value = "SELECT user_phone FROM user WHERE user_id =?1")
    String findUserPhoneByNativeQuery(Integer userId);

}
