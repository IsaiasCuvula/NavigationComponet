package com.bersyte.navigationcomponet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bersyte.navigationcomponet.Money
import com.bersyte.navigationcomponet.R
import com.bersyte.navigationcomponet.databinding.FragmentChooseRecipientBinding
import com.bersyte.navigationcomponet.databinding.FragmentConfirmationBinding


class ConfirmationFragment : Fragment(R.layout.fragment_confirmation) {

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipient: String
    private lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = money.amount
        val confirmationMessage = "You have sent ${amount}$ to $recipient"
        binding.confirmationMessage.text = confirmationMessage
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}