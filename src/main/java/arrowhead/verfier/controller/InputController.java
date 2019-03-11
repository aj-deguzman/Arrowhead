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
	String result = "";

	ia.setFirstName(app.getFirstName());
	ia.setLastName(app.getLastName());
	ia.setState(app.getState());
	ia.setAge(app.getAge());
	ia.setGpa(app.getGpa());
	ia.setGpaScale(app.getGpaScale());
	ia.setSat(app.getSat());
	ia.setAct(app.getAct());
	ia.setFelonies(app.getFelonies());
	ia.setLatestFelonyAge(app.getlatestFelonyAge());

	if (ia.isInstantAccept()) {
	    result = "Instant Accept";
	} else if (!ia.isInstantAccept()) {
	    result = "Instant Reject";
	} else if (ia.getReviewable()) {
	    result = "Further Review";
	}

	return result;

    }
}
