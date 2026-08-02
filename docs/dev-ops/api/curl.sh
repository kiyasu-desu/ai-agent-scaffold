curl https://api.deepseek.com/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer sk-7693119c158e43e390578d36a9526a94" \
  -d '{
        "model": "deepseek-v4-flash",
        "messages": [
            {
              "role": "user",
              "content": "1+1"
            }
          ],
        "thinking": {"type": "enabled"},
        "reasoning_effort": "high",
        "stream": true
      }'