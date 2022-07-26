package com.esraa.CancerJourney.ui.DoctorsProfile;

import com.esraa.CancerJourney.Models.ModelDoctorInfo;
import com.esraa.CancerJourney.Retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.Model {
    private Contract.Presenter presenter;

    public Model(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getDoctorDetails(String doctorId) {
        ApiService.getAPIService().getDoctorInfo(null,doctorId).enqueue(new Callback<ModelDoctorInfo>() {
            @Override
            public void onResponse(Call<ModelDoctorInfo> call, Response<ModelDoctorInfo> response) {
                if (response.isSuccessful() && response.code()==200)
                    presenter.onSuccess(response.body());
                else
                    presenter.onError(response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<ModelDoctorInfo> call, Throwable t) {
                presenter.onError(t.getMessage());
            }
        });
    }
}
