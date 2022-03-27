package site.metacoding.blogversion2.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogversion2.domain.user.User;
import site.metacoding.blogversion2.service.UserService;
import site.metacoding.blogversion2.web.api.dto.ResponseDto;
import site.metacoding.blogversion2.web.api.dto.user.JoinDto;
import site.metacoding.blogversion2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public ResponseDto<String> join(@RequestBody JoinDto joinDto) {
        userService.회원가입(joinDto);

        return new ResponseDto<String>(1, "회원가입성공", null);
    }

    @PostMapping("/login")
    public ResponseDto<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        User userEntity = userService.로그인(loginDto);

        if (userEntity == null) {
            return new ResponseDto<String>(-1, "로그인실패", null);
        }

        response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + "; path=/");
        // response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + ";
        // path=/; httpOnly=true");
        // response.addHeader("Set-Cookie", "path=/");

        // Cookie cookie = new Cookie("remember", loginDto.getUsername());
        // cookie.setPath("/");
        // response.addCookie(cookie);

        session.setAttribute("principal", userEntity);

        if (user.getRemember != null && user.getRemember().equals("on")) {
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername());
        } else {

        }

        session.setAttribute("principal", userEntity);
        return new ResponseDto<String>(1, "로그인 성공", null);
    }
}