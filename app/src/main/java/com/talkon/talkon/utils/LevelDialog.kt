package com.talkon.talkon.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.talkon.talkon.R
import com.talkon.talkon.activity.entryActivity.StatusChooseActivity
import com.talkon.talkon.adapter.LevelDialogAdapter

class LevelDialog: DialogFragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var activity: StatusChooseActivity

    public lateinit var selectedLevel: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.white_border_rounded);
        var view = inflater.inflate(R.layout.level_dialog_fragment, container, false)

        initViews(view)
        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(context, 1))
        refreshAdapter(getLevel())
    }

    private fun refreshAdapter(items: ArrayList<String>) {
        var adapter = LevelDialogAdapter(this, items)
        recyclerView.adapter = adapter
    }
    fun getItemLevel(level: String) {
        selectedLevel = level
    }

    private fun getLevel(): ArrayList<String> {
        var level = ArrayList<String>()

        level.add("Beginner")
        level.add("Elementary")
        level.add("PreIntermediate")
        level.add("Intermediate")
        level.add("UpperIntermediate")
        level.add("Advanced")
        return level
    }


}