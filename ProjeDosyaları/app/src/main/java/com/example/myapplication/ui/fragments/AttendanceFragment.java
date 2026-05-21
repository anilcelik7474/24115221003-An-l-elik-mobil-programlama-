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
import com.example.myapplication.model.AttendanceRecord;
import com.example.myapplication.ui.common.UiFactory;

import java.util.List;

public class AttendanceFragment extends Fragment {

    private final StudentPortalClient portalClient = new StudentPortalClient();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attendance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<AttendanceRecord> attendanceRecords = portalClient.getAttendanceRecords();
        int totalDays = 0;
        for (AttendanceRecord attendanceRecord : attendanceRecords) {
            totalDays += attendanceRecord.getDayCount();
        }

        TextView summaryText = view.findViewById(R.id.attendanceSummaryText);
        summaryText.setText(getString(R.string.attendance_summary_format, totalDays));

        TableLayout attendanceTable = view.findViewById(R.id.attendanceTable);
        for (AttendanceRecord attendanceRecord : attendanceRecords) {
            TableRow row = new TableRow(requireContext());
            row.addView(createCell(attendanceRecord.getCourseName()));
            row.addView(createCell(attendanceRecord.getMissedDays()));
            attendanceTable.addView(row);
        }
    }

    private TextView createCell(String text) {
        TextView textView = UiFactory.createTableCell(requireContext(), text);
        textView.setLayoutParams(UiFactory.tableLayoutParams());
        return textView;
    }
}