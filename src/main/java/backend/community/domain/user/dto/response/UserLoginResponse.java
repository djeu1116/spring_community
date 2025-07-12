package backend.community.domain.user.dto.response;

public class UserLoginResponse {
    // 서버가 로그인 성공 시 클라이언트에게 주는 응답
    private String accessToken;
    private String refreshToken;
}
