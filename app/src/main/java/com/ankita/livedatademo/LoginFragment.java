package com.ankita.livedatademo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ankita.livedatademo.apiclasse.User;

import java.util.Objects;


public class LoginFragment extends Fragment {

    private MyViewModel model;
    private EditText edtName, edtAge, edtSalary;
    private Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        init(view);
        model = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MyViewModel.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(edtName.getText().toString(), edtAge.getText().toString(), edtSalary.getText().toString());
                model.getEmplooyes(user);

            }
        });
        model.successLiveData.observe(Objects.requireNonNull(getActivity()), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (getActivity().getSupportFragmentManager() != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new WelcomeFragment(), WelcomeFragment.class.getSimpleName())
                            .commit();
                }
            }
        });

        return view;
    }

    private void init(View view) {
        edtName = view.findViewById(R.id.edtName);
        edtAge = view.findViewById(R.id.edtAge);
        edtSalary = view.findViewById(R.id.edtSalary);
        btnLogin = view.findViewById(R.id.btnLogin);
    }


}
