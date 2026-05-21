package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.clients.StudentPortalClient;
import com.example.myapplication.model.CourseResult;
import com.example.myapplication.model.StudentSummary;
import com.example.myapplication.ui.common.UiFactory;

import java.util.List;

public class PanelFragment extends Fragment {

    private final StudentPortalClient portalClient = new StudentPortalClient();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_panel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        StudentSummary summary = portalClient.getStudentSummary();
        ((TextView) view.findViewById(R.id.gpaValueText)).setText(summary.getGpa());
        ((TextView) view.findViewById(R.id.ectsValueText)).setText(summary.getCompletedEcts());
        ((TextView) view.findViewById(R.id.attendanceRateText)).setText(summary.getAttendanceRate());

        TableLayout courseTable = view.findViewById(R.id.courseTable);
        List<CourseResult> courseResults = portalClient.getCourseResults();
        for (CourseResult courseResult : courseResults) {
            TableRow row = new TableRow(requireContext());
            row.addView(createCell(courseResult.getCourseName()));
            row.addView(createCell(String.valueOf(courseResult.getMidtermScore())));
            row.addView(createCell(String.valueOf(courseResult.getFinalScore())));
            row.addView(createCell(String.valueOf(courseResult.getEcts())));
            row.addView(createCell(courseResult.getAbsence()));
            row.addView(UiFactory.createStatusCell(requireContext(), courseResult.getStatus()));
            courseTable.addView(row);
        }
    }

    private TextView createCell(String text) {
        TextView textView = UiFactory.createTableCell(requireContext(), text);
        textView.setLayoutParams(UiFactory.tableLayoutParams());
        return textView;
    }
}