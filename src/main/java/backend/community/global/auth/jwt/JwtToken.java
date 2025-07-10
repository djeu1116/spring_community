package backend.community.global.auth.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class JwtToken {

    public static final String GRANT_TYPE = "Bearer";

    String grantType;
    String accessToken;
    String refreshToken;
}
