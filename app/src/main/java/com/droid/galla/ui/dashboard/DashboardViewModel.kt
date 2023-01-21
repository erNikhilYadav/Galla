package com.droid.galla.ui.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.galla.data.entities.Customer
import com.droid.galla.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject
constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {


    fun mSaveCustomerNameToDB(name: Customer) {
        viewModelScope.launch {
            try {
                dashboardRepository.mSaveCustomerToDB(name)
            } catch (e: Exception) {
                Log.d(TAG, "mSaveCustomerNameToDB: ${e.message}")
            }
        }
    }

    companion object {
        private const val TAG = "DashboardViewModel"
    }
}