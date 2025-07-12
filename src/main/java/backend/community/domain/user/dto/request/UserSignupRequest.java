package backend.community.domain.user.dto.request;

import lombok.Getter;

@Getter
public class UserSignupRequest {
    private String email;
    private String password;

}
