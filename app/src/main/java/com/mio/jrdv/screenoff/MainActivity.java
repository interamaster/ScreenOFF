package com.mio.jrdv.screenoff;

import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private PowerManager mPowerManager;
    private PowerManager.WakeLock mWakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void offbutton(View view) throws IOException {

        // turn off screen
        /*
        Log.v("ProximityActivity", "OFF!");
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "tag");
        mWakeLock.acquire();
        */

        /*no hace nada


        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "My Tag");
        wl.acquire();
        //..screen will stay on during this section..
        wl.release();
        */
/*no hace nada
        mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
        mWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getLocalClassName());

        if (!mWakeLock.isHeld()) {
            mWakeLock.acquire();
        }

*/


        /*
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        params.screenBrightness = 0;
        getWindow().setAttributes(params);
        *
        */


        /*

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(this)) {
                // Do stuff here
                //

                final int previous;
                try {
                     previous = Settings.System.getInt(getContentResolver(),  Settings.System.SCREEN_OFF_TIMEOUT);  // reSystem.SCREEN_OFF_TIMEOUT, Default1);
                } catch (Settings.SettingNotFoundException e) {
                    e.printStackTrace();
                }

                Settings.System.putInt(getContentResolver(),  Settings.System.SCREEN_OFF_TIMEOUT, 0);  // set timeout to 0

                // wait 3 seconds then reset the timeout setting
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Settings.System.putInt(
                                getContentResolver(),
                                Settings.System.SCREEN_OFF_TIMEOUT, 10000);
                    }
                }).start();

             }
            else {
                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }

        else
        {
            Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 1000);
        }



*/


/*
        PowerManager manager = (PowerManager) getSystemService(Context.POWER_SERVICE);

// Choice 1
    //    manager.goToSleep(int amountOfTime);

        // Choice 2
        PowerManager.WakeLock wl = manager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Your Tag");
        wl.acquire();
        wl.release();
*/

        /*

        PowerManager manager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = manager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Your Tag");
        wl.acquire();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = 0;
        getWindow().setAttributes(params);

   */




        /*
        //Start recording video
        String recordVideo = "input keyevent 26";
        try {
            device.executeShell(recordVideo);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

*/

        //ProcessBuilder process = new ProcessBuilder("adb shell input keyevent 26");
       // Process p=process.start();


/*
        Process process = Runtime.getRuntime().exec("adb shell input keyevent 26");
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(process.getInputStream()));
        Log.d("info",bufferedReader.toString());

        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("adb input keyevent 26");
*/


        ShellExecuter exe = new ShellExecuter();
        String command =  "keyevent 26";


        String outp = exe.Executer(command);
         Log.d("Output", outp);


        //https://developer.android.com/reference/android/Manifest.permission.html

        //http://stackoverflow.com/questions/31743477/error-while-executing-adb-command-programmatically
        //https://www.learn2crack.com/2014/03/android-executing-shell-commands.html


        /*
        12-24 12:25:19.988 14382-14382/com.mio.jrdv.screenoff D/ViewRootImpl: ViewPostImeInputStage ACTION_DOWN
12-24 12:25:20.138 14382-14382/com.mio.jrdv.screenoff W/System.err: java.io.IOException: Error running exec(). Command: [keyevent, 26] Working Directory: null Environment: null
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.ProcessManager.exec(ProcessManager.java:211)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.Runtime.exec(Runtime.java:173)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.Runtime.exec(Runtime.java:246)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.Runtime.exec(Runtime.java:189)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at com.mio.jrdv.screenoff.ShellExecuter.Executer(ShellExecuter.java:24)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at com.mio.jrdv.screenoff.MainActivity.offbutton(MainActivity.java:165)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.reflect.Method.invoke(Method.java:372)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.support.v7.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:288)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.view.View.performClick(View.java:5197)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.view.View$PerformClick.run(View.java:20926)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.os.Handler.handleCallback(Handler.java:739)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.os.Handler.dispatchMessage(Handler.java:95)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.os.Looper.loop(Looper.java:145)
12-24 12:25:20.148 14382-14382/com.mio.jrdv.screenoff W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:5951)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.reflect.Method.invoke(Native Method)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.reflect.Method.invoke(Method.java:372)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1400)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1195)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at de.robv.android.xposed.XposedBridge.main(XposedBridge.java:133)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err: Caused by: java.io.IOException: Permission denied
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.ProcessManager.exec(Native Method)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err:     at java.lang.ProcessManager.exec(ProcessManager.java:209)
12-24 12:25:20.158 14382-14382/com.mio.jrdv.screenoff W/System.err: 	... 19 more
         */

    }
}
