package com.be.clover.model;

public enum JobRemote {
	
	    ONSITE(0),
	    REMOTE(1),
	    HYBRID(2);

	    private int value;

	    private JobRemote (int value) {
	        this.value = value;
	    }

	    public JobRemote typeFromValue(int value) {
	        for (JobRemote type : JobRemote.values()) {
	            if (type.value == value) {
	                return type;
	            }
	        }
	        return null;
	    }
}
