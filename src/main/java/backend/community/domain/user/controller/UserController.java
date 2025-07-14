package backend.community.domain.user.controller;

import backend.community.domain.user.dto.request.UserLoginRequest;
import backend.community.domain.user.dto.request.UserSignupRequest;
import backend.community.domain.user.entity.User;
import backend.community.domain.user.service.UserService;
import backend.community.domain.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserSignupRequest request) {
        userService.signUp(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginRequest request) {
        userService.login(request);
        return ResponseEntity.ok().build();
    }
}
