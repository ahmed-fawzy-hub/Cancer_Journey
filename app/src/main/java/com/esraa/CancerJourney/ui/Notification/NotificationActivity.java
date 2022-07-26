package com.esraa.CancerJourney.ui.Notification;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.esraa.CancerJourneyApp.R;

public class NotificationActivity extends AppCompatActivity implements Contract.View{
    NotificationPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_notfication);
        presenter = new NotificationPresenter(NotificationActivity.this);
        getSupportActionBar().setTitle("Notifications");
    }
}
