package com.esraa.CancerJourney.ui.AppointmentBooking;

import com.esraa.CancerJourney.Models.ModelBookAppointment;
import com.esraa.CancerJourney.Models.ModelDateTime;
import com.esraa.CancerJourney.Models.ModelDoctorInfo;

import java.util.ArrayList;
import java.util.Calendar;

public class Contract {
    interface  View{

        void setUpDatePicker(Calendar[] availabilityDates, Calendar[] unAvailabilityDates
                , ArrayList<ModelDateTime> partiallyUnavailableDates);

        void OnResponse(String message);
    }
    interface  Presenter{

        long getThresholdLimit(String time, String checkUpTime);

        Calendar[] getAvailabilityDates(ModelDoctorInfo doctorProfileInfo);

        Calendar[] getCompletelySlotUnavailableDates(ArrayList<ModelDateTime> completelyUnavailableDates);

        void getAppointmentDates(ModelDoctorInfo doctorProfileInfo);

        void setUpDatePicker(ArrayList<ModelDateTime> unavailableDates, ArrayList<ModelDateTime> completelyUnavailableDates, ArrayList<ModelDateTime> partiallyUnavailableDates, ModelDoctorInfo doctorProfileInfo);

        void bookAppointment(ModelBookAppointment appointment);

        void OnResponse(String message);
    }
    interface  Model{

        void getUnavailableDates(ModelDoctorInfo doctorProfileInfo);

        void bookAppointment(ModelBookAppointment appointment);
    }
}
