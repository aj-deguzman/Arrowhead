package arrowhead.verfier.filters;

public abstract class CommonVerficiation {
    private String firstName;
    private String lastName;
    private String state;
    private int age;
    private double gpa;
    private double gpaScale;
    private int sat;
    private int act;
    private int felonies;
    private int latestFelonyAge;
    private String results;
    private boolean isAgeAcceptable;
    private boolean isGPAScoreAcceptable;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public double getGpa() {
	return gpa;
    }

    public void setGpa(double gpa) {
	this.gpa = gpa;
    }

    public double getGpaScale() {
	return gpaScale;
    }

    public void setGpaScale(double gpaScale) {
	this.gpaScale = gpaScale;
    }

    public int getSat() {
	return sat;
    }

    public void setSat(int sat) {
	this.sat = sat;
    }

    public int getAct() {
	return act;
    }

    public void setAct(int act) {
	this.act = act;
    }

    public int getFelonies() {
	return felonies;
    }

    public void setFelonies(int felonies) {
	this.felonies = felonies;
    }

    public int getLatestFelonyAge() {
	return latestFelonyAge;
    }

    public void setLatestFelonyAge(int latestFelonyAge) {
	this.latestFelonyAge = latestFelonyAge;
    }

    public String getResults() {
	return results;
    }

    public void setResults(String results) {
	this.results = results;
    }

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
	if (this.getState().equals("CA")) {
	    if ((this.getAge() >= 17 && this.getAge() <= 26) || this.getAge() > 80) {
		this.setAgeAcceptable(true);
	    } else {
		this.setAgeAcceptable(false);
	    }
	} else {
	    this.setAgeAcceptable(false);
	}
    }

    public void verifyGPAScore() {
	double decimalPerc = this.getGpa() / this.getGpaScale();
	double perc = decimalPerc * 100;

	if (perc >= 90) {
	    this.setGPAScoreAcceptable(true);
	} else {
	    this.setGPAScoreAcceptable(false);
	}
    }
}
