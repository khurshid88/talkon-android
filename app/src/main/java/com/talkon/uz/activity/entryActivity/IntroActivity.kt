package com.talkon.uz.activity.entryActivity

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.talkon.uz.R
import com.talkon.uz.activity.BaseActivity
import com.talkon.uz.adapter.IntroFragmentAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.activity_intro.*


/**
 * IntroActivity is used to introduce the application for users when they first installed the app
 */
class IntroActivity(): BaseActivity() {
    override var context: Context = this
    private var adapter: IntroFragmentAdapter? = null
    var dotsIndicator: WormDotsIndicator? = null
    lateinit var mColorAnimation: ValueAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        setTransparentStatusBar()
        initViews()
    }

    @SuppressLint("ResourceAsColor")
    private fun initViews() {
        dotsIndicator = findViewById<View>(R.id.dots_indicator) as WormDotsIndicator

        var slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide);
        ll_white_corner_rounded.animation = slideAnimation
        var fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_faster);
        viewPager.animation = fadeAnimation

        bt_get_started.setOnClickListener {
            callSignInActivity(this)
        }

        tv_sign_in.setOnClickListener {
            callSignInActivity(this)
        }
        // init slider pager adapter
        adapter = IntroFragmentAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        // set adapter
        viewPager.setAdapter(adapter)
        // set dot indicators
        dotsIndicator!!.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                animateToColor(pageColors[position])
            }
        })
    }

    var color1 = Color.argb(255,173, 247, 182 )
    var color2 = Color.argb(255,205, 180, 250 )
    var color3 = Color.argb(255,246, 238, 165 )
    var color4 = Color.argb(255,169, 212, 250 )
    var color5 = Color.argb(255,250, 189, 170 )
    var pageColors = intArrayOf(color1, color3, color2, color4, color5)
    var pageColors2 = intArrayOf(R.color.background_green,R.color.light_purple,R.color.light_gold,
        R.color.light_blue,R.color.light_orange, )
    var currentColor = pageColors[4]

    fun animateToColor(colorTo: Int) {
        mColorAnimation = ValueAnimator()
        if (mColorAnimation != null) {
            mColorAnimation.cancel()
        }
        mColorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), currentColor, colorTo)
        mColorAnimation.setDuration(500) // milliseconds
        mColorAnimation.addUpdateListener(AnimatorUpdateListener { animator ->
            currentColor = animator.animatedValue as Int
            ll_viewPager_background.setBackgroundColor(currentColor)
            bt_get_started.setBackgroundColor(currentColor)
            dotsIndicator?.setDotIndicatorColor(currentColor)

        })
        mColorAnimation.start()
    }
}