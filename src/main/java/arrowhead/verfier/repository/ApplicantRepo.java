package arrowhead.verfier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arrowhead.verfier.model.Applicant;

public interface ApplicantRepo extends JpaRepository<Applicant, Long> {

}