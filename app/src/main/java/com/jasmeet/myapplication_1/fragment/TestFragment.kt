package com.jasmeet.myapplication_1.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.jasmeet.myapplication_1.R
import com.jasmeet.myapplication_1.adapter.TopGroceryAdapter
import com.jasmeet.myapplication_1.apis.ApiInterface
import com.jasmeet.myapplication_1.apis.ApiUtilities
import com.jasmeet.myapplication_1.databinding.FragmentTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTestBinding.inflate(layoutInflater)

        randomData()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.descPrice ->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByDescPrice()
            }
            R.id.ascPrice ->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByAscPrice()
            }
            R.id.descDate ->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByDescDate()
            }
            R.id.ascDate ->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByAscDate()
            }
            R.id.ascVillage ->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByAscVillage()
            }
            R.id.descVillage ->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByDescVillage()
            }
            R.id.descDistricts->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByDescDistricts()
            }
            R.id.ascDistricts->{
                Toast.makeText(requireContext(),"Loading....",Toast.LENGTH_SHORT).show()
                sortByAscDistricts()
            }

        }
        return true
    }

    private fun sortByAscDistricts() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedBy {
                it.district
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }
    }

    private fun sortByDescDistricts() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedByDescending {
                it.district
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }
    }

    private fun sortByDescVillage() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedByDescending {
                it.market
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }
    }

    private fun sortByAscVillage() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedBy {
                it.market
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }

    }

    private fun sortByDescDate() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedByDescending {
                it.arrival_date
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }

    }

    private fun sortByAscDate() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedBy{
                it.arrival_date
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }
    }

    private fun sortByAscPrice() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedBy{
                it.modal_price
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }
    }
    private fun sortByDescPrice() {

        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records
            val mainlist =  newList.sortedByDescending {
                it.modal_price
            }

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),mainlist)
            }
        }
    }

    private fun randomData() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getGroceryData()

            val newList = res.body()!!.records

            withContext(Dispatchers.Main){
                binding.recyclerView.adapter = TopGroceryAdapter(requireContext(),newList)
            }
        }

    }


}