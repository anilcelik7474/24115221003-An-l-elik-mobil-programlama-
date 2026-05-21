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
import com.example.myapplication.model.ExamResult;
import com.example.myapplication.ui.common.UiFactory;

import java.util.List;

public class ExamResultsFragment extends Fragment {

    private final StudentPortalClient portalClient = new StudentPortalClient();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exam_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TableLayout examTable = view.findViewById(R.id.examTable);
        List<ExamResult> examResults = portalClient.getExamResults();

        for (ExamResult examResult : examResults) {
            TableRow row = new TableRow(requireContext());
            row.addView(createCell(examResult.getExamDate()));
            row.addView(createCell(examResult.getCourseName()));
            row.addView(createCell(examResult.getResult()));
            examTable.addView(row);
        }
    }

    private TextView createCell(String text) {
        TextView textView = UiFactory.createTableCell(requireContext(), text);
        textView.setLayoutParams(UiFactory.tableLayoutParams());
        return textView;
    }
}