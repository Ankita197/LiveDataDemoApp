package com.ankita.livedatademo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ankita.livedatademo.apiclasse.APIClient;
import com.ankita.livedatademo.apiclasse.APIInterface;
import com.ankita.livedatademo.apiclasse.CreateResponse;
import com.ankita.livedatademo.apiclasse.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MyViewModel extends ViewModel {
    MutableLiveData<CreateResponse.Datum> responseLiveData = new MutableLiveData<>();
    MutableLiveData<String> successLiveData = new MutableLiveData<>();
    MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private CreateResponse resource;

    void getEmplooyes(User user) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<CreateResponse> call = apiInterface.CreateEmployee(user);
        call.enqueue(new Callback<CreateResponse>() {
            @Override
            public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                resource = response.body();
                if (resource != null && resource.status.equals("success")) {
                    successLiveData.postValue("login Successfully");
                    responseLiveData.postValue(resource.datum);
                }
            }

            @Override
            public void onFailure(Call<CreateResponse> call, Throwable t) {
                Log.d("@!!!", "Connection Failed");
                errorLiveData.postValue(t.getLocalizedMessage());
            }
        });
    }
}