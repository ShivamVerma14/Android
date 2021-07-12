package com.example.lifecycles;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class testFragment extends Fragment {
    private void makeToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makeToast("onViewCreated() called");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        makeToast("onAttach() called");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeToast("onCreate() called");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, container, false);
        makeToast("onCreateView() called");
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        makeToast("onActivityCreated() called");
    }

    public void onStart() {
        super.onStart();
        makeToast("onStart() called");
    }

    public void onResume() {
        super.onResume();
        makeToast("onResume() called");
    }

    public void onPause() {
        super.onPause();
        makeToast("onPause() called");
    }

    public void onStop() {
        super.onStop();
        makeToast("onStop() called");
    }

    public void onDestroyView() {
        super.onDestroyView();
        makeToast("onDestroyView() called");
    }

    public void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy() called");
    }

    public void onDetach() {
        super.onDetach();
        makeToast("onDetach() called");
    }
}
