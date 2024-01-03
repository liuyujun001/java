package com.example.junit5demo.controller;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.annotation.JunitPerfRequire;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class GoodsControllerTest {

    private MockHttpSession session;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setupMockMvc() {
        //设置mvc
        session = new MockHttpSession();
    }


    /**
     * 配置：2个线程运行。准备时间：1000ms。运行时间: 2000ms。
     * 要求：最快不可低于 210ms, 最慢不得低于 250ms, 平均不得低于 225ms, 每秒运行次数不得低于 4 次。
     * 20% 的数据不低于 220ms, 50% 的数据不得低于 230ms;
     *
     * @throws InterruptedException if any
     */
    @JunitPerfConfig(threads = 2, warmUp = 1000, duration = 2000, reporter = {HtmlReporter.class})
    @JunitPerfRequire(min = 210, max = 250, average = 225, timesPerSecond = 4, percentiles = {"20:220", "50:230"})
    @Test
    void queryGood() throws Exception {
        MvcResult mvcResult = (MvcResult) mvc.perform(MockMvcRequestBuilders.get("/queryGood")
                .accept(MediaType.ALL)
                .session(session)
                .param("name", "cc")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String result = mvcResult.getResponse().getContentAsString();
        log.info("status是:{},内容是:{}", status, result);
    }

    @Test
    void countGood() throws Exception {
        String body = "{\"id\":1,\"name\":\"cc\",\"status\":2}";
        MvcResult mvcResult = (MvcResult) mvc.perform(MockMvcRequestBuilders.post("/countGood")
                .accept(MediaType.ALL)
                .session(session)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String result = mvcResult.getResponse().getContentAsString();
        log.info("status是:{},内容是:{}", status, result);
    }
}