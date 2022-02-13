package com.pfs.myteam.ui.my_team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pfs.myteam.models.Driver
import com.pfs.myteam.repository.DriverRepository

class MyTeamViewModel : ViewModel() {
    private val driverRepository = DriverRepository()

    // Drivers
    private var _driversList = MutableLiveData<ArrayList<Driver>>()

    // Drivers to select for team
    private var _myDrivers = MutableLiveData<ArrayList<Driver>>()

    val driversList: LiveData<ArrayList<Driver>> = liveData {
        val data = driverRepository.getUsersObjects()
        emit(data)
    }

    val myDrivers: LiveData<ArrayList<Driver>> = liveData {
        val data = ArrayList<Driver>()
            for (i in 0..4){
                data.add(Driver("","",0,0,"",0,0))
            }
        emit(data)
    }
}