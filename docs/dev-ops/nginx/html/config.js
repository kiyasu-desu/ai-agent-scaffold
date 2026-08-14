(function (global) {
  global.AI_AGENT_CONFIG = {
    // 后端服务根地址，部署时可按需修改
    apiBaseUrl: "http://127.0.0.1:8091",
    endpoints: {
      queryAiAgentConfigList: "/api/v1/query_ai_agent_config_list",
      createSession: "/api/v1/create_session",
      chat: "/api/v1/chat",
      chatStream: "/api/v1/chat_stream"
    }
  };
})(window);
