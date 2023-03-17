package com.example.engineerProject.Announcement.PropertiesOnlineApi.PropertiesOnlineDto.Agents;

import java.util.List;

public class Agents {
    private List<PropertiesOnlineAgent> agent;

    public List<PropertiesOnlineAgent> getAgent() {
        return agent;
    }

    public void setAgent(List<PropertiesOnlineAgent> agent) {
        this.agent = agent;
    }

    public void addPropertiesOnlineAgentDtoToAgentList(PropertiesOnlineAgent agentDto) {
        this.agent.add(agentDto);
    }
}
