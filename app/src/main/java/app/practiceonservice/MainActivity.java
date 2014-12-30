package app.practiceonservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText act1Text;
    Communicate mService;
    boolean mBound = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        /* TODO: Start Service */
        Intent serIntent = new Intent(this, Communicate.class);
        startService(serIntent);
        /* TODO: Bind On Service */
        bindService(serIntent, mConnection, Context.BIND_AUTO_CREATE);
        /* Get EditText from View */
        act1Text = (EditText) findViewById(R.id.activity1_input);
	}

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            Communicate.LocalBinder binder = (Communicate.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    public void jmpToNext(View view) {
        if(mBound) {
            String a1 = act1Text.getText().toString();
            mService.setAct1Info(a1);
            mService.showAct1String();
        }
        Intent jmp = new Intent(this, MainActivity2.class);
        startActivity(jmp);
    }
}
