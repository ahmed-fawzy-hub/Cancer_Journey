package com.esraa.CancerJourney.ui.DoctorsActivity;

import com.esraa.CancerJourney.Models.ModelKeyData;
import com.esraa.CancerJourney.Models.ModelRequestId;

import java.util.ArrayList;

public class Contract {
    interface  View{

        void notifyAdapter();

        void setErrorUi(String message);

        void updateSuccessUi(ArrayList<ModelKeyData> data);
    }
    interface  Presenter{

        void loadDoctorsList(String startingValue, int noOfItems);

        void onError(String message);

        void onSuccess(ArrayList<ModelKeyData> body);

        void loadDoctorsList(ArrayList<ModelRequestId> listOfDoctors, int startingIndex);
    }

    interface  Model{

        void getDoctorsList(String statingValue, int noOfItems);

        void getDoctorsList(ArrayList<ModelRequestId> listOfDoctorsIds, int startingIndex);
    }
}
