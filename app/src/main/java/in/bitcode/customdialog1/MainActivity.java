package in.bitcode.customdialog1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = findViewById(R.id.txtLogin);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                //loginDialog.setMyLoginListener(new MyLoginListener());
                //loginDialog.setOnLoginListener(new MyLoginListener());

                loginDialog.setOnLoginListener(new LoginDialog.OnLoginListener() {
                    @Override
                    public void success(LoginDialog loginDialog) {
                        loginDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void fail(LoginDialog loginDialog) {
                        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
                    }
                });

                loginDialog.show();

            }
        });
    }
}