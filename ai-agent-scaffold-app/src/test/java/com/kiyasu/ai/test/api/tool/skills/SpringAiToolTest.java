package com.kiyasu.ai.test.api.tool.skills;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springaicommunity.agent.tools.SkillsTool;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.core.io.ClassPathResource;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;

/**
 * Spring Ai Tool
 *
 * @author kiyasu github.com/kiyasu-desu/ai-agent-scaffold @kiyasu
 * 2025/12/14 09:51
 */
@Slf4j
public class SpringAiToolTest {

    public static void main(String[] args) {
        OpenAiApi openAiApi = OpenAiApi.builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey("sk-YOUR_DEEPSEEK_API_KEY")
                .build();

//        ToolCallback toolCallback01 = SkillsTool.builder()
//                .addSkillsDirectory("D:\\code\\xfgJavaStudy\\ai-agent-scaffold-lite\\my-code\\ai-agent-scaffold\\docs\\dev-ops\\agent\\skills")
//                .build();

        ToolCallback toolCallback02 = SkillsTool.builder()
                .addSkillsResource(new ClassPathResource("agent/skills"))
                .build();

        ChatModel chatModel = OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("deepseek-v4-flash")
                        .toolCallbacks(new ArrayList<>() {
                            {
                                add(toolCallback02);
                            }
                        })
                        .build())
                .build();

        String call = chatModel.call("基于 skills 解答，电脑性能优化");

        log.info("测试结果:{}", call);
    }

}
