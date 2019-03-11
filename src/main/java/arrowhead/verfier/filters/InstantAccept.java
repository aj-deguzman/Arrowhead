package arrowhead.verfier.filters;

public class InstantAccept extends InstantReject {
    private boolean isInstantAccept;
    private boolean isSATACTAcceptable;
    private boolean reviewable;

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
	if (!String.valueOf(this.getSat()).isEmpty() && this.getSat() > 1920) {
	    this.setSATACTAcceptable(true);
	} else if (!String.valueOf(this.getAct()).isEmpty() && this.getAct() > 27) {
	    this.setSATACTAcceptable(true);
	} else {
	    this.setSATACTAcceptable(false);
	}
    }

    public void verifyInstantAccept() {
	if (this.isReject()) {
	    this.setInstantAccept(false);
	} else {
	    if (this.isAgeAcceptable() && this.isGPAScoreAcceptable() && this.isSATACTAcceptable()) {
		this.setInstantAccept(true);
	    } else {
		this.setReviewable(true);
	    }
	}
    }
}
