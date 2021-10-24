package ge.nlatsabidze.retrofitexample

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class InfoFragmentViewModel : ViewModel() {

    private var _info = MutableLiveData<List<Content>>()
    val info: LiveData<List<Content>>
        get() = _info

    fun setResult() {
        viewModelScope.launch {
            if (RetrofitInstance.API.getTodos().isSuccessful) {
                _info.value = RetrofitInstance.API.getTodos().body()!!.content
            }
        }
    }
}