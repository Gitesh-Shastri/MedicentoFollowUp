package com.medicento.medicentofollowup;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // declare used editTexts
    EditText editTextUsername;
    EditText editTextPassword;

    // declare used button
    Button buttonLogin;

    // declare used ImageView
    ImageView imageViewLogo;

    // declare used CardView
    CardView cardViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // get the references for editText and Buttons
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);

        // get the reference for logo
        imageViewLogo = findViewById(R.id.imageViewLogo);

        // get the reference for cardView
        cardViewLogin = findViewById(R.id.cardViewLogin);


        // set OnClickListener to button buttonLogin
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make operations

                // get username and password from edit text
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Validate username and password
                if (username.equals("")) {
                    showToastMessage("username/email can't be empty");
                    // set focus to editTextUsername
                    editTextUsername.requestFocus();
                } else if (password.equals("")) {
                    showToastMessage("password can't be empty");

                    // set focus to editTextPassword
                    editTextPassword.requestFocus();
                }

                // translate to 0 and set visibility of logo to visible
                cardViewLogin.animate();
                cardViewLogin.setTranslationY(0);
                cardViewLogin.setCardElevation(10);
                imageViewLogo.setVisibility(View.VISIBLE);

                closeKeyBoard();

            }
        });


        // set on touch listener to ediTexts
        // when edit texts is touched, keyboard will appear
        // we need to shift the input fields slightly up
        editTextUsername.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imageViewLogo.setVisibility(View.GONE);
                cardViewLogin.animate();
                cardViewLogin.setCardElevation(50);
                cardViewLogin.setTranslationY(-310);
                return false;
            }
        });

        editTextPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imageViewLogo.setVisibility(View.GONE);
                cardViewLogin.animate();
                cardViewLogin.setTranslationY(-310);
                cardViewLogin.setCardElevation(50);
                return false;
            }
        });


    }


    // defining method closeKeyBoard()
    private void closeKeyBoard() {

        try {
            View view = this.getCurrentFocus();
            if (view != null) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            System.out.println("Exception generated when attempting to close keybard..");
        }
    }

    // defining method showToastMessage() to show toast message
    void showToastMessage(String messsage) {

        Toast.makeText(LoginActivity.this, messsage, Toast.LENGTH_SHORT).show();
    }

}
