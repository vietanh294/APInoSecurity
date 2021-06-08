package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Request.RegisterRequest;

import APIFullstack.websachcu.Entity.UserEntity;
import APIFullstack.websachcu.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.Collections;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;

//    public String messageService = null;

    public String runRegisterService(RegisterRequest registerRequest) {
        // Check phone
        if ( registerRequest.getUserPhone() == null || registerRequest.getUserPhone() == "" || registerRequest.getUserPhone().length() != 10){
            return "Số điện thoại không hợp lệ!" ;
        }
        //Check email
        if (StringUtils.isEmpty(registerRequest.getUserEmail()) || !registerRequest.getUserEmail().contains("@gmail.com")){
            return "Email không chính xác";
        }
        // Check pass
        if (StringUtils.isEmpty(registerRequest.getUserPass()) || registerRequest.getUserPass().length() <8){
            return "Mật khẩu không hợp lệ";
        }
        if (!registerRequest.getUserPass().equals(registerRequest.getUserPassConfirm())){
            return "Xác nhận thất bại! Mật khẩu không trùng khớp";
        }

        //Kiem tra SDT va Email da ton tai hay chua
        String  userForm = userRepository.findPassByNativeQuery(registerRequest.getUserPhone(), registerRequest.getUserEmail());
        while (userForm != null){
            return  "SDT hoặc Email đã tồn tại!";
        }
        // insert new user
        UserEntity userEntity = new UserEntity();
        userEntity.setUserPhone(registerRequest.getUserPhone());
        userEntity.setUserEmail(registerRequest.getUserEmail());
        userEntity.setUserPassword(registerRequest.getUserPass());
        userRepository.save(userEntity);
        return "Register Success";
    }
}
