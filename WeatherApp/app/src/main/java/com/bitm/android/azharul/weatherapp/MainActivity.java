package com.bitm.android.azharul.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import java.net.URL;

public class MainActivity extends Activity implements OnClickListener {

    public String Current_URL = "http://api.openweathermap.org/data/2.5/find?q=";

    URL url1;

    Button btn, forecast_btn;
    TextView temp_tv, min_max_tv, desc_tv, place_tv;
    EditText et;
    NetworkImageView iv;

    ProgressDialog PD;

    String name, id, country, description, icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button1);
        forecast_btn = (Button) findViewById(R.id.forecast);

        forecast_btn.setOnClickListener(this);

        et = (EditText) findViewById(R.id.editText1);

        place_tv = (TextView) findViewById(R.id.place);
        temp_tv = (TextView) findViewById(R.id.temp);
        min_max_tv = (TextView) findViewById(R.id.min_max);
        desc_tv = (TextView) findViewById(R.id.desc);

        iv = (NetworkImageView) findViewById(R.id.icon);

        btn.setOnClickListener(this);

    }

    public void makejsonreq(String full_url) {

        PD.show();

        JsonObjectRequest jsonObjReq=new JsonObjectRequest(Method.GET, Current_URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    name = response.getString("name");
                    id = response.getString("id");

                    JSONObject main = response.getJSONObject("main");

                    int temp, temp_max, temp_min;
                    temp = (int) (main.getDouble("temp") - 273.15);
                    temp_max = (int) (main.getDouble("temp_max") - 273.15);
                    temp_min = (int) (main.getDouble("temp_min") - 273.15);

                    JSONObject sys = response.getJSONObject("sys");

                    country = sys.getString("country");

                    JSONArray weather = response
                            .getJSONArray("weather");

                    JSONObject jo = weather.getJSONObject(0);

                    description = jo.getString("description");
                    icon = jo.getString("icon");

                    // icon url
                    String icon_url = "http://openweathermap.org/img/w/"
                            + icon + ".png";

                    ImageLoader imageLoader = MyApplication
                            .getInstance().getImageLoader();

                    place_tv.setText(name + "," + country);

                    temp_tv.setText(temp + "\u2106");
                    min_max_tv.setText(temp_min + "\u2106 /" + temp_max
                            + "\u2106");
                    desc_tv.setText(description);

                    iv.setImageUrl(icon_url, imageLoader);

                    forecast_btn.setVisibility(View.VISIBLE);

                } catch (JSONException e) {
                    e.printStackTrace();
                    PD.dismiss();
                }
                PD.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                PD.dismiss();
            }
        });


        MyApplication.getInstance().addToReqQueue(jsonObjReq, "jreq");

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button1:

                PD = new ProgressDialog(MainActivity.this);
                PD.setMessage("Loading.....");
                PD.setCancelable(false);

                String appID="&appid=fec7a9fdb239c89d79724e223d71edbb";
                String city = et.getText().toString();

                String full_url = Current_URL + city + appID;

                makejsonreq(full_url);
                break;

            case R.id.forecast:

                Intent forecast_intent = new Intent(getApplicationContext(),
                        Forecast.class);

                forecast_intent.putExtra("id", id);
                forecast_intent.putExtra("name", name);
                startActivity(forecast_intent);

                break;
        }

    }

}
