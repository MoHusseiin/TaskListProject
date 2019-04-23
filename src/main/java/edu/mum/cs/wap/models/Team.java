package edu.mum.cs.wap.models;

import java.io.PrintWriter;

public class Team {

    private Integer teamId;
    private String  projectName;
    private String  teamName;
    private Integer teamMangerId;
    private String [] teamUserIds;
    private Integer developerNums;

    public Integer getDeveloperNums() {
        return developerNums;
    }

    public void setDeveloperNums(Integer DeveloperNums) {
        developerNums = DeveloperNums;
    }



    public Team()
    {

    }
    public Team(Integer teamId, String projectName, String teamName, Integer teamMangerId , String [] teamUserIds ) {
        this.teamId = teamId;
        this.projectName = projectName;
        this.teamName = teamName;
        this.teamUserIds = teamUserIds;
    }
    public Team( String projectName, String teamName, Integer teamMangerId , String [] teamUserIds ) {

        this.projectName = projectName;
        this.teamName = teamName;
        this.teamMangerId = teamMangerId;
        this.teamUserIds = teamUserIds;
    }

    public String[] getTeamUserIds() {
        return teamUserIds;
    }

    public void setTeamUserIds(String[] teamUserIds) {
        this.teamUserIds = teamUserIds;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamMangerId() {
        return teamMangerId;
    }

    public void setTeamMangerId(Integer teamMangerId) {
        this.teamMangerId = teamMangerId;
    }
}
