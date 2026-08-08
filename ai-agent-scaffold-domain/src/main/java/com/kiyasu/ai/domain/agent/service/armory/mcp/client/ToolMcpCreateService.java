package com.kiyasu.ai.domain.agent.service.armory.mcp.client;

import com.kiyasu.ai.domain.agent.model.valobj.AiAgentConfigTableVO;
import org.springframework.ai.tool.ToolCallback;

import java.net.MalformedURLException;

/**
 * 工具 mcp 构建服务
 */
public interface ToolMcpCreateService {

    ToolCallback[] buildToolCallback(AiAgentConfigTableVO.Module.ChatModel.ToolMcp toolMcp) throws MalformedURLException;

}
