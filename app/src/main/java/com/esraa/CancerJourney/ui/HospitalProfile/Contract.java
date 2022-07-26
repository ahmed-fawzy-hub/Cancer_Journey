package com.esraa.CancerJourney.ui.HospitalProfile;

import com.esraa.CancerJourney.Models.ModelHospitalInfo;

public class Contract {
    interface  View{

        void onSetUi(ModelHospitalInfo data);

        void onError(String toString);

    }
    interface  Presenter{

        void getHospitalDetails(String hospitalId);

        void onSuccess(ModelHospitalInfo body);

        void onError(String toString);
    }
    interface Model{
        void getHospitalDetails(String hospitalId);
    }
}
