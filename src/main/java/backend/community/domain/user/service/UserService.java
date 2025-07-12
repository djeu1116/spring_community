package backend.community.domain.user.service;

import backend.community.domain.user.dto.request.UserLoginRequest;
import backend.community.domain.user.dto.request.UserSignupRequest;
import backend.community.domain.user.dto.response.UserLoginResponse;

public interface UserService {
    void signUp(UserSignupRequest request);
    UserLoginResponse login(UserLoginRequest request);
}
