package com.pfs.myteam.ui.rewards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pfs.myteam.databinding.FragmentRewardsBinding

class RewardsFragment : Fragment() {

    private lateinit var rewardsViewModel: RewardsViewModel
    private var _binding: FragmentRewardsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rewardsViewModel =
            ViewModelProvider(this).get(RewardsViewModel::class.java)

        _binding = FragmentRewardsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}