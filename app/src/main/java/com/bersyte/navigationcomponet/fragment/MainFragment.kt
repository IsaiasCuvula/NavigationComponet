package com.bersyte.navigationcomponet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bersyte.navigationcomponet.R
import com.bersyte.navigationcomponet.databinding.FragmentChooseRecipientBinding
import com.bersyte.navigationcomponet.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var navController: NavController

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }

        binding.sendMoneyBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }

        binding.viewBalanceBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}