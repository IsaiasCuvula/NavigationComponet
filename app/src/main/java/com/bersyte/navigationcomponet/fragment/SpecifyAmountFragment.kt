package com.bersyte.navigationcomponet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bersyte.navigationcomponet.Money
import com.bersyte.navigationcomponet.R
import com.bersyte.navigationcomponet.databinding.FragmentChooseRecipientBinding
import com.bersyte.navigationcomponet.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(R.layout.fragment_specify_amount) {

    private lateinit var navController: NavController
    private lateinit var recipient: String

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val message = "Sending money to $recipient"
        binding.recipient.text = message

        binding.sendBtn.setOnClickListener {

            if (binding.inputAmount.text!!.isNotEmpty()) {
                val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount
                )
                navController.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    bundle
                )
            } else {
                Toast.makeText(activity, "Enter an Amount", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cancelBtn.setOnClickListener {
            activity?.onBackPressed()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}