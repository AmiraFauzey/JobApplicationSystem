package com.be.clover.model;

public enum JobType {
	
	FULLTIME(0),
    CONTRACT(1),
    INTERNSHIP(2),
	NEWGRAD(3),
	TEMPORARY(4),
	PARTTIME(5);

    private int value;

	private JobType (int value) {
        this.value = value;
    }

    public JobType typeFromValue(int value) {
        for (JobType type : JobType .values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
