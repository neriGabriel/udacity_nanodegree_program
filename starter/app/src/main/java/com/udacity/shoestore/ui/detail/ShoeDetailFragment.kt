package com.udacity.shoestore.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private  val shoeListViewModel: ShoeListViewModel by activityViewModels()

    private val shoeUIData = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,
            container, false)
        binding.shoeListViewModel = shoeListViewModel
        binding.shoeUIData = shoeUIData

        shoeListViewModel.shoeSaveSate.observe(this.viewLifecycleOwner, Observer {
            when(it) {
                true -> {
                    navigateToShoeList()
                    shoeListViewModel.onAddComplete()
                }
            }
        })

        binding.cancel.setOnClickListener {
            navigateToShoeList()
        }
        return binding.root
    }

    private fun navigateToShoeList() {
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}