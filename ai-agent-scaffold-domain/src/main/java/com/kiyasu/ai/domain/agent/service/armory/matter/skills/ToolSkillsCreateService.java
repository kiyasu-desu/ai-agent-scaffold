package com.kiyasu.ai.domain.agent.service.armory.matter.skills;

import com.kiyasu.ai.domain.agent.model.valobj.AiAgentConfigTableVO;
import org.springframework.ai.tool.ToolCallback;

import java.net.MalformedURLException;

public interface ToolSkillsCreateService {

    ToolCallback[] buildToolCallback(AiAgentConfigTableVO.Module.ChatModel.ToolSkills toolSkills) throws MalformedURLException;


}
