package arrowhead.verfier.filters;

import arrowhead.verfier.model.Applicant;

public abstract class CommonVerficiation {
    private boolean isAgeAcceptable;
    private boolean isGPAScoreAcceptable;

    Applicant applicant;

    public boolean isAgeAcceptable() {
	return isAgeAcceptable;
    }

    private void setAgeAcceptable(boolean isAgeAcceptable) {
	this.isAgeAcceptable = isAgeAcceptable;
    }

    public boolean isGPAScoreAcceptable() {
	return isGPAScoreAcceptable;
    }

    protected void setGPAScoreAcceptable(boolean isGPAScoreAcceptable) {
	this.isGPAScoreAcceptable = isGPAScoreAcceptable;
    }

    public void verifyAge() {
	if (applicant.getState().equals("CA")) {
	    if ((applicant.getAge() >= 17 && applicant.getAge() <= 26) || applicant.getAge() > 80) {
		setAgeAcceptable(true);
	    } else {
		setAgeAcceptable(false);
	    }
	} else {
	    setAgeAcceptable(false);
	}
    }

    public void verifyGPAScore() {
	double decimalPerc = applicant.getGpa() / applicant.getGpaScale();
	double perc = decimalPerc * 100;

	if (perc >= 90) {
	    setGPAScoreAcceptable(true);
	} else {
	    setGPAScoreAcceptable(false);
	}
    }
}
