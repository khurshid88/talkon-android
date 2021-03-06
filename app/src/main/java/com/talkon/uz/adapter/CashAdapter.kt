package com.talkon.uz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.talkon.uz.R
import com.talkon.uz.model.Cash

class CashAdapter(var items: ArrayList<Cash> ) : BaseAdapter() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cash, parent, false)
        return CashViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is CashViewHolder) {
            var iv_profile_picture = holder.iv_profile_picture
            var tv_name = holder.tv_name
            var tv_started_hour = holder.tv_started_hour
            var tv_finished_hour = holder.tv_finished_hour
            var tv_date = holder.tv_date
            var teacher = item.teacher
            var tv_balance = holder.tv_balance


            Glide.with(iv_profile_picture.context).load(teacher.profile).error(R.drawable.ic_warning)
                .into(iv_profile_picture)
            tv_name.text = teacher.fullName
            tv_started_hour.text = item.startedHour
            tv_finished_hour.text = item.finishedHour
            tv_date.text = item.date
            tv_balance.text = item.balance

        }
    }

    class CashViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile_picture: ShapeableImageView = view.findViewById(R.id.iv_profile_picture)
        var tv_name: TextView = view.findViewById(R.id.tv_name)
        var tv_started_hour: TextView = view.findViewById(R.id.tv_started_hour)
        var tv_finished_hour: TextView = view.findViewById(R.id.tv_finished_hour)
        var tv_date: TextView = view.findViewById(R.id.tv_date)
        var tv_balance: TextView = view.findViewById(R.id.tv_item_cash_balance_count)

    }

}