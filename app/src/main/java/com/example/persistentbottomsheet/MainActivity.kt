package com.example.persistentbottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle.State
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehaviour: BottomSheetBehavior<View>
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView_state)

        val view: View = findViewById(R.id.bottom_sheet)
        bottomSheetBehaviour = BottomSheetBehavior.from(view)


        val buttonOpen: Button = findViewById(R.id.btn_open)
        val buttonCollapse: Button = findViewById(R.id.btn_collapse)


        buttonOpen.setOnClickListener {
            bottomSheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
            textView.text = "Expanded"
        }

        buttonCollapse.setOnClickListener {
            bottomSheetBehaviour.state = BottomSheetBehavior.STATE_COLLAPSED
            textView.text = "Collapsed"
        }



        bottomSheetBehaviour.addBottomSheetCallback(object: BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        textView.text = "COLLAPSED"
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        textView.text = "EXPANDED"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        textView.text = "DRAGGING"
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        textView.text = "SETTLING"
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
    }
}