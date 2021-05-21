package com.inhatc.anywhere;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;
// [START post_class]
@IgnoreExtraProperties
public class PostModel {


    public String user;
    public String phone;
    public String birth;
    public Map<String, Boolean> stars = new HashMap<>();

    public PostModel() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public PostModel(String name, String phone, String birth) {
        this.user = user;
        this.phone = phone;
        this.birth = birth;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("phone", phone);
        result.put("birth", birth);

        return result;
    }
    // [END post_to_map]

}
// [END post_class]
