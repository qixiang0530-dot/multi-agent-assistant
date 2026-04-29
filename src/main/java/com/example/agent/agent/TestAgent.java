
package com.example.agent.agent;

import com.example.agent.model.AgentResult;
import org.springframework.stereotype.Component;

@Component
public class TestAgent extends BaseAgent {
    @Override
    public AgentResult execute(String input) {
        String test = "@Test public void test(){ assert true; }";
        return new AgentResult("TestAgent", test);
    }
}
