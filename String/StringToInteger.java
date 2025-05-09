package String;

public class StringToInteger {
    public int myAtoi(String s) {
        // Step 1: Remove leading and trailing whitespaces from the string
        s = s.trim();
    
        int sign = 1, len = s.length(), i = 0;    // sign (default positive)
    
        // Step 2: If the string is empty after trimming, return 0 (invalid number)
        if(len == 0) return 0;
    
        // Step 3: Handle sign for negative numbers
        if(s.charAt(0) == '-'){
            sign = -1; 
            i++;  // Move index to next character
        }
        // Step 4: Handle sign for positive numbers (optional)
        else if(s.charAt(0) == '+')
            i++;  // Move index to next character
    
        long result = 0;  // use long to avoid overflow during calculation

        // Step 5: Process each character
        while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){  // While the character is a digit
        
            result = (result * 10) + (s.charAt(i) - '0');  // Append the current digit to the result
            i++; 
        
            // Step 6: Check for overflow and underflow
            if (result > Integer.MAX_VALUE) 
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
        }

        // Multiply result by the sign (positive or negative) and cast it to int
        return (int)(result *= sign);  
    }

}
