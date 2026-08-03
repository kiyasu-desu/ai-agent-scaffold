package com.kiyasu.ai.domain.agent.model.valobj;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AiAgentConfigTableVO {

    private String appName;

    private Agent agent;

    private Module module;

    @Data
    public static class Agent {
        private String agentId;
        private String agentName;
        private String agentDesc;
    }

    @Data
    public static class Module {

        private AiApi aiApi;

        private ChatModel chatModel;

        private List<Agent> agents;

        private List<AgentWorkflow> agentWorkflows;

        @Data
        public static class AiApi {
            private String baseUrl;
            private String apiKey;
            private String completionsPath;
            private String embeddingsPath;
        }

        @Data
        public static class ChatModel {

            private String model;

            private List<ToolMcp> toolMcpList;

            @Data
            public static class ToolMcp {

                private SSEServerParameters sse;

                private StdioServerParameters stdio;

                @Data
                public static class SSEServerParameters {
                    private String name;
                    private String baseUri;
                    private String sseEndpoint;
                    private Integer requestTimeout = 3000;
                }

                @Data
                public static class StdioServerParameters {
                    private String name;
                    private Integer requestTimeout = 3000;
                    private ServerParameters serverParameters;

                    @Data
                    public static class ServerParameters {
                        private String command;
                        private List<String> args;
                        private Map<String, String> env;
                    }
                }
            }


        }

        @Data
        public static class Agent {
            private String name;
            private String description;
            private String instruction;
            private String outputKey;
        }

        @Data
        public static class AgentWorkflow {
            private String type;
            private String name;
            private List<String> subAgent;
            private String description;
            private Integer maxIterations = 3;
        }

    }

}
