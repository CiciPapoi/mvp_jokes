package com.boldijarpaul.mvprxsample.mvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cicipapoi on 11/12/15.
 */
public class JokeModel {
    @SerializedName("type")
    public String type;
    @SerializedName("value")
    public ValueModel value;

}
