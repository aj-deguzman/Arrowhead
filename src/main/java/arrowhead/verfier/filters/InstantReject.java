package arrowhead.verfier.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstantReject extends CommonVerficiation {
    private boolean isInstantReject;
    private boolean isFelonyAcceptable;
    private boolean nameInputAcceptable;

    public InstantReject() {
	isReject();
    }

    public boolean isInstantReject() {
	return isInstantReject;
    }

    private void setInstantReject(boolean isInstantReject) {
	this.isInstantReject = isInstantReject;
    }

    public boolean isFelonyAcceptable() {
	return isFelonyAcceptable;
    }

    private void setFelonyAcceptable(boolean isFelonyAcceptable) {
	this.isFelonyAcceptable = isFelonyAcceptable;
    }

    public boolean isNameInputAcceptable() {
	return nameInputAcceptable;
    }

    private void setNameInputAcceptable(boolean nameInputAcceptable) {
	this.nameInputAcceptable = nameInputAcceptable;
    }

    @Override
    public void verifyGPAScore() {
	double decimalPerc = applicant.getGpa() / applicant.getGpaScale();
	double perc = decimalPerc * 100;

	if (perc < 70) {
	    setGPAScoreAcceptable(false);
	} else {
	    setGPAScoreAcceptable(true);
	}
    }

    public void verifyFelony() {
	if (applicant.getFelonies() > 0) {
	    if (applicant.getlatestFelonyAge() < 5) {
		setFelonyAcceptable(false);
	    } else {
		setFelonyAcceptable(true);
	    }
	}
    }

    public void verifyNameInput() {
	Pattern p = Pattern.compile("^[A-Z]+$");
	Matcher first = p.matcher(applicant.getFirstName().substring(1));
	Matcher last = p.matcher(applicant.getLastName().substring(1));

	if ((Character.isLowerCase(applicant.getFirstName().charAt(0))
		|| Character.isLowerCase(applicant.getLastName().charAt(0)))) {
	    setNameInputAcceptable(false);
	} else if (first.matches() || last.matches()) {
	    setNameInputAcceptable(false);
	} else {
	    setNameInputAcceptable(true);
	}
    }

    private void isReject() {
	if (this.isFelonyAcceptable() && this.isNameInputAcceptable() && this.isGPAScoreAcceptable()) {
	    setInstantReject(true);
	} else {
	    setInstantReject(false);
	}
    }
}
