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

    private MyLoginListener listener;

    public void setMyLoginListener(MyLoginListener listener) {
        this.listener = listener;
    }

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

            if(listener == null) {
                return;
            }

            if(edtPassword.getText().toString().equals("1111") && edtUsername.getText().toString().equals("bitcode")) {
                listener.success(LoginDialog.this);
            }
            else {
                listener.fail(LoginDialog.this);
            }
        }
    }
}
