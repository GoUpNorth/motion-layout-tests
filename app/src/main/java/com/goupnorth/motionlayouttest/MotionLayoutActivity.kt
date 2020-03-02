package com.goupnorth.motionlayouttest

import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import com.goupnorth.motionlayouttest.databinding.MotionLayoutTestBinding


class MotionLayoutActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    private lateinit var binding: MotionLayoutTestBinding

    private val appBarLayout: AppBarLayout
        get() = binding.appBarLayout

    private val motionLayout: MotionLayout
        get() = binding.motionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MotionLayoutTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appBarLayout.addOnOffsetChangedListener(this)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        appBarLayout?.let {
            motionLayout.progress = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
        }
    }
}