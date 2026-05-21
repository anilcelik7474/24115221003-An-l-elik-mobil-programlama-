package com.example.myapplication.ui.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.myapplication.R;

public final class UiFactory {

    private UiFactory() {
    }

    public static TextView createTableCell(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(context, R.color.text_gray));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setBackgroundResource(R.drawable.bg_table_cell);
        int padding = dp(context, 12);
        textView.setPadding(padding, padding, padding, padding);
        return textView;
    }

    public static TextView createStatusCell(Context context, String status) {
        TextView textView = createTableCell(context, status);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        int horizontalPadding = dp(context, 10);
        int verticalPadding = dp(context, 6);
        textView.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);

        if ("Geçti".equalsIgnoreCase(status)) {
            textView.setBackgroundResource(R.drawable.bg_status_passed);
        } else if ("Şartlı".equalsIgnoreCase(status)) {
            textView.setBackgroundResource(R.drawable.bg_status_conditional);
        } else {
            textView.setBackgroundResource(R.drawable.bg_status_failed);
        }
        return textView;
    }

    public static LinearLayout.LayoutParams cardLayoutParams(Context context) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.bottomMargin = dp(context, 12);
        return params;
    }

    public static TableRow.LayoutParams tableLayoutParams() {
        return new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
    }

    public static int dp(Context context, int value) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                context.getResources().getDisplayMetrics()
        );
    }
}