package com.esraa.CancerJourney.Repository.Remote;

import com.esraa.CancerJourney.Models.ModelPatientInfo;
import com.esraa.CancerJourney.Models.ModelAppointment;
import com.esraa.CancerJourney.Models.ModelBookAppointment;
import com.esraa.CancerJourney.Models.ModelDoctorInfo;
import com.esraa.CancerJourney.Models.ModelHospitalInfo;
import com.esraa.CancerJourney.Models.ModelKeyData;
import com.esraa.CancerJourney.Models.ResponseMessage;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitNetworkApi {

    @GET("Patient/incoming_webhook/getPatientInfo")
    Call<ModelPatientInfo> getPatientInfo(@Query("email") String  email, @Query("patient_id") String id);

    @GET("Patient/incoming_webhook/AddFCMToken")
    Call<ResponseBody> AddFCMToken(@Query("email") String  email, @Query("fcm_token") String token);

    @GET("FCM/incoming_webhook/DeletePatientFcmToken")
    Call<ResponseBody> DeleteFcmToken(@Query("email") String  email, @Query("fcm_token") String token);

    @GET("FCM/incoming_webhook/sendPatientPasswordUpdateNotification")
    Call<ResponseBody> sendPasswordUpdateNotification(@Query("email") String  email);

    @POST("Patient/incoming_webhook/registerPatient")
    Call<ResponseBody> registerPatient(@Body ModelPatientInfo patientInfo);

    @POST("Patient/incoming_webhook/updateProfileData")
    Call<ResponseBody> updateProfileData(@Body ModelPatientInfo patientInfo);

    @GET("Hospital/incoming_webhook/getHospitalInfo")
    Call<ModelHospitalInfo> getHospitalInfo(@Query("email") String email,@Query("hospital_id") String id);

    @GET("Patient/incoming_webhook/updateProfilePic")
    Call<ResponseBody> updateProfilePic(@Query("id") String  id, @Query("url") String url);

    @GET("Doctor/incoming_webhook/getAllDoctors")
    Call<ArrayList<ModelKeyData>> getDoctorsList(@Query("startValue") String startValue, @Query("noOfItems") int noOfItems);

    @GET("Doctor/incoming_webhook/getDoctorInfo")
    Call<ModelDoctorInfo> getDoctorInfo(@Query("email") String email, @Query("doctor_id") String id);

    @GET("Doctor/incoming_webhook/getShortDoctorInfo")
    Call<ModelKeyData> getShortDoctorInfo(@Query("email") String email, @Query("doctor_id") String id);

    @GET("Doctor/incoming_webhook/unavailableDates")
    Call<ModelDoctorInfo> getUnavailableDates(@Query("doctor_id") String id);

    @GET("Hospital/incoming_webhook/getAllHospitals")
    Call<ArrayList<ModelKeyData>> getHospitalsList(@Query("startValue") String startValue, @Query("noOfItems") int noOfItems);

    @GET("Patient/incoming_webhook/getAppointmentsIdsList")
    Call<ModelPatientInfo> getAppointmentsIdsList(@Query("patient_id") String patientId);

    @GET("Hospital/incoming_webhook/AppointmentDetails")
    Call<ModelAppointment> getAppointmentsDetails(@Query("appointment_id") String appointmentId);

    @POST("Patient/incoming_webhook/bookAppointment")
    Call<ResponseMessage> bookAppointment(@Body ModelBookAppointment appointment);
}
