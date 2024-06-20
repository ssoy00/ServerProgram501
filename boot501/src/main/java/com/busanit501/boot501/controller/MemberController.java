package com.busanit501.boot501.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("/login")
    public void loginGet(String error, String logout,
                         RedirectAttributes redirectAttributes) {
        log.info("loginGet===================");
        log.info("logoutTest ===================" + logout);

        if(logout != null) {
            log.info("logoutTest user ====================");
        }
        if(error != null) {
            log.info("logoutTest error ====================" + error);
            redirectAttributes.addFlashAttribute(
                    "error", "");
        }

    }
    // 로그인 폼은 있지만, 로그인을 처리하는 로직처리가 없어요?
    // 누가 처리? 스프링의 시큐리티가 알아서 처리함.
    // 자동로그인, remember-me 이름으로 서버에 와요.

    //회원가입 폼
    @GetMapping("/join")
    public void joinGet() {
        log.info("joinGet====================");
    }

    // 회원 가입 로직 처리
    

}
