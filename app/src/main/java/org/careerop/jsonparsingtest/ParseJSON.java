package org.careerop.jsonparsingtest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuyelRana on 17/04/22.
 */

public class ParseJSON {
    private String json;
    public static List<Student> studentList = new ArrayList<Student>();
    private JSONArray jsonArray = null;

    public ParseJSON(String json) {
        this.json = json;
    }

    protected void jsonParser() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray(Config.JSON_ARRAY);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Student student = new Student();
                student.setId(object.getString(Config.ID));
                student.setName(object.getString(Config.NAME));
                studentList.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
