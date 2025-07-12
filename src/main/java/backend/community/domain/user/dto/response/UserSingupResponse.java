package backend.community.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSingupResponse {
    private Long id;
    private String email;
    private String password;
}
