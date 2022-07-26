package com.esraa.CancerJourney.ui.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.esraa.CancerJourney.ui.Notification.NotificationActivity;
import com.esraa.CancerJourney.OCR.OcrActivity;
import com.esraa.CancerJourneyApp.R;
import com.esraa.CancerJourney.SkinDetection.SkinActivity;
import com.esraa.CancerJourney.ui.AppointmentBooking.BookAppointmentActivity;
import com.esraa.CancerJourney.ui.Appointments.AppointmentActivity;
import com.esraa.CancerJourney.ui.DoctorsActivity.DoctorsActivity;
import com.esraa.CancerJourney.ui.Hospital.HospitalActivity;
import com.esraa.CancerJourney.ui.Profile.ProfileActivity;
import com.esraa.CancerJourney.ui.Search.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WelcomeActivity extends AppCompatActivity implements Contract.View, View.OnClickListener {
    @BindView(R.id.card_hospital)
    CardView card_hospital;
    @BindView(R.id.card_doctor)
    CardView card_doctor;
    @BindView(R.id.card_book_appointment)
    CardView card_appointment;
    @BindView(R.id.card_appointment)
    CardView card_ambulance;
    @BindView(R.id.skin_feature)
    CardView skin_d_feature;
    @BindView(R.id.report_feature)
    CardView mreport_feature ;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    Unbinder unbinder;
    WelcomeActivityPresenter presenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        presenter = new WelcomeActivityPresenter(WelcomeActivity.this);
        card_hospital.setOnClickListener(this);
        card_doctor.setOnClickListener(this);
        card_appointment.setOnClickListener(this);
        card_ambulance.setOnClickListener(this);
        skin_d_feature.setOnClickListener(this);
        mreport_feature.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_hospital:
                startActivity(new Intent(this, HospitalActivity.class));
                break;
            case R.id.card_doctor:
                startActivity(new Intent(this, DoctorsActivity.class));
                break;
            case R.id.card_book_appointment:
                startActivity(new Intent(this, BookAppointmentActivity.class));
                break;
            case R.id.card_appointment:
                startActivity(new Intent(this, AppointmentActivity.class));
                break;
            case R.id.skin_feature:
                startActivity(new Intent(this, SkinActivity.class));
                break;
            case R.id.report_feature:
                startActivity(new Intent(this, OcrActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_notification:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.menu_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.search_bar:
                startActivity(new Intent(this, SearchActivity.class).putExtra("key", getString(R.string.both)));

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
