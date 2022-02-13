package com.pfs.myteam.ui.my_team

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.pfs.myteam.adapters.DriverAdapter
import com.pfs.myteam.databinding.FragmentMyTeamBinding
import com.pfs.myteam.models.Driver



class MyTeam : Fragment() {

    companion object {
        fun newInstance() = MyTeam()
    }

    private lateinit var viewModel: MyTeamViewModel
    private var _binding: FragmentMyTeamBinding? = null
    private lateinit var driverAdapter: DriverAdapter
    private var dataList = ArrayList<Driver>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[MyTeamViewModel::class.java]

        _binding = FragmentMyTeamBinding.inflate(inflater, container, false)
        val root: View = binding.root

        driverAdapter = DriverAdapter(requireContext())

        initRecycleView()
        binding.gridViewDrivers.layoutManager = GridLayoutManager(context,3)
        binding.gridViewDrivers.adapter = driverAdapter

        viewModel.myDrivers.observe(this, Observer {
            driverAdapter.setDataList(it)
        })

        return root
    }


    private fun initRecycleView(){

        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.justifyContent = JustifyContent.CENTER
        layoutManager.alignItems = AlignItems.CENTER
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP

        binding.gridViewDrivers.layoutManager = layoutManager
    }




}