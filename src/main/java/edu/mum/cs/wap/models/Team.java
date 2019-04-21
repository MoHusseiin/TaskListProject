package edu.mum.cs.wap.models;

import java.io.PrintWriter;

public class Team {

    private Integer TeamID;
    private String ProjectName;
    private String TeamName;
    private Integer TeamMangerID;


    public Integer getTeamID() {
        return TeamID;
    }

    public void setTeamID(Integer teamID) {
        TeamID = teamID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public Integer getTeamMangerID() {
        return TeamMangerID;
    }

    public void setTeamMangerID(Integer teamMangerID) {
        TeamMangerID = teamMangerID;
    }



}
