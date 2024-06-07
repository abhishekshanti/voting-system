package com.project.voting.model;

public class Candidate {
    private String partyName;
    private String candidateName;
    private int votes;



    public Candidate(String partyName, String candidateName, int votes) {
        this.partyName = partyName;
        this.candidateName = candidateName;
        this.votes = votes;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
