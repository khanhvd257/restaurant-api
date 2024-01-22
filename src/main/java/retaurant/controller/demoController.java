package retaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retaurant.service.AuthenticationService;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class demoController {
    private final AuthenticationService authenticationService;

    @PostMapping("/test")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("OKE HAHAHA");

    }
}
