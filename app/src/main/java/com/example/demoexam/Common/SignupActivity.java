package com.example.demoexam.Common;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoexam.R;

import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    Button btnSignUp, btnAccount;
    EditText edEmail, edPassword, edName, edPasswordCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edEmail = findViewById(R.id.etEmail);
        edName = findViewById(R.id.etName);
        edPassword = findViewById(R.id.etPassword);
        edPasswordCorrect = findViewById(R.id.etPasswordCorrect);
        btnAccount = findViewById(R.id.btnAccount);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edPassword.getText().toString()) ||
                        TextUtils.isEmpty(edName.getText().toString()) ||
                        TextUtils.isEmpty(edPasswordCorrect.getText().toString())) {
                    ShowAlertDialogWindow("Пожалуйста заполните пустые поля!");
                } else if (!edPassword.getText().toString().equals(edPasswordCorrect.getText().toString())) {
                    ShowAlertDialogWindow("Пароли не совпадают");
                } else {
                    //registerUser();
                }
            }
        });
    }
//    public void registerUser() {
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setEmail(edEmail.getText().toString());
//        registerRequest.setFirstName(edName.getText().toString());
//        registerRequest.setPassword(edPassword.getText().toString());


//        Call<RegisterResponse> registerResponseCall = ApiClient.getRegister().registerUser(registerRequest);
//        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
//            @Override
 //           public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
   //             if (response.isSuccessful()) {
     //               String message = "Its all okay!";
       //             Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
         //           finish();

       //         } else {
      //              String message = "something gone wrong";
    //                Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
  //              }
   //         }

//            @Override
//            public void onFailure(Call<RegisterResponse> call, Throwable throwable) {
 //               String message = "Registry is done!";
 //               Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
  //              startActivity(new Intent(SignupActivity.this, SigninActivity.class));
 //           }
 //       });
 //   }



    private void ShowAlertDialogWindow(String s) {
        AlertDialog alertDialog = new AlertDialog.Builder(SignupActivity.this).
                setMessage(s).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).create();
        alertDialog.show();
    }
}
