package com.droid.galla.ui.dashboard

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.droid.galla.R
import com.droid.galla.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private var customerDialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSetAction()
    }

    private fun mSetAction() {
        binding.addCustomerFab.setOnClickListener {
            customerDialog = Dialog(requireContext())
            customerDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            customerDialog!!.setContentView(R.layout.dialog_add_customer)
            val lp = WindowManager.LayoutParams()
            lp.copyFrom(customerDialog!!.window!!.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT

            customerDialog!!.show()
            customerDialog!!.window!!.attributes = lp
        }
    }
}