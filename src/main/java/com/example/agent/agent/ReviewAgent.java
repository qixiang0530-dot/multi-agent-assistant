
package com.example.agent.agent;

import com.example.agent.model.AgentResult;
import org.springframework.stereotype.Component;

@Component
public class ReviewAgent extends BaseAgent {
    @Override
    public AgentResult execute(String input) {
        return new AgentResult("ReviewAgent", "代码结构良好，建议增加异常处理");
    }
}
