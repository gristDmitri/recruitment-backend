package de.immocloud.recruiting.web.rest.controllers;

import de.immocloud.recruiting.exceptions.ApplicantNotFoundException;
import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;
import de.immocloud.recruiting.web.rest.dtos.ApplicantCreateDto;
import de.immocloud.recruiting.web.rest.dtos.ApplicantDto;
import de.immocloud.recruiting.services.ApplicantService;
import de.immocloud.recruiting.web.rest.dtos.ApplicantPatchDto;
import jakarta.validation.Valid;
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
    public List<ApplicantDto> findApplicants(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false) ApplicantStatus status) {
        return applicantService.findApplicants(name, status);
    }

    @PostMapping
    public ApplicantDto createApplicant(@RequestBody @Valid ApplicantCreateDto applicant) {
        return applicantService.createApplicant(applicant);
    }

    @PatchMapping("/{id}")
    public ApplicantDto patchApplicant(@PathVariable String id, @RequestBody ApplicantPatchDto applicantPatchDto) {
        return applicantService.patchApplicant(new ObjectId(id), applicantPatchDto);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ApplicantNotFoundException.class)
    public String handleApplicantNotFound(ApplicantNotFoundException ex) {
        return ex.getMessage();
    }
}
