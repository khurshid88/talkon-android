package com.talkon.uz.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hbisoft.hbrecorder.HBRecorder
import com.hbisoft.hbrecorder.HBRecorderListener
import com.talkon.uz.R
import com.talkon.uz.fragment.LessonHistoryFragment
import com.talkon.uz.fragment.ProfileFragment
import com.talkon.uz.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity contains view pager with 4 fragments
 * and pages can be controlled by BottomNavigationView
 */
class MainActivity : BaseActivity() {
    private val hbRecorder: HBRecorder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val searchFragment = SearchFragment()
        val lessonHistoryFragment = LessonHistoryFragment()
        val profileFragment = ProfileFragment()

        replaceFragment(searchFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_search -> replaceFragment(searchFragment)
                R.id.menu_courses -> replaceFragment(lessonHistoryFragment)
                R.id.menu_profile -> replaceFragment(profileFragment)

            }
            true
        }

    }

    fun replaceFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.name
        val manager = supportFragmentManager
        val fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
        if (!fragmentPopped) {
            val ft = manager.beginTransaction()
            ft.replace(R.id.fl_Fragment, fragment)
            ft.addToBackStack(backStateName)
            ft.commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1)
            finish()
        else
            super.onBackPressed()
    }

}