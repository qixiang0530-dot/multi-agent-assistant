
package com.example.agent.controller;

import com.example.agent.model.TaskRequest;
import com.example.agent.model.AgentResult;
import com.example.agent.service.AgentOrchestrator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentOrchestrator orchestrator;

    public AgentController(AgentOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping("/run")
    public List<AgentResult> run(@RequestBody TaskRequest request) {
        return orchestrator.runWorkflow(request.getRequirement());
    }
}
