package com.be.clover.model;

public enum Month {
	
	JANUARY("January"), 
	FEBRUARY("Febuary"), 
	MARCH("March"),
	APRIL("April"), 
	MAY("May"), 
	JUNE("June"),
	JULY("July"), 
	AUGUST("August"), 
	SEPTEMBER("September"),
	OCTOBER("October"), 
	NOVEMBER("November"), 
	DECEMBER("December");
	
	private String months;
	
	private Month(String months) {
		// TODO Auto-generated constructor stub
		this.months = months;
	}

	public Month typeFromMonth(String months) {
        for (Month type : Month.values()) {
            if (type.months.equals(months)) {
                return type;
            }
        }
        return null;
    }
	

}
