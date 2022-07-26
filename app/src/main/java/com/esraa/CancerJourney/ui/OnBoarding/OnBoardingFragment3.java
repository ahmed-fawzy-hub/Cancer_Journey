package com.esraa.CancerJourney.ui.OnBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.esraa.CancerJourneyApp.R;
import com.esraa.CancerJourney.ui.Auth.LoginActivity.LoginActivity;

public class OnBoardingFragment3 extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.boarding3, container, false);
        ImageView nextBtn = viewGroup.findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getContext(), LoginActivity.class);
                startActivity(mainIntent);

            }
        });

        return viewGroup;

    }
}
