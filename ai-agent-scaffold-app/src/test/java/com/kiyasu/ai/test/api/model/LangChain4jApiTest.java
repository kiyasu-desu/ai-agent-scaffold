package com.kiyasu.ai.test.api.model;

import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.extern.slf4j.Slf4j;

/**
 * LangChain4j
 * <p>
 * 文档：<a href="https://docs.langchain4j.info/">langchain4j</a>
 * 案例：<a href="https://github.com/langchain4j/langchain4j-examples">langchain4j-examples</a>
 *
 * @author kiyasu github.com/kiyasu-desu/ai-agent-scaffold @kiyasu
 * 2025/12/14 09:20
 */
@Slf4j
public class LangChain4jApiTest {

    public static void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey("sk-YOUR_DEEPSEEK_API_KEY")
                .modelName("deepseek-v4-flash")
                .build();

        String chat = model.chat("hi 你好哇!");
        log.info("测试结果:{}", chat);
    }

}
