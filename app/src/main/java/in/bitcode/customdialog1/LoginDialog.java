package in.bitcode.customdialog1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    private Context context;

    public LoginDialog(@NonNull Context context) {
        super(context);

        this.context = context;

        setContentView(R.layout.login_dialog);

        init();
    }

    private void init() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(edtPassword.getText().toString().equals("1111") && edtUsername.getText().toString().equals("bitcode")) {
                context.startActivity(
                        new Intent(context, HomeActivity.class)
                );
                dismiss();
            }
            else {
                Toast.makeText(context, "Login failed!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
