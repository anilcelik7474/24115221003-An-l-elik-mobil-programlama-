package com.example.myapplication.ui.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.ui.adapters.StudentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class StudentHomeActivity extends AppCompatActivity {

    public static final String EXTRA_FULL_NAME = "extra_full_name";
    public static final String EXTRA_STUDENT_NUMBER = "extra_student_number";

    private final int[] tabTitles = new int[]{
            R.string.tab_panel,
            R.string.tab_schedule,
            R.string.tab_exam_results,
            R.string.tab_attendance,
            R.string.tab_fees,
            R.string.tab_settings
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        String fullName = getIntent().getStringExtra(EXTRA_FULL_NAME);
        String studentNumber = getIntent().getStringExtra(EXTRA_STUDENT_NUMBER);

        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.welcome_format, fullName, studentNumber));

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new StudentPagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabTitles[position]))
                .attach();
    }
}