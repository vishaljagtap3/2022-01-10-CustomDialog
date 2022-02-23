package in.bitcode.customdialog1;

import android.util.Log;

public class MyLoginListener implements LoginDialog.OnLoginListener {
    private int invalidAttemptsCount = 0;

    @Override
    public void success(LoginDialog loginDialog) {
        Log.e("tag", "Login Successful!");
        loginDialog.dismiss();
    }

    @Override
    public void fail(LoginDialog loginDialog) {
        Log.e("tag", "Login failed");
        invalidAttemptsCount++;
        if(invalidAttemptsCount > 3) {
            loginDialog.dismiss();
        }
    }
}


/*public class MyLoginListener {

    private int invalidAttemptsCount = 0;

    public void success(LoginDialog loginDialog) {
        Log.e("tag", "Login Successful!");
        loginDialog.dismiss();
    }

    public void fail(LoginDialog loginDialog) {
        Log.e("tag", "Login failed");
        invalidAttemptsCount++;
        if(invalidAttemptsCount > 3) {
            loginDialog.dismiss();
        }
    }
}*/
