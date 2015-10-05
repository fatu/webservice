package com.cave.prog.spring.test;

public class Address {
	private String street;
	private String postcode;

	public Address() {
	}

	public Address(String street, String postcode) {
		this.street = street;
		this.postcode = postcode;
	}
	
	public void init() {
//		System.out.println("Bean created: " + this);
	}

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    @Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}
	
	
}
