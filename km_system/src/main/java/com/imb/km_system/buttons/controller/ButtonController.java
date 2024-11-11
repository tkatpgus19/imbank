package com.imb.km_system.buttons.controller;

import com.imb.km_system._common.response.ApiResponseDto;
import com.imb.km_system._common.response.MsgType;
import com.imb.km_system._common.response.ResponseUtils;
import com.imb.km_system.buttons.dto.request.UpdateButtonTitleRequest;
import com.imb.km_system.buttons.service.ButtonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/button")
public class ButtonController {

    private final ButtonService buttonService;

    // 버튼 리스트 조회
    @GetMapping("/list/{dept-id}")
    public ApiResponseDto<?> selectButtonList(@PathVariable(name = "dept-id") Long deptId) {
        return ResponseUtils.ok(buttonService.selectAll(deptId), MsgType.SELECT_BUTTON_LIST_SUCCESSFULLY);
    }

    // 메인 버튼 조회
    @GetMapping("/{dept-id}")
    public ApiResponseDto<?> selectMainButton(@PathVariable(name = "dept-id") Long deptId) {
        return ResponseUtils.ok(buttonService.select(deptId), MsgType.SELECT_MAIN_BUTTON_SUCCESSFULLY);
    }

    // 메인 버튼 등록
    @GetMapping("/{dept-id}/{btn-id}")
    public ApiResponseDto<?> updateMainButton(@PathVariable(name = "dept-id") Long deptId, @PathVariable(name = "btn-id") Long btnId) {
        return ResponseUtils.ok(buttonService.update(deptId, btnId), MsgType.INSERT_BUTTON_SUCCESSFULLY);
    }

    // 버튼 등록
    @PostMapping("/{dept-id}")
    public ApiResponseDto<?> registerButton(@PathVariable(name = "dept-id") Long deptId, @RequestBody String title) {
        return ResponseUtils.ok(buttonService.insert(deptId, title), MsgType.INSERT_BUTTON_SUCCESSFULLY);
    }

    // 버튼 삭제
    @DeleteMapping("/{dept-id}/{btn-id}")
    public ApiResponseDto<?> unregisterButton(@PathVariable(name = "dept-id") Long deptId, @PathVariable(name = "btn-id") Long btnId) {
        return ResponseUtils.ok(buttonService.delete(deptId, btnId), MsgType.DELETE_BUTTON_SUCCESSFULLY);
    }

    // 버튼 이름 변경
    @PutMapping("/{btn-id}")
    public ApiResponseDto<?> updateButtonTitle(@PathVariable(name = "btn-id") Long btnId, @RequestBody UpdateButtonTitleRequest request) {
        return ResponseUtils.ok(buttonService.updateTitle(btnId, request), MsgType.UPDATE_BUTTON_TITLE_SUCCESSFULLY);
    }

}
