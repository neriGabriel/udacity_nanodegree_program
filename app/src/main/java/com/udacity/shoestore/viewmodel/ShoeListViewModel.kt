package com.udacity.shoestore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel: ViewModel() {

    private var _shoeList: MutableLiveData<MutableList<Shoe>> =
        MutableLiveData(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    private var _shoeSaveSate: MutableLiveData<Boolean> = MutableLiveData()
    val shoeSaveSate: LiveData<Boolean> get() = _shoeSaveSate

    init {
        _shoeSaveSate.value = false
    }
    fun addShoe(shoe: Shoe) {
        _shoeSaveSate.value = true
        _shoeList.value?.add(shoe)
    }

    fun onAddComplete () {
        _shoeSaveSate.value = false
    }
}