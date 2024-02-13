package com.example.catchjeon_back;

import com.example.catchjeon_back.dto.RegisterForm;
import com.example.catchjeon_back.repository.RegisterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; //직렬화, 역직렬화를 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    RegisterRepository registerRepository;

    @BeforeEach
    public void MockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        registerRepository.deleteAll();
    }

    // 유효한 경우
    @DisplayName("RegisterForm: mail 유효성 검사 - 유효하지 않은 경우")
    @Test
    public void testRegisterForm_mail_nickname_success() throws Exception {
        //given
        RegisterForm request = new RegisterForm();
        request.setMail("aaa@naver.com");
        request.setNickname("마마마마");

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                //then
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // 유효하지 않은 경우
    @DisplayName("RegisterForm: mail 유효성 검사 - 유효하지 않은 경우")
    @Test
    public void testRegisterForm_mail_nickname_fail() throws Exception {
        //given
        RegisterForm request = new RegisterForm();
        request.setMail("ㅁㅇㄹㅁㅇㄹㅁㄹㅇㅁ");
        request.setNickname("마마마마마마마마맘마마마마마");

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                //then
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("이메일 형식으로 써주세요. 닉네임 글자 수는 10자리를 넘을 수 없습니다. "));
    }
    // 객체를 JSON 문자열로 변환하는 유틸리티 메서드
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
