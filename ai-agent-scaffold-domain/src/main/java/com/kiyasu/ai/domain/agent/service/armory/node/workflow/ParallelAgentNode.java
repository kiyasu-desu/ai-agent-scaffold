package com.kiyasu.ai.domain.agent.service.armory.node.workflow;

import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LoopAgent;
import com.google.adk.agents.ParallelAgent;
import com.kiyasu.ai.domain.agent.model.entity.ArmoryCommandEntity;
import com.kiyasu.ai.domain.agent.model.valobj.AiAgentConfigTableVO;
import com.kiyasu.ai.domain.agent.model.valobj.AiAgentRegisterVO;
import com.kiyasu.ai.domain.agent.model.valobj.enums.AgentTypeEnum;
import com.kiyasu.ai.domain.agent.service.armory.AbstractArmorySupport;
import com.kiyasu.ai.domain.agent.service.armory.factory.DefaultArmoryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ParallelAgentNode extends AbstractArmorySupport {
    @Override
    protected AiAgentRegisterVO doApply(ArmoryCommandEntity requestParameter, DefaultArmoryFactory.DynamicContext dynamicContext) throws Exception {
        log.info("Ai Agent 装配操作 - ParallelAgentNode");

        List<AiAgentConfigTableVO.Module.AgentWorkflow> agentWorkflows = dynamicContext.getAgentWorkflows();
        AiAgentConfigTableVO.Module.AgentWorkflow agentWorkflow = agentWorkflows.remove(0);

        List<String> subAgentNames = agentWorkflow.getSubAgent();
        List<BaseAgent> subAgents = dynamicContext.queryAgentList(subAgentNames);

        ParallelAgent parallelAgent = ParallelAgent.builder()
                .name(agentWorkflow.getName())
                .subAgents(subAgents)
                .description(agentWorkflow.getDescription())
                .build();


        dynamicContext.getAgentGroup().put(agentWorkflow.getName(), parallelAgent);


        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<ArmoryCommandEntity, DefaultArmoryFactory.DynamicContext, AiAgentRegisterVO> get(ArmoryCommandEntity requestParameter, DefaultArmoryFactory.DynamicContext dynamicContext) throws Exception {
        List<AiAgentConfigTableVO.Module.AgentWorkflow> agentWorkflows = dynamicContext.getAgentWorkflows();

        if (null == agentWorkflows || agentWorkflows.isEmpty()) {
            return defaultStrategyHandler;
        }

        AiAgentConfigTableVO.Module.AgentWorkflow agentWorkflow = agentWorkflows.get(0);

        String type = agentWorkflow.getType();

        AgentTypeEnum agentTypeEnum = AgentTypeEnum.formType(type);

        if (null == agentTypeEnum) {
            throw new RuntimeException("agentWorkflows type is error!");
        }

        String node = agentTypeEnum.getNode();

        return switch (node) {
            case "loopAgentNode" -> getBean("loopAgentNode");
            case "sequentialAgentNode" -> getBean("sequentialAgentNode");
            default -> defaultStrategyHandler;
        };
    }
}
