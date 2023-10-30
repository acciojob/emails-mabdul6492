package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(!password.equals(oldPassword)) return;

        boolean[] valid = new boolean[5];
        if(newPassword.length() >= 8) valid[0] = true;
        for(char c: newPassword.toCharArray()){
            int lower = c-'a';
            int upper = c-'A';
            int digit = c-'0';
            if(upper >= 0 && upper < 26) valid[1] = true;
            else if(lower >= 0 && lower < 26) valid[2] = true;
            else if(digit >= 0 && digit < 10) valid[3] = true;
            else valid[4] = true;
        }

        for(boolean b: valid){
            if(!b) return;
        }

        password = newPassword;
    }
}
