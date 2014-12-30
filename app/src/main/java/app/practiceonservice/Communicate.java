package app.practiceonservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class Communicate extends Service {
	private final IBinder mBinder = new LocalBinder();
	String act1Info;
	String act2Info;
	String act3Info;

	public class LocalBinder extends Binder {
		Communicate getService() {
            return Communicate.this;
        }
	}

	public Communicate() {

	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	public void setAct1Info(String s) {
		this.act1Info = s;
	}

    public void showAct1String() {
        Toast.makeText(this, "String of Activity 1 is " + act1Info, Toast.LENGTH_SHORT).show();
    }

	public void setAct2Info(String s) {
		this.act2Info = s;
	}

	public void setAct3Info(String s) {
		this.act3Info = s;
	}

}
