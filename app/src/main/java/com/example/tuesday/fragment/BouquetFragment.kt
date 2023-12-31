package com.example.tuesday.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuesday.R
import com.example.tuesday.activity.BuyActivity
import com.example.tuesday.activity.FlowerSelectListener
import com.example.tuesday.adapter.FlowerListRecyclerAdapter
import com.example.tuesday.databinding.FragmentBouquetBinding

class BouquetFragment : Fragment(), FlowerSelectListener {
    lateinit var binding: FragmentBouquetBinding
    private val flowerListAdapter = FlowerListRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flowerListAdapter.listeningActivity = this

        binding.btnBuy.setOnClickListener {
            val intent = Intent(requireContext(), BuyActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext()).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        flowerListAdapter
        binding.recyclerView.adapter = flowerListAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBouquetBinding.inflate(layoutInflater)

        return binding.root
    }

    var num = 0
    override fun flowerSelected() {
        Log.d("change","change")
        when(num){
            0 -> {
                binding.combined.setImageResource(R.drawable.flower_combine1)
                num++
            }
            1 -> {
                binding.combined.setImageResource(R.drawable.sdfsdf)
                num++
            }
            2 -> {
                binding.combined.setImageResource(R.drawable.flower_combined)
                num++
            }
            else -> {
                binding.combined.setImageResource(R.drawable.fdsfd)
                num = 0
            }
        }

    }


}