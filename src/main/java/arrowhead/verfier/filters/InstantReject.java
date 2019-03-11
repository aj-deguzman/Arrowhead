package arrowhead.verfier.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstantReject extends CommonVerficiation {
    private boolean isFelonyAcceptable;
    private boolean nameInputAcceptable;
    private int felonyAge;

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

    public int getFelonyAge() {
	return felonyAge;
    }

    public void setFelonyAge(int felonyAge) {
	this.felonyAge = felonyAge;
    }

    @Override
    public void verifyGPAScore() {
	double decimalPerc = getGpa() / getGpaScale();
	double perc = decimalPerc * 100;

	if (perc < 70) {
	    this.setGPAScoreAcceptable(false);
	} else {
	    this.setGPAScoreAcceptable(true);
	}
    }

    public void verifyFelony() {
	if (this.getFelonies() > 0) {
	    if (this.getFelonyAge() < 5) {
		this.setFelonyAcceptable(false);
	    } else {
		this.setFelonyAcceptable(true);
	    }
	}
    }

    public void verifyNameInput() {
	Pattern p = Pattern.compile("^[A-Z]+$");
	Matcher first = p.matcher(this.getFirstName().substring(1));
	Matcher last = p.matcher(this.getLastName().substring(1));

	if ((Character.isLowerCase(getFirstName().charAt(0)) || Character.isLowerCase(getLastName().charAt(0)))) {
	    this.setNameInputAcceptable(false);
	} else if (first.matches() || last.matches()) {
	    this.setNameInputAcceptable(false);
	} else {
	    this.setNameInputAcceptable(true);
	}
    }

    public boolean isReject() {
	if (this.isFelonyAcceptable() && this.isNameInputAcceptable() && this.isGPAScoreAcceptable()) {
	    return true;
	} else {
	    return false;
	}
    }
}
