package org.example.stockinvestment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 전체 컨텍스트로 메인 페이지 렌더링 검증.
 * (@WebMvcTest 슬라이스는 @MapperScan 이 SqlSessionFactory 를 요구해 사용 불가.
 *  DB 커넥션은 지연 연결이므로 Oracle 이 꺼져 있어도 이 테스트는 동작한다.)
 */
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 메인페이지_기존과_동일하게_표시() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(containsString("<div class=\"stock-name\">삼성전자</div>")))
                .andExpect(content().string(containsString("<div class=\"stock-price\">72,500원</div>")))
                .andExpect(content().string(containsString("<div class=\"stock-change rise\">+1,200 (+1.68%)</div>")))
                .andExpect(content().string(containsString("<div class=\"stock-change fall\">-2,500 (-1.46%)</div>")));
    }
}
