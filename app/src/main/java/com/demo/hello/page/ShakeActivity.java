package com.demo.hello.page;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ShakeActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Vibrator vibrator;
    private static String str[] = {"布", "剪刀", "石头"};
    private static int pic[] = {R.mipmap.p1, R.mipmap.p2, R.mipmap.p3};
    private static final int SENSOR_SHAKE = 10;
    private TextView text;
    private ImageView img;
    private static final String TAG = "ShakeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

        text = findViewById(R.id.tv_shake);
        img = findViewById(R.id.iv_shake);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    protected void onResume() {
        super.onResume();
        if (sensorManager != null) {
            sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onStop() {
        super.onStop();
        if (sensorManager != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    /**
     * 重力感应监听
     */
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0]; // x轴方向的重力加速度，向右为正
            float y = values[1]; // y轴方向的重力加速度，向前为正
            float z = values[2]; // z轴方向的重力加速度，向上为正
            Log.i(TAG, "x[" + x + "] y[" + y + "] z[" + z + "]");
            // 一般在这三个方向的重力加速度达到40就达到晃动手机的状态
            int medumValue = 10; // 不同手机厂商这个数值可能会不同
            if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE;
                handler.sendMessage(msg);

            }


        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 10:
//                    Toast.makeText(ShakeActivity.this,"检测到摇晃，执行操作！",Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "handleMessage: 检测到摇晃，执行操作！");
                    java.util.Random r = new java.util.Random();
                    int num = Math.abs(r.nextInt()) % 3;
                    text.setText(str[num]);
                    img.setImageResource(pic[num]);
                    break;
            }
        }
    };

}
