package com.esraa.CancerJourney.Models;

import com.google.gson.annotations.SerializedName;

public class ResponseMessage {
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }
}
