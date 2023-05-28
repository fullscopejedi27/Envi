package com.example.envi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private static FirstFragment instance = null;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        instance = this;
        Button btnMain = view.findViewById(R.id.button_first);
        btnMain.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public int getViewIdFromPlantName(String plantName) {
        switch (plantName) {
            case "Astilbe":
                return R.id.textview_first;
            case "Bellflower":
                return R.id.textview_second;
            case "Black-eyed susan":
                return R.id.textview_third;
            case "Calendula":
                return R.id.textview_fourth;
            case "California poppy":
                return R.id.textview_fifth;
            case "Carnation":
                return R.id.textview_sixth;
            case "Daisy":
                return R.id.textview_seventh;
            case "Coreopsis":
                return R.id.textview_eighth;
            case "Daffodil":
                return R.id.textview_ninth;
            case "Dandelion":
                return R.id.textview_tenth;
            case "Iris":
                return R.id.textview_eleventh;
            case "Magnolia":
                return R.id.textview_twelfth;
            case "Rose":
                return R.id.textview_thirteenth;
            case "Sunflower":
                return R.id.textview_fourteenth;
            case "Tulip":
                return R.id.textview_fifteenth;
            case "Water lily":
                return R.id.textview_sixteenth;
        }
        return -1; //Invalid
    }

    public void scrollToPlantEntry(final String plantName) {
        NestedScrollView scrollView = requireView().findViewById(R.id.dict);
        TextView targetTextView = requireView().findViewById(getViewIdFromPlantName(plantName));

        if (scrollView != null && targetTextView != null) {
            scrollView.post(() -> {
                int scrollToY = targetTextView.getTop();
                scrollView.smoothScrollTo(0, scrollToY);
            });
        }
    }

    public static FirstFragment getInstance() {
        return instance;
    }
}
