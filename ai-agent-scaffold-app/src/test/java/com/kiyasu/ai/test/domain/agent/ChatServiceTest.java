package com.kiyasu.ai.test.domain.agent;

import com.alibaba.fastjson.JSON;
import com.kiyasu.ai.domain.agent.model.entity.ChatCommandEntity;
import com.kiyasu.ai.domain.agent.service.IChatService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatServiceTest {

    @Resource
    private IChatService chatService;

    @Value("classpath:file/dog.png")
    private org.springframework.core.io.Resource imageResource;

    @Test
    public void test_handleMessage_01() {
        List<String> message = chatService.handleMessage("100004", "kiyasu", "基于 skills 解答，电脑性能优化");
        log.info("测试结果:{}", JSON.toJSONString(message));
    }

    @Test
    public void test_handleMessage_04_withImage() throws IOException {
        String agentId = "100004";
        String userId = "kiyasu";

        String session = chatService.createSession(agentId, userId);

        ChatCommandEntity chatCommandEntity = ChatCommandEntity.builder()
                .agentId(agentId)
                .userId(userId)
                .sessionId(session)
                .texts(List.of(new ChatCommandEntity.Content.Text("请识别这个图片，告诉我这是什么动物，并用一句话描述。")))
                .files(List.of())
                .inlineDatas(List.of(new ChatCommandEntity.Content.InlineData(imageResource.getContentAsByteArray(), MimeTypeUtils.IMAGE_PNG_VALUE)))
                .build();

        List<String> message = chatService.handleMessage(chatCommandEntity);
        log.info("测试结果:{}", JSON.toJSONString(message));
    }
}
