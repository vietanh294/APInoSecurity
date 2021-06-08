package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Request.LoginRequest;
import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Entity.UserEntity;
import APIFullstack.websachcu.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFormSignedIn userFormSignedIn;
    public String runLoginService(LoginRequest loginRequest){
//        Check userName
        if ( loginRequest.getUserName() == null || loginRequest.getUserName() == "" ){
            return "Tài khoản không hợp lệ!" ;
        }
//        Truy vấn DataBase
        String userPassInDB =userRepository.findPassByNativeQuery(loginRequest.getUserName(),loginRequest.getUserName());
        while (userPassInDB != null){
            if (loginRequest.getUserPass().equals(userPassInDB) == true){
                // Tự tao Token đăng  nhập
                UserEntity userSignedIn = userRepository.findAllByUserPhoneOrUserEmail(loginRequest.getUserName(),loginRequest.getUserName());
                userFormSignedIn.setUserSignedId(userSignedIn.getUserId());
                userFormSignedIn.setUserSignedPhone(userSignedIn.getUserPhone());
                userFormSignedIn.setUserSignedEmail(userSignedIn.getUserEmail());
                //
                return "Login success";
            } else return "Password không chính xác";
        } return "Login failure";
//        List<UserEntity> usersInDB = userRepository.findAllByUserPhoneOrUserEmail(loginRequest.getUserName(),loginRequest.getUserName());
    }
}
