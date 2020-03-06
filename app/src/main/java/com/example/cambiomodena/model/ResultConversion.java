
package com.example.cambiomodena.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultConversion {

    @SerializedName("result")
    @Expose
    private Resultconv result;
    @SerializedName("status")
    @Expose
    private String status;

    public Resultconv getResult() {
        return result;
    }

    public void setResult(Resultconv result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
