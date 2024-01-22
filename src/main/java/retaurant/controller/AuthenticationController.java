package retaurant.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import retaurant.auth.AuthenticationRequest;
import retaurant.config.ResultMessage;
import retaurant.service.AuthenticationService;

@RestController
@Slf4j
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResultMessage<Object> login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationService.authentication(authenticationRequest);
            return ResultMessage.success(authenticationService.authentication(authenticationRequest), "Thành công");
        } catch (AuthenticationException e) {
            return ResultMessage.error("400", "Thất bại", e.getMessage());
        }
    }
}
