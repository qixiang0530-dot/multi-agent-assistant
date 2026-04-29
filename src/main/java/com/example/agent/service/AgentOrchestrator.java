
package com.example.agent.service;

import com.example.agent.agent.CodeGenAgent;
import com.example.agent.agent.TestAgent;
import com.example.agent.agent.ReviewAgent;
import com.example.agent.model.AgentResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentOrchestrator {

    private final CodeGenAgent codeGenAgent;
    private final TestAgent testAgent;
    private final ReviewAgent reviewAgent;

    public AgentOrchestrator(CodeGenAgent codeGenAgent, TestAgent testAgent, ReviewAgent reviewAgent) {
        this.codeGenAgent = codeGenAgent;
        this.testAgent = testAgent;
        this.reviewAgent = reviewAgent;
    }

    public List<AgentResult> runWorkflow(String requirement) {
        List<AgentResult> results = new ArrayList<>();

        AgentResult code = codeGenAgent.execute(requirement);
        results.add(code);

        AgentResult test = testAgent.execute(code.getOutput());
        results.add(test);

        AgentResult review = reviewAgent.execute(code.getOutput());
        results.add(review);

        return results;
    }
}
