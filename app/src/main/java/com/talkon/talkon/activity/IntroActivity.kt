package com.talkon.talkon.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.talkon.talkon.manager.SharedPref
import com.talkon.talkon.R
import com.talkon.talkon.adapter.IntroFragmentAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_splash.view.*

class IntroActivity : BaseActivity() {
    private lateinit var viewPager: ViewPager
    override var context: Context = this
    private var adapter: IntroFragmentAdapter? = null
    var dotsIndicator: WormDotsIndicator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
//        overridePendingTransition(  R.anim.main_fade_in, 0 );
        initViews()
    }

    private fun initViews() {
        dotsIndicator = findViewById<View>(R.id.dots_indicator) as WormDotsIndicator
        viewPager = findViewById(R.id.viewPager)
        bt_get_started.setOnClickListener {
            callSignUpActivity(this)
        }

        tv_sign_in.setOnClickListener {
            callSignInActivity(this)
        }
        // init slider pager adapter
        adapter = IntroFragmentAdapter(supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        // set adapter
        viewPager.setAdapter(adapter)
        // set dot indicators
        dotsIndicator!!.setViewPager(viewPager)
        // make status bar transparent

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (position == adapter!!.count - 1) {

                    bt_get_started.setOnClickListener {
//                        SharedPref(context).isSaved = true
                        callSignUpActivity(this@IntroActivity)
                    }
                }
            }
        })

        
    }


    private fun getItem(i: Int): Int {
        return viewPager.currentItem + i
    }

}