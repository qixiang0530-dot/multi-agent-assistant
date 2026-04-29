
package com.example.agent.agent;

import com.example.agent.model.AgentResult;
import org.springframework.stereotype.Component;

@Component
public class CodeGenAgent extends BaseAgent {
    @Override
    public AgentResult execute(String input) {
        String code = "public class Demo { public static void main(String[] args){ System.out.println(\"Hello Agent\"); }}";
        return new AgentResult("CodeGenAgent", code);
    }
}
