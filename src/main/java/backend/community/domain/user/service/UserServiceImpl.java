package backend.community.domain.user.service;

import backend.community.domain.user.dto.request.UserLoginRequest;
import backend.community.domain.user.dto.request.UserSignupRequest;
import backend.community.domain.user.dto.response.UserLoginResponse;
import backend.community.domain.user.entity.User;
import backend.community.domain.user.repository.UserRepository;
import backend.community.global.auth.jwt.JwtGenerator;
import backend.community.global.auth.jwt.JwtToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void signUp(UserSignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .email(request.getEmail())
                .password(encodedPassword)
                .build();
        userRepository.save(user);
    }

        @Override
        public UserLoginResponse login(UserLoginRequest request) {
            log.info("로그인 요청 : " + request.getEmail());
            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("이메일이 잘못되었습니다."));
            log.info("이메일 유효성 통과 : " + user.getEmail());
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 잘못되었습니다.");
            }
            log.info("비밀번호 유효성 통과 : " + user.getPassword());
            JwtToken jwtToken = jwtGenerator.generateToken(user.getId());

            log.info("토큰 생성 완료  AccessToken = " + jwtToken.getAccessToken() + " RefreshToken = " + jwtToken.getRefreshToken());
            return new UserLoginResponse(jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        }
}
