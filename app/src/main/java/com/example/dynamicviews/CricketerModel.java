package com.example.dynamicviews;

public class CricketerModel {
    public String cricketerName;
    public String teamName;

    public CricketerModel(){

    }

    public CricketerModel(String cricketerName, String teamName) {
        this.cricketerName = cricketerName;
        this.teamName = teamName;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public void setCricketerName(String cricketerName) {
        this.cricketerName = cricketerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
