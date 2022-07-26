package com.esraa.CancerJourney.Retrofit;

import com.esraa.CancerJourney.Repository.Remote.RetrofitNetworkApi;
import com.esraa.CancerJourney.Utilities.HelperClass;

public class ApiService {
    private ApiService() {}

    public static RetrofitNetworkApi getAPIService() {
        return RetrofitClient.getClient(HelperClass.BASE_URL).create(RetrofitNetworkApi.class);
    }
}
