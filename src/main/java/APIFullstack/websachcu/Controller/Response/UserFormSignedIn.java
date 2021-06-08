package APIFullstack.websachcu.Controller.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
public class UserFormSignedIn {
    private Integer userSignedId;
    private String userSignedPhone;
    private String userSignedEmail;
}

@Configuration
class UserBean {
    @Bean
    UserFormSignedIn userFormSignedIn(){
        return new UserFormSignedIn();
    }
}