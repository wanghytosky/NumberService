package com.number.common;

import java.util.regex.Pattern;

public class Validator {
	
	public static final String REGEX_MOBILE  = "^\\d{8,10}$";
	
	public static final String REGEX_USERNAME  = "^[a-zA-Z\\s]+"; 
	
	/**
     * valid mobile
     *
     * @param mobile
     * @return success : true
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
    
    /**
     * valid user name
     *
     * @param username
     * @return success : true
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }
}
