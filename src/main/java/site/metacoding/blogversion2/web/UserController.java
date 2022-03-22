package site.metacoding.blogversion2.web;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogversion2.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
}