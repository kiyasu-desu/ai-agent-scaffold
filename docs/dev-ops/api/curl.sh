curl https://api.deepseek.com/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${DEEPSEEK_API_KEY:-YOUR_DEEPSEEK_API_KEY}" \
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