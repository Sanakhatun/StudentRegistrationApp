package com.professional.studentregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.professional.studentregistrationapp.utils.Utilities;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout tl_firstName, tl_lastName, tl_dob, tl_email, tl_mobileNumber,
                tl_password, tl_confirmPassword;

    private TextInputEditText et_firstName, et_lastName, et_dob, et_email, et_mobileNumber,
            et_password, et_confirmPassword;

    private Button btn_register;

    private String firstName, lastName, dob, email, mobileNumber, password, confirmPassword;

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
        initListeners();
    }

    /**
     * Initialise Views
     */

    private void init(){

        try{

            tl_firstName = findViewById(R.id.tl_firstName);
            tl_lastName = findViewById(R.id.tl_lastName);
            tl_dob = findViewById(R.id.tl_dob);
            tl_email = findViewById(R.id.tl_email);
            tl_password = findViewById(R.id.tl_password);
            tl_confirmPassword = findViewById(R.id.tl_confirmPassword);
            tl_mobileNumber = findViewById(R.id.tl_mobileNumber);

            et_firstName = findViewById(R.id.et_firstName);
            et_lastName = findViewById(R.id.et_lastName);
            et_dob = findViewById(R.id.et_dob);
            et_email = findViewById(R.id.et_email);
            et_password = findViewById(R.id.et_password);
            et_confirmPassword = findViewById(R.id.et_confirmPassword);
            et_mobileNumber = findViewById(R.id.et_mobileNumber);

            btn_register = findViewById(R.id.btn_register);

        }
        catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * Initialise Listeners
     */

    private void initListeners(){
        try{

            et_firstName.addTextChangedListener(textWatcherListener(tl_firstName));
            et_lastName.addTextChangedListener(textWatcherListener(tl_lastName));
            et_email.addTextChangedListener(textWatcherListener(tl_email));
            et_password.addTextChangedListener(textWatcherListener(tl_password));
            et_confirmPassword.addTextChangedListener(textWatcherListener(tl_confirmPassword));
            et_mobileNumber.addTextChangedListener(textWatcherListener(tl_mobileNumber));

            et_dob.setOnClickListener(this);
            btn_register.setOnClickListener(this);

        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }

    private boolean validation(){
        try{

            firstName = et_firstName.getText().toString();
            lastName = et_lastName.getText().toString();
            email = et_email.getText().toString();
            password = et_password.getText().toString();
            confirmPassword = et_confirmPassword.getText().toString();
            mobileNumber = et_mobileNumber.getText().toString();

            if(Utilities.isEmpty(firstName)){
                tl_firstName.setError(getString(R.string.please_enter_first_name));
                return false;
            }
            else if(!Utilities.isAlphanumeric(firstName)){
                tl_firstName.setError(getString(R.string.only_alphanumeric_chaacters_are_allowed));
                return false;
            }
            else if(Utilities.isEmpty(lastName)){
                tl_lastName.setError(getString(R.string.please_enter_last_name));
                return false;
            }
            else if(!Utilities.isAlphanumeric(lastName)){
                tl_lastName.setError(getString(R.string.only_alphanumeric_chaacters_are_allowed));
                return false;
            }
            else if(Utilities.isEmpty(email)){
                tl_email.setError(getString(R.string.please_enter_email));
                return false;
            }
            else if(!Utilities.isEmailValid(email)){
                tl_email.setError(getString(R.string.please_enter_valid_email));
                return false;
            }
            else if(Utilities.isEmpty(password)){
                tl_password.setError(getString(R.string.please_enter_password));
                return false;
            }
            else if(!Utilities.isEmpty(password) && !Utilities.isAlphanumeric(password)){
                tl_password.setError(getString(R.string.only_use_alphanumeric_password));
                return false;
            }
            else if(!Utilities.isEmpty(password) && password.length() != 8){
                tl_password.setError(getString(R.string.please_enter_atleast_min_character_password));
                return false;
            }
            else if(Utilities.isEmpty(confirmPassword)){
                tl_confirmPassword.setError(getString(R.string.please_confirm_your_password));
                return false;
            }
            else if(!Utilities.isEmpty(confirmPassword) && confirmPassword.equals(password)){
                tl_confirmPassword.setError(getString(R.string.password_not_match));
                return false;
            }
            else if(Utilities.isEmpty(mobileNumber)){
                tl_mobileNumber.setError(getString(R.string.please_enter_mobile_number));
                return false;
            }

        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }

        return true;
    }

    /**
     * TextWatcher Listener for multiple EditText
     *
     * @param view         TextInputLayout to set error messages
     * @return             TextWatcherListeners
     */

    private TextWatcher textWatcherListener(final View view){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                switch (view.getId()){

                    case R.id.tl_firstName:{

                        try{

                            if(Utilities.isEmpty(s.toString())){
                                tl_firstName.setError(getString(R.string.please_enter_first_name));
                            }
                            else if(!Utilities.isAlphanumeric(s.toString())){
                                tl_firstName.setError(getString(R.string.only_alphanumeric_chaacters_are_allowed));
                            }
                            else{
                                tl_firstName.setError(null);
                            }

                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                        }

                       break;
                    }

                    case R.id.tl_lastName:{

                        try{

                            if(Utilities.isEmpty(s.toString())){
                                tl_lastName.setError(getString(R.string.please_enter_last_name));
                            }
                            else if(!Utilities.isAlphanumeric(s.toString())){
                                tl_lastName.setError(getString(R.string.only_alphanumeric_chaacters_are_allowed));
                            }
                            else {
                                tl_lastName.setError(null);
                            }

                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                        }

                        break;
                    }

                    case R.id.tl_email:{

                        try{

                            if(Utilities.isEmpty(s.toString())){
                                tl_email.setError(getString(R.string.please_enter_email));
                            }
                            else if(!Utilities.isEmailValid(s.toString())){
                                tl_email.setError(getString(R.string.please_enter_valid_email));
                            }
                            else{
                                tl_email.setError(null);
                            }

                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                        }

                        break;
                    }

                    case R.id.tl_password:{

                        try{

                            if(Utilities.isEmpty(s.toString())){
                                tl_password.setError(getString(R.string.please_enter_password));
                            }
                            else if(!Utilities.isEmpty(s.toString()) && !Utilities.isAlphanumeric(s.toString())){
                                tl_password.setError(getString(R.string.only_use_alphanumeric_password));
                            }
                            else if(!Utilities.isEmpty(s.toString()) && s.toString().length() != 8){
                                tl_password.setError(getString(R.string.please_enter_atleast_min_character_password));
                            }
                            else{
                                tl_password.setError(null);
                            }

                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                        }

                        break;
                    }

                    case R.id.tl_confirmPassword:{

                        try{
                            if(Utilities.isEmpty(s.toString())){
                                tl_confirmPassword.setError(getString(R.string.please_confirm_your_password));
                            }
                            else if(!Utilities.isEmpty(s.toString()) && s.toString().equals(et_password.getText().toString())){
                                tl_confirmPassword.setError(getString(R.string.password_not_match));
                            }
                            else
                            {
                                tl_confirmPassword.setError(null);
                            }
                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                        }

                        break;
                    }

                    case R.id.et_mobileNumber:{

                        try{

                            if(Utilities.isEmpty(s.toString())){
                                tl_mobileNumber.setError(getString(R.string.please_enter_mobile_number));
                            }

                        }catch (Exception e){
                            Log.e(TAG, e.getMessage());
                        }
                        break;
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_register:
            {
                if(validation()){
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }

    }

}
