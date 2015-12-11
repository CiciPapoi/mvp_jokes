package com.boldijarpaul.mvprxsample.mvp.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cicipapoi on 11/12/15.
 */
public class JokesListModel {
    @SerializedName("type")
    public String type;

    @SerializedName("value")
    public List<ValueModel> valueList;

    public ArrayList<String> toStringArray() {
        ArrayList<String> jokesArray = new ArrayList<>();
        for (ValueModel value : valueList) {
            jokesArray.add(value.joke);
        }
        return jokesArray;
    }

}
