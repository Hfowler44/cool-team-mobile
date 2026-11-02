package com.example.prototypeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Planner#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Planner extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Planner() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Planner.
     */
    // TODO: Rename and change types and number of parameters
    public static Planner newInstance(String param1, String param2) {
        Planner fragment = new Planner();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planner, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        LocalDate date = LocalDate.now();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        View view = getView();
        TextView dateText = view.findViewById(R.id.PlannerDateText);

        int startDay = 0;
        int endDay = 0;

        switch (dayOfWeek){
            case SUNDAY:
                startDay = day;
                endDay = day + 6;
                break;
                case MONDAY:
                startDay = day - 1;
                endDay = day + 5;
                break;
                case TUESDAY:
                startDay = day - 2;
                endDay = day + 4;
                break;
                case WEDNESDAY:
                startDay = day - 3;
                endDay = day + 3;
                break;
                case THURSDAY:
                startDay = day - 4;
                endDay = day + 2;
                break;
                case FRIDAY:
                startDay = day - 5;
                endDay = day + 1;
                break;
                case SATURDAY:
                    startDay = day - 6;
                    endDay = day;
                    break;
        }

        dateText.setText(month + " " + startDay + "-" + endDay);

    }
}