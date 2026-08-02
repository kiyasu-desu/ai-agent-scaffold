package com.kiyasu.ai.test.api.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;

/**
 * Spring AI Test
 * 文档：<a href="https://docs.spring.io/spring-ai/reference/1.0/api/advisors.html">spring ai</a>
 * @author kiyasu github.com/kiyasu-desu/ai-agent-scaffold @kiyasu
 * 2025/12/14 09:15
 */
@Slf4j
public class SpringAiApiTest {

    public static void main(String[] args) {
        OpenAiApi openAiApi = OpenAiApi.builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey("sk-YOUR_DEEPSEEK_API_KEY")
                .build();

        ChatModel chatModel = OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("deepseek-v4-flash")
                        .build())
                .build();

        String call = chatModel.call("hi 你好哇!");

        log.info("测试结果:{}", call);
    }

}
