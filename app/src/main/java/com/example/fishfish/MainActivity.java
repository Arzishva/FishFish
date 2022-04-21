package com.example.fishfish;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;


import data.DataModelFeedHistory;
import data.DataModelFeedType;
import data.DataModelPond;
import data.OkhttpClient;
import data.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;
    EditText text1;
    Button postDataBtn;
    DataModelFeedHistory DMFeedHistory;
    OkhttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        text1 = findViewById(R.id.text1);
        postDataBtn = findViewById(R.id.idBtnPost);
        getPonds();
        getFeeds();
        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();

            }
        });
    }
    private void signUp() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // registration is a POST request type method in which we are sending our field's data
        // enqueue is used for callback response and error
        RetrofitClient.getMyApi().postFeedHistorys(
                spinner1.getSelectedItem().toString().trim(),
                spinner2.getSelectedItem().toString().trim(),
                text1.getText().length())
                .enqueue(new Callback<DataModelFeedHistory>() {
            @Override
            public void onResponse(Call<DataModelFeedHistory> call, Response<DataModelFeedHistory> response) {
                DMFeedHistory = response.body();
                    Toast.makeText(getApplicationContext(),
                            response.body().getMessage()
                            , Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<DataModelFeedHistory> call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                progressDialog.dismiss();

            }
        });
    }
    private void getPonds() {
        Call<List<DataModelPond>> call = RetrofitClient.getInstance().getMyApi().getPonds();
        call.enqueue(new Callback<List<DataModelPond>>() {
            @Override
            public void onResponse(Call<List<DataModelPond>> call, Response<List<DataModelPond>> response) {
                List<DataModelPond> pondsList = response.body();
                String[] onePonds = new String[pondsList.size()];

                for (int i = 0; i < pondsList.size(); i++) {
                    onePonds[i] = pondsList.get(i).getAlias();
                }

                spinner1.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, onePonds));
            }

            @Override
            public void onFailure(Call<List<DataModelPond>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error ponds has occurred", Toast.LENGTH_LONG).show();
            }

        });
    }
    private void getFeeds() {
        Call<List<DataModelFeedType>> call = RetrofitClient.getInstance().getMyApi().getFeeds();
        call.enqueue(new Callback<List<DataModelFeedType>>() {
            @Override
            public void onResponse(Call<List<DataModelFeedType>> call, Response<List<DataModelFeedType>> response) {
                List<DataModelFeedType> fishList = response.body();
                String[] oneFeeds = new String[fishList.size()];

                for (int i = 0; i < fishList.size(); i++) {
                    oneFeeds[i] = fishList.get(i).getName();
                }

                spinner2.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, oneFeeds));
            }

            @Override
            public void onFailure(Call<List<DataModelFeedType>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error feeds has occurred", Toast.LENGTH_LONG).show();
            }

        });
    }
}