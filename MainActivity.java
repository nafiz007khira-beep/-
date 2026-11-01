package com.mahfilschedule.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int dp(float v) {
        return (int) (v * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, float size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setTypeface(Typeface.DEFAULT, bold ? Typeface.BOLD : Typeface.NORMAL);
        t.setPadding(dp(16), dp(12), dp(16), dp(12));
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(248, 250, 248));

        TextView title = text("মাহফিলের সময়সূচি", 24, Color.WHITE, true);
        title.setGravity(Gravity.CENTER_VERTICAL);
        title.setBackgroundColor(Color.rgb(24, 112, 72));
        title.setPadding(dp(20), dp(18), dp(20), dp(18));
        root.addView(title, new LinearLayout.LayoutParams(-1, dp(72)));

        TextView subtitle = text("আজকের মাহফিল", 20, Color.rgb(24, 112, 72), true);
        root.addView(subtitle);

        TextView card = text(
            "📅 ৪ অক্টোবর ২০২৬\n\n" +
            "📍 ঢাকা\n" +
            "🕐 সন্ধ্যা ৭:৩০\n" +
            "🎙️ প্রধান বক্তা: শীঘ্রই যুক্ত হবে\n\n" +
            "মাহফিলের বিস্তারিত তথ্য এখানে দেখা যাবে।",
            16, Color.DKGRAY, false);
        card.setBackgroundColor(Color.WHITE);
        root.addView(card, new LinearLayout.LayoutParams(-1, -2));

        TextView note = text(
            "এই সংস্করণটি প্রাথমিক ডেমো। পরের ধাপে মাহফিল যোগ করা, জেলা/উপজেলা অনুযায়ী খোঁজা, লোকেশন ও নোটিফিকেশন যোগ করা যাবে।",
            15, Color.GRAY, false);
        root.addView(note);

        setContentView(root);
    }
}
