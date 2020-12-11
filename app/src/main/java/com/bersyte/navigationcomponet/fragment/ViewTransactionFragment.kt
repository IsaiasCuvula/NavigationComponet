package com.bersyte.navigationcomponet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bersyte.navigationcomponet.R
import com.bersyte.navigationcomponet.databinding.FragmentChooseRecipientBinding
import com.bersyte.navigationcomponet.databinding.FragmentViewTransactionBinding


class ViewTransactionFragment : Fragment(R.layout.fragment_view_transaction) {

    private var _binding: FragmentViewTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = FragmentViewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}