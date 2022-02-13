package com.pfs.myteam.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

import com.pfs.myteam.models.Driver
import kotlinx.coroutines.tasks.await

class DriverRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val currentUser = Firebase.auth.currentUser


    suspend fun getUsersObjects(): ArrayList<Driver> {
        val result: ArrayList<Driver> = ArrayList()
        val snapshot = firestore.collection("drivers").get().await()

        for (document in snapshot.documents){
            document.toObject(Driver::class.java)?.let { result.add(it) }
        }

        return result
    }



}
