
package com.example.cambiomodena.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resultconv {

    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("amount")
    @Expose
    private Double amount;

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
