package com.project.voting.RestController;

import com.project.voting.model.Records;
import com.project.voting.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voting")
public class EndController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/record")
    public Records saveRecords(@RequestBody Records Records) {
        return votingService.saveRecord(Records);
    }

    @GetMapping("/record/{id}")
    public Records getRecordsById(@PathVariable String id) {
        return votingService.getRecordsById(id);
    }

    @GetMapping("/records")
    public List<Records> getAllRecords() {
        return votingService.getAllRecordss();
    }

    @PutMapping("/vote")
    public Records voteForCandidate(@RequestParam String constituencyName, @RequestParam String partyName) {
        return votingService.voteForCandidate(constituencyName, partyName);
    }
}
