package com.example.studyapproomoptional.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapproomoptional.DBRoom.Android.Android
import com.example.studyapproomoptional.DBRoom.Kotlin.Kotlin
import com.example.studyapproomoptional._partial.CustomAlertDialog
import com.example.studyapproomoptional.databinding.ItemRowBinding

class RVAdapter(private val activity: Activity, private val itemsAndroid: List<Android>?,private val itemsKotlin: List<Kotlin>?):
    RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
                )
            )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            if (itemsAndroid != null)
            {
                tvId.text= "id:"+itemsAndroid[position].id.toString()
                tvTitle.text = itemsAndroid[position].title
                tvDetails.text = itemsAndroid[position].description
                cvCard.setOnClickListener {
                    CustomAlertDialog(activity, itemsAndroid[position].title!!,itemsAndroid[position].details!!)
                }

            }
            else
            {
                tvId.text= "id:"+itemsKotlin!![position].id.toString()
                tvTitle.text = itemsKotlin!![position].title
                tvDetails.text =  itemsKotlin!![position].description
                cvCard.setOnClickListener { CustomAlertDialog(activity,
                    itemsKotlin!![position].title!!,
                    itemsKotlin!![position].details!!

                ) }

            }
        }
    }

    override fun getItemCount(): Int {
        if (itemsAndroid!=null)
        {
           return itemsAndroid.size
        }
        else
        {
           return itemsKotlin!!.size
        }
    }
}