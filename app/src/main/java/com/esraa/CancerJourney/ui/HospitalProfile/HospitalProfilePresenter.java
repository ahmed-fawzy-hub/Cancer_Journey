package com.esraa.CancerJourney.ui.HospitalProfile;

import com.esraa.CancerJourney.Models.ModelHospitalInfo;

public class HospitalProfilePresenter implements Contract.Presenter {
    Contract.View mainView;
    Contract.Model model;

    public HospitalProfilePresenter(Contract.View mainView) {
        this.mainView = mainView;
        this.model = new HospitalProfileModel(HospitalProfilePresenter.this);
    }

    @Override
    public void getHospitalDetails(String hospitalId) {
        model.getHospitalDetails(hospitalId);
    }

    @Override
    public void onSuccess(ModelHospitalInfo body) {
        mainView.onSetUi(body);
    }

    @Override
    public void onError(String s) {
        mainView.onError(s);
    }
}
