package com.esraa.CancerJourney.ui.Profile;

import com.esraa.CancerJourney.Models.ModelPatientInfo;

public class Contract {
    interface  View{

        void onSuccess(ModelPatientInfo body);

        void onError(String s);
    }
    interface  Presenter{

        ModelPatientInfo getUserData(String id);

        void onError(String toString);

        void onSuccess(ModelPatientInfo body);

        void deleteFcmToken(String email, String token);

        void sendPasswordUpdateNotification(String email);
    }

    interface  Model{

        void getUserData(String id);

        void sendPasswordUpdateNotification(String email);
    }
}
