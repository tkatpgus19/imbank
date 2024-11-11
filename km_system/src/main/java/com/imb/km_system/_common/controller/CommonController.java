package com.imb.km_system._common.controller;

import com.imb.km_system._common.dto.MessageDto;
import com.imb.km_system._common.response.ApiResponseDto;
import com.imb.km_system._common.response.MsgType;
import com.imb.km_system._common.response.ResponseUtils;
import com.imb.km_system.departments.service.DepartmentService;
import com.imb.km_system.buttons.service.ButtonService;
import com.imb.km_system.users.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("")
public class CommonController {

    private final UserService userService;
    private final DepartmentService departmentService;
    private final ButtonService buttonService;

    @GetMapping("/")
    public ApiResponseDto<?> init() {
        departmentService.initDepartments();
        userService.initUser();
        buttonService.initKiosk();

        return ResponseUtils.ok(MsgType.TEST_MSG);
    }



    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/enter")
    public void enter(@Payload MessageDto message) {
        // "/sub/event/imbank12345" 구독자에게 메시지를 보냅니다.
        messagingTemplate.convertAndSend("/sub/event/imbank12345", "연결되었습니다!");
        log.warn("여기 와따");
    }

    @MessageMapping("/request")
    public void request(String message) {
        messagingTemplate.convertAndSend("/sub/room/" + 1, message);
    }
}
