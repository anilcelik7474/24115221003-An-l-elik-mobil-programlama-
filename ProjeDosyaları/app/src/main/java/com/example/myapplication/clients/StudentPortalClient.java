package com.example.myapplication.clients;

import com.example.myapplication.model.AttendanceRecord;
import com.example.myapplication.model.CourseResult;
import com.example.myapplication.model.ExamResult;
import com.example.myapplication.model.ScheduleItem;
import com.example.myapplication.model.StudentSummary;

import java.util.Arrays;
import java.util.List;

public class StudentPortalClient {

    public StudentSummary getStudentSummary() {
        return new StudentSummary("3.45", "180/204", "%92");
    }

    public List<CourseResult> getCourseResults() {
        return Arrays.asList(
                new CourseResult("Nesne Yönelimli Programlama", 85, 90, 6, "2 gün", "Geçti"),
                new CourseResult("Veri Yapıları", 70, 65, 5, "4 gün", "Geçti"),
                new CourseResult("Veritabanı Yönetimi", 70, 65, 6, "1 gün", "Şartlı"),
                new CourseResult("Web Tasarımı", 95, 100, 4, "0 gün", "Geçti"),
                new CourseResult("Ayrık Matematik", 30, 40, 5, "8 gün", "Kaldı")
        );
    }

    public List<ScheduleItem> getScheduleItems() {
        return Arrays.asList(
                new ScheduleItem("Pazartesi", "09:00 - 10:50", "Nesne Yönelimli Programlama", "B-201"),
                new ScheduleItem("Salı", "11:00 - 12:50", "Veri Yapıları", "A-104"),
                new ScheduleItem("Çarşamba", "13:00 - 14:50", "Veritabanı Yönetimi", "Lab-2"),
                new ScheduleItem("Perşembe", "10:00 - 11:50", "Web Tasarımı", "C-309"),
                new ScheduleItem("Cuma", "15:00 - 16:50", "Ayrık Matematik", "D-107")
        );
    }

    public List<ExamResult> getExamResults() {
        return Arrays.asList(
                new ExamResult("12.05.2026", "Nesne Yönelimli Programlama", "90"),
                new ExamResult("15.05.2026", "Veri Yapıları", "65"),
                new ExamResult("18.05.2026", "Veritabanı Yönetimi", "Henüz not verilmedi"),
                new ExamResult("20.05.2026", "Web Tasarımı", "100"),
                new ExamResult("23.05.2026", "Ayrık Matematik", "40")
        );
    }

    public List<AttendanceRecord> getAttendanceRecords() {
        return Arrays.asList(
                new AttendanceRecord("Nesne Yönelimli Programlama", "2 gün", 2),
                new AttendanceRecord("Veri Yapıları", "4 gün", 4),
                new AttendanceRecord("Veritabanı Yönetimi", "1 gün", 1),
                new AttendanceRecord("Ayrık Matematik", "8 gün", 8)
        );
    }
}