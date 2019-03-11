package arrowhead.verfier.filters;

public class InstantAccept extends CommonVerficiation {
    private boolean isInstantAccept;
    private boolean isSATACTAcceptable;
    private boolean reviewable;

    public InstantAccept() {
	verifyInstantAccept();
    }

    public boolean isInstantAccept() {
	return isInstantAccept;
    }

    private void setInstantAccept(boolean isIntantAccept) {
	this.isInstantAccept = isIntantAccept;
    }

    public boolean isSATACTAcceptable() {
	return isSATACTAcceptable;
    }

    private void setSATACTAcceptable(boolean isSATACTAccpetable) {
	this.isSATACTAcceptable = isSATACTAccpetable;
    }

    public boolean getReviewable() {
	return reviewable;
    }

    private void setReviewable(boolean reviewable) {
	this.reviewable = reviewable;
    }

    public void verifySATOrACT() {
	int sat = applicant.getSat();
	int act = applicant.getAct();

	if (!String.valueOf(sat).isEmpty() && applicant.getSat() > 1920) {
	    setSATACTAcceptable(true);
	} else if (!String.valueOf(act).isEmpty() && applicant.getAct() > 27) {
	    setSATACTAcceptable(true);
	} else {
	    setSATACTAcceptable(false);
	}
    }

    public void verifyInstantAccept() {
	InstantReject ir = new InstantReject();

	if (ir.isInstantReject()) {
	    setInstantAccept(false);
	} else {
	    if (this.isAgeAcceptable() && this.isGPAScoreAcceptable() && this.isSATACTAcceptable()) {
		setInstantAccept(true);
	    } else {
		setReviewable(true);
	    }
	}
    }
}
