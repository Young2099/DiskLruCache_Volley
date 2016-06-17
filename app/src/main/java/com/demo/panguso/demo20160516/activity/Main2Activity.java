package com.demo.panguso.demo20160516.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demo.panguso.demo20160516.R;

public class Main2Activity extends AppCompatActivity {

    // 通知id
    private static final int NOTICE_ID = 1222;
    private Button notify;
    private Button cancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        notify = (Button) findViewById(R.id.noti);
        cancel = (Button) findViewById(R.id.cancel);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notityMe();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // 取消通知
                manager.cancel(NOTICE_ID);
            }
        });
    }

    private void notityMe() {
        // 获得通知管理器，通知是一项系统服务
        final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(this)
                .setContentTitle("hello")
                .setContentText("ninimjini")
                .setSmallIcon(R.drawable.a)
                .setOngoing(true)
                .build();
        // 通知
        manager.notify(NOTICE_ID, notification);
    }
}
