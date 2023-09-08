import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class EmailValidator //class to validate email
{
	 private Pattern pattern;
	    private Matcher matcher;

	    //final pattern
	    private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    //Method to match the pattern
	    public EmailValidator() {
	        pattern = Pattern.compile(EMAIL_PATTERN);
	    }

	    public boolean validate(final String hex) {

	        matcher = pattern.matcher(hex);
	        return matcher.matches();

	    }

}

/*
/*************************************************************************************************
*  Course_Name – Assignment x                                                                                                                                *

*  I declare that this assignment is my own work in accordance with Humber Academic Policy.        *

*  No part of this assignment has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: Karan Punjabi and Richu Thankachan Student ID: N01514624 & N01516068 Date: 05-07-2022 
*/
