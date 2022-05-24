package com.talkon.talkon.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.talkon.talkon.R
import com.talkon.talkon.fragment.LessonHistoryFragment
import com.talkon.talkon.fragment.ChatFragment
import com.talkon.talkon.fragment.ProfileFragment
import com.talkon.talkon.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*
/**
 * MainActivity contains view pager with 4 fragments
 * and pages can be controlled by BottomNavigationView
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val searchFragment = SearchFragment()
        val chatFragment = ChatFragment()
        val lessonHistoryFragment = LessonHistoryFragment()
        val profileFragment = ProfileFragment()

        replaceFragment(searchFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_search -> replaceFragment(searchFragment)
                R.id.menu_message -> replaceFragment(chatFragment)
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