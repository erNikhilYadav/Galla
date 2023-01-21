package com.droid.galla.repository

import com.droid.galla.data.dao.CustomerDao
import com.droid.galla.data.entities.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DashboardRepository @Inject constructor(
    private val customerDao: CustomerDao
) {
    suspend fun mSaveCustomerToDB(name: Customer) {
        withContext(Dispatchers.IO) {
            customerDao.insertCustomer(name)
        }
    }
}