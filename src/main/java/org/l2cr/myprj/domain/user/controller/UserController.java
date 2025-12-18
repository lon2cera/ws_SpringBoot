package org.lncr.chatdiscussion.domain.user.controller;

import java.util.Map;

import org.lncr.chatdiscussion.global.security.CustomUserDetails;
import org.lncr.chatdiscussion.global.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@Log4j2
@RequiredArgsConstructor
public class UserController {
    
    private final JwtUtil jwtUtil; 
    private final AuthenticationManager authenticationManager;

    @GetMapping("/me")
    public CustomUserDetails getMyInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        log.info("getMyInfo()..."+userDetails);
        return userDetails;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );

        String token = jwtUtil.generateToken(username);

        ResponseCookie cookie = ResponseCookie.from("accessToken", token)
            .httpOnly(true)
            .secure(false)  //배포시 true로 변경
            .path("/")
            .maxAge(60 * 60) // 1 hour
            .sameSite("Lax")
            .build();


        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("Login successful");
    }
    




}
