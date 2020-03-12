package com.ankita.livedatademo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;


public class WelcomeFragment extends Fragment {
    private EditText edtName, edtAge, edtSalary;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        init(view);
        MyViewModel model = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MyViewModel.class);

        edtName.setText(model.responseLiveData.getValue().name);
        edtAge.setText(model.responseLiveData.getValue().age);
        edtSalary.setText(model.responseLiveData.getValue().salary);

        return view;
    }

    private void init(View view) {
        edtName = view.findViewById(R.id.edtName);
        edtAge = view.findViewById(R.id.edtAge);
        edtSalary = view.findViewById(R.id.edtSalary);
    }

}
