package APIFullstack.websachcu.Controller.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String userPhone;
    private String userEmail;
    private String userPass;
    private String userPassConfirm;
}
