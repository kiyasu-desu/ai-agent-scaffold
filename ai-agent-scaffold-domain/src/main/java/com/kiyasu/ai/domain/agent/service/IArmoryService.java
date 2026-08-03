package com.kiyasu.ai.domain.agent.service;

import com.kiyasu.ai.domain.agent.model.valobj.AiAgentConfigTableVO;

import java.util.List;

public interface IArmoryService {

    void acceptArmoryAgents(List<AiAgentConfigTableVO> tables) throws Exception;

}
