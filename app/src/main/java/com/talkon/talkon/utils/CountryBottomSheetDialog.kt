package com.talkon.talkon.utils

import android.os.Bundle
import android.view.*
import androidx.annotation.Nullable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.talkon.talkon.R
import com.talkon.talkon.adapter.CountryDialogAdapter
import com.talkon.talkon.model.Country

/**
 * CountryBottomSheetDialog is used for choosing a country code when entering a phone number in SignUpActivity
 */

class CountryBottomSheetDialog : BottomSheetDialogFragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.country_bottom_sheet_layout, container, false)
        initViews(view)
        return view
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getDialog()?.getWindow()
            ?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(context, 1))
        refreshAdapter(getCountryCode())
    }

    private fun refreshAdapter(items: ArrayList<Country>) {
        var adapter = CountryDialogAdapter(this, items)
        recyclerView.adapter = adapter
    }

    private fun getCountryCode(): ArrayList<Country> {
        var country = ArrayList<Country>()

        country.add(Country("https://images.unsplash.com/photo-1626836014893-37663794dca7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=846&q=80","+998","Afghansitan"))
        country.add(Country("https://images.unsplash.com/photo-1626836014893-37663794dca7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=846&q=80","+998","Afghansitan"))
        country.add(Country("https://images.unsplash.com/photo-1626836014893-37663794dca7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=846&q=80","+9","Afghansitan"))
        country.add(Country("https://images.unsplash.com/photo-1626836014893-37663794dca7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=846&q=80","+9987","Afghansitan"))
        country.add(Country("https://images.unsplash.com/photo-1626836014893-37663794dca7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=846&q=80","+998","US"))
        country.add(Country("https://images.unsplash.com/photo-1626836014893-37663794dca7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=846&q=80","+998","Uzbekistan"))

        return country
    }

}