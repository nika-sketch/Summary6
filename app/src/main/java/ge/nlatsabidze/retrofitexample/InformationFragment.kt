package ge.nlatsabidze.retrofitexample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ge.nlatsabidze.retrofitexample.databinding.FragmentMainBinding

const val TAG = "FragmentError"

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var infoAdapter: InfoAdapter

    private val viewModel: InfoFragmentViewModel by viewModels()

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
        viewModel.setResult()

        viewModel.info.observe(viewLifecycleOwner, {
            infoAdapter.info = it
        })
    }
}
