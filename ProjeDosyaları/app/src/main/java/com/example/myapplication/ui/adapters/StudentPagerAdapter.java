package com.example.myapplication.ui.adapters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.fragments.AttendanceFragment;
import com.example.myapplication.ui.fragments.ExamResultsFragment;
import com.example.myapplication.ui.fragments.FeesFragment;
import com.example.myapplication.ui.fragments.PanelFragment;
import com.example.myapplication.ui.fragments.ScheduleFragment;
import com.example.myapplication.ui.fragments.SettingsFragment;

public class StudentPagerAdapter extends FragmentStateAdapter {

    public StudentPagerAdapter(@NonNull AppCompatActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PanelFragment();
            case 1:
                return new ScheduleFragment();
            case 2:
                return new ExamResultsFragment();
            case 3:
                return new AttendanceFragment();
            case 4:
                return new FeesFragment();
            default:
                return new SettingsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}