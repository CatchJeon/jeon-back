package com.example.catchjeon_back.controller;

import com.example.catchjeon_back.dto.RegisterForm;
import com.example.catchjeon_back.entity.Register;
import com.example.catchjeon_back.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/register")
    public ResponseEntity<?> create_register(@Valid @RequestBody RegisterForm dto,
                                             BindingResult bindingResult){
        // 유효성 검사 오류가 발생한 경우
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println(field.getField() + ": " + message);

                sb.append("field: " + field.getField());
                sb.append("message: " + message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        //유효성 검사 통과 후 처리(DB에 저장됨)
        Register created = registerService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
