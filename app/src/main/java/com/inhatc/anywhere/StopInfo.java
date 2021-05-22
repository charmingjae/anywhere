package com.inhatc.anywhere;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class StopInfo {
    public String name;

    public StopInfo() {
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }

    public StopInfo(String name) {
        this.name = name;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        return result;
    }
}

