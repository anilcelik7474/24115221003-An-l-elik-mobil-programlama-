package com.example.myapplication.ui.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.clients.StudentPortalClient;
import com.example.myapplication.model.ScheduleItem;
import com.example.myapplication.ui.common.UiFactory;

import java.util.List;

public class ScheduleFragment extends Fragment {

    private final StudentPortalClient portalClient = new StudentPortalClient();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout scheduleContainer = view.findViewById(R.id.scheduleContainer);
        List<ScheduleItem> scheduleItems = portalClient.getScheduleItems();

        for (ScheduleItem scheduleItem : scheduleItems) {
            LinearLayout card = new LinearLayout(requireContext());
            card.setOrientation(LinearLayout.VERTICAL);
            card.setBackgroundResource(R.drawable.bg_card);
            int padding = UiFactory.dp(requireContext(), 16);
            card.setPadding(padding, padding, padding, padding);
            card.setLayoutParams(UiFactory.cardLayoutParams(requireContext()));

            TextView dayText = createText(scheduleItem.getDay() + " - " + scheduleItem.getTime(), true);
            TextView courseText = createText(scheduleItem.getCourseName(), false);
            courseText.setPadding(0, UiFactory.dp(requireContext(), 8), 0, 0);
            TextView classText = createText("Derslik: " + scheduleItem.getClassroom(), false);
            classText.setPadding(0, UiFactory.dp(requireContext(), 8), 0, 0);

            card.addView(dayText);
            card.addView(courseText);
            card.addView(classText);
            scheduleContainer.addView(card);
        }
    }

    private TextView createText(String text, boolean bold) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_gray));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        if (bold) {
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        }
        return textView;
    }
}