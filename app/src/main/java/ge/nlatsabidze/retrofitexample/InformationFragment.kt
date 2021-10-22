package ge.nlatsabidze.retrofitexample

import android.app.ProgressDialog
import android.os.*
import android.util.*
import android.view.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.*
import ge.nlatsabidze.retrofitexample.databinding.*
import kotlinx.coroutines.*
import retrofit2.*
import java.io.*

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

            delay(1000)

            val response = try {

                RetrofitInstance.API.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IoException")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "Wrong HTTP")
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                infoAdapter.info = response.body()!!
            } else {
                Log.e(TAG, "Response is not successful")
            }
        }
    }
}