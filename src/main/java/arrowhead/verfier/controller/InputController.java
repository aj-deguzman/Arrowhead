package arrowhead.verfier.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arrowhead.verfier.filters.InstantAccept;
import arrowhead.verfier.filters.InstantReject;
import arrowhead.verfier.model.Applicant;
import arrowhead.verfier.repository.ApplicantRepo;

@RestController
public class InputController {
    @Autowired
    ApplicantRepo ar;

    @PostMapping("/saveApplicant")
    public Applicant verifyApplicant(@Valid @RequestBody Applicant applicant) {
	return ar.save(applicant);
    }

    @GetMapping("/verify/{appId}")
    public String verifyApplicant(@PathVariable(value = "appId") Long appId) {
	Optional<Applicant> option = ar.findById(appId);
	Applicant app = option.get();
	InstantAccept ia = new InstantAccept();
	InstantReject ir = new InstantReject();
	String result = "";

	if (ir.isInstantReject()) {
	    result = "Instant Reject";
	} else if (ia.isInstantAccept() == true) {
	    result = "Instant Accept";
	} else if (ia.getReviewable() == true) {
	    result = "Further Review";
	}

	return result;

    }
}
