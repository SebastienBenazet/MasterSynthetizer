package com.kitbass.mastersynthetizer;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class Helpers {
    public static JSONObject loadJsonFromInputStream(InputStream inputStream) {
        try {
            StringBuilder total = new StringBuilder();
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }

            return new JSONObject(total.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
