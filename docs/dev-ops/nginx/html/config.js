/**
 * =============================================================
 *  AI 智能体 · 前端全局配置文件
 *  统一维护：接口根地址、接口路径、Cookie 名称、页面路由
 * =============================================================
 */
window.AI_AGENT_CONFIG = {
    // 接口访问根地址
    API_BASE_URL: 'http://127.0.0.1:8091',

    // 接口路径
    API: {
        // 查询智能体配置列表（GET）
        QUERY_AGENT_CONFIG_LIST: '/api/v1/query_ai_agent_config_list',
        // 创建会话，返回 sessionId（POST body: {agentId, userId}）
        CREATE_SESSION: '/api/v1/create_session',
        // 智能体对话（POST body: {agentId, userId, sessionId, message}）
        CHAT: '/api/v1/chat',
        // 流式对话（POST body: 同 CHAT）
        CHAT_STREAM: '/api/v1/chat_stream'
    },

    // 登录 Cookie 名称（与 login.html 保持一致）
    COOKIE: {
        TOKEN: 'ai_agent_token',
        USER: 'ai_agent_user'
    },

    // 页面路由
    PAGES: {
        LOGIN: './login.html',
        INDEX: './index.html'
    },

    // 接口成功码
    SUCCESS_CODE: '0000'
};
