package com.talkon.talkon.fragment.mainFragment

import android.os.Bundle
import android.os.RecoverySystem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.talkon.talkon.R
import com.talkon.talkon.adapter.CountryAdapter
import com.talkon.talkon.adapter.TeacherFragmentAdapter
import com.talkon.talkon.fragment.BaseFragment
import com.talkon.talkon.model.Country
import com.talkon.talkon.model.Teacher

/**
 * In TeacherFragment, student can talk with teacher, search teacher
 */
class SearchTeacherFragment : BaseFragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_teacher, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(context, 1))
        refreshAdapter(getTeacher())
    }

    private fun refreshAdapter(items: ArrayList<Teacher>) {
        var adapter = TeacherFragmentAdapter(this, items)
        recyclerView.adapter = adapter
    }

    private fun getTeacher(): ArrayList<Teacher> {
        var teacher = ArrayList<Teacher>()
        val user = "https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1374"
        val user2 = "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387"
        var user3 = "https://images.unsplash.com/photo-1542596768-5d1d21f1cf98?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387"
        val user4 = "https://images.unsplash.com/photo-1528892952291-009c663ce843?ixlib=rb-1.2.1&raw_url=true&q=80&fm=jpg&crop=entropy&cs=tinysrgb&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=344"
        val text = "Let`s speak natural British Englis, TESL, IELTS TOEFL English together , Let`s speak natural British English together"
        val star = R.drawable.ic_gold_star_empty

        teacher.add(Teacher(user3,"Lisa Kudrov",text, "56 Lessons", star, "5", true, true, true))
        teacher.add(Teacher(user,"Jeniffer Aniston", text,"42 Lessons", star, "4.8", true, true, true, true))
        teacher.add(Teacher(user2,"Richard F.",text, "11 Lessons", star,"4.9", true, true, true, true))
        teacher.add(Teacher(user4,"Ross Geller", text, "New" ,true, false, true, false))
        teacher.add(Teacher(user,"Jeniffer Aniston", text,"12 Lessons", star, "4.8", true, false, true, true))
        teacher.add(Teacher(user2,"Richard F.",text, "11 Lessons", star,"4.9", true, true, true, true))
        teacher.add(Teacher(user4,"Ross Geller", text, "New" ,false, false, true, false))
        teacher.add(Teacher(user3,"Lisa Kudrov",text, "6 Lessons", star, "4.5", false, false, true))

        return teacher
    }
}