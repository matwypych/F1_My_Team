package com.pfs.myteam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pfs.myteam.R
import com.pfs.myteam.models.Driver
import com.pfs.myteam.databinding.ItemCardDriverBinding

class DriverAdapter(var context: Context): RecyclerView.Adapter<DriverAdapter.ViewHolder>() {

    var dataList = ArrayList<Driver>()
    private var _binding: ItemCardDriverBinding? = null
    val binding get() = _binding!!

    internal fun setDataList(dataList: ArrayList<Driver>){
        this.dataList = dataList
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var driverPrice: TextView
        var driverPoints: TextView
        var driverName: TextView
        var addBtn: Button
        var driverImg: ImageView

        init {
            driverImg = itemView.findViewById(R.id.driver_image)
            addBtn = itemView.findViewById(R.id.btn_add_driver)
            driverName = itemView.findViewById(R.id.driver_name)
            driverPoints = itemView.findViewById(R.id.driver_points)
            driverPrice = itemView.findViewById(R.id.driver_price)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_driver, parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val driver = dataList[position]

        if(driver.firstName == " ")
        {
            holder.addBtn.visibility = View.VISIBLE
        }
        val fullName: String = driver.firstName + " " + driver.lastName

        holder.driverName.text = fullName
        holder.driverPrice.text = driver.buyPrice.toString()
        holder.driverPoints.text =driver.fantasyPoints.toString()
    }

    override fun getItemCount(): Int {
        println("data list count ${dataList.size}" )
        return dataList.size
    }
}