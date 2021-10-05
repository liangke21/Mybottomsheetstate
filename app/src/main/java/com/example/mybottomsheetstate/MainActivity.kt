package com.example.mybottomsheetstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val behavior = BottomSheetBehavior.from(findViewById(R.id.ll_content_bottom_sheet))
        behavior.setState(BottomSheetBehavior.STATE_SETTLING)
        findViewById<Button>(R.id.button).setOnClickListener {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }


 /*       if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }*/

    }



}