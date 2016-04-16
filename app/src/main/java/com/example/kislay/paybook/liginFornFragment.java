package com.example.kislay.paybook;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Shagun on 16-Apr-16.
 */
public class liginFornFragment extends Fragment{

    private static final String TAG = "SignupActivity";

    EditText usern;
    EditText phoneno;
    EditText pin;
    EditText confirmpin;
    Button b1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loginform, container, false);


        usern = (EditText) view.findViewById(R.id.inp);
        phoneno = (EditText) view.findViewById(R.id.phno_);
        pin = (EditText) view.findViewById(R.id.pin);
        confirmpin = (EditText) view.findViewById(R.id.confirmPin);
        b1 = (Button) view.findViewById(R.id.button);
        final LinearLayout LoginBox = (LinearLayout)view.findViewById(R.id.LoginBox);
        LoginBox.setVisibility(View.GONE);
        LoginBox.setVisibility(View.VISIBLE);
        Animation animFade = AnimationUtils.loadAnimation(getActivity().this, R.anim.fade);
        LoginBox.startAnimation(animFade);
        b1.setOnClickListener(new View.OnClickListener()
                              {
                        @Override
                        public void onClick (View v){
                        signup();
                    }
                    }

                    );

                    public void signup() {
                        Log.d(TAG, "Signup");

                        if (!validate()) {
                            onSignupFailed();
                            return;
                        }

                        b1.setEnabled(false);

                        String username = usern.getText().toString();
                        String phno = phoneno.getText().toString();
                        String p = pin.getText().toString();
                        String cp = confirmpin.getText().toString();

                        // TODO: Implement your own signup logic here.

                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        // On complete call either onSignupSuccess or onSignupFailed
                                        // depending on success
                                        onSignupSuccess();
                                        // onSignupFailed();

                                    }
                                }, 3000);
                    }


                    public void onSignupSuccess() {
                        b1.setEnabled(true);
                    }

                    public void onSignupFailed() {
                        Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_LONG).show();
                        b1.setEnabled(true);
                    }

                    public boolean validate() {
                        boolean valid = true;

                        String username = usern.getText().toString();
                        String phno = phoneno.getText().toString();
                        String p = pin.getText().toString();
                        String cp = confirmpin.getText().toString();

                        if (username.isEmpty() || username.length() < 3) {
                            usern.setError("at least 3 characters");
                            valid = false;
                        } else {
                            usern.setError(null);
                        }

                        if (phno.length() > 10) {
                            phoneno.setError("enter a valid phone number");
                            valid = false;
                        } else {
                            phoneno.setError(null);
                        }

                        if (p.isEmpty() || p.length() != 4) {
                            pin.setError("Only 4 numbers");
                            valid = false;
                        } else {
                            pin.setError(null);
                        }

                        if (cp != p) {
                            confirmpin.setError("Pelase write confirmed pin");
                            valid = false;
                        } else {
                            confirmpin.setError(null);
                        }

                        return valid;
                    }


                }




