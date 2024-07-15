package de.immocloud.recruiting.web.rest.controllers;

import de.immocloud.recruiting.exceptions.ApplicantNotFoundException;
import de.immocloud.recruiting.web.rest.dtos.ApplicantDto;
import de.immocloud.recruiting.services.ApplicantService;
import de.immocloud.recruiting.web.rest.dtos.StoreApplicantDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<ApplicantDto> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public ApplicantDto getApplicantById(@PathVariable String id) {
        ApplicantDto applicant = applicantService.getApplicantById(new ObjectId(id));
        return applicant;
    }

    @PostMapping
    public ApplicantDto createApplicant(@RequestBody StoreApplicantDto applicant) {
        return applicantService.createApplicant(applicant);
    }

    @PutMapping("/{id}")
    public ApplicantDto updateApplicant(@PathVariable String id, @RequestBody StoreApplicantDto storeApplicantDto) {
        return applicantService.updateApplicant(new ObjectId(id), storeApplicantDto);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable String id) {
        applicantService.deleteApplicant(new ObjectId(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ApplicantNotFoundException.class)
    public String handleApplicantNotFound(ApplicantNotFoundException ex) {
        return ex.getMessage();
    }
}
