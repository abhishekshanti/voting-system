package com.project.voting.service;

import com.project.voting.model.Candidate;
import com.project.voting.model.Records;
import com.project.voting.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotingService {

    @Autowired
    public CandidateRepository candidateRepository;

    public Records saveRecord(Records r) {
        return candidateRepository.save(r);
    }

    public Records getRecordsById(String id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public List<Records> getAllRecordss() {
        return candidateRepository.findAll();
    }

    public Records voteForCandidate(String constituencyName, String partyName) {
        Optional<Records> optionalRecord = candidateRepository.findByConstituencyName(constituencyName);

        if (optionalRecord.isPresent()) {
            Records record = optionalRecord.get();
            for (Candidate candidate : record.getCandidates()) {
                if (candidate.getPartyName().equals(partyName)) {
                    candidate.setVotes(candidate.getVotes() + 1);
                    candidateRepository.save(record);
                    return record;
                }
            }
        }
        return null; // Or throw an exception if appropriate
    }

}
