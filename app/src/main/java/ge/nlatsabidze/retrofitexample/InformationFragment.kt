package ge.nlatsabidze.retrofitexample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.retrofitexample.databinding.FragmentMainBinding

const val TAG = "FragmentError"

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var infoAdapter: InfoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
        setResult()
    }

    private fun setUpRecyclerView() = binding.rvTodos.apply {
        infoAdapter = InfoAdapter()
        adapter = infoAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setResult() {
        lifecycleScope.launchWhenCreated {

            if (RetrofitInstance.API.getTodos().isSuccessful) {
                infoAdapter.info = RetrofitInstance.API.getTodos().body()!!.content
            }
            Log.d("tag", RetrofitInstance.API.getTodos().toString())
        }

    }
}
