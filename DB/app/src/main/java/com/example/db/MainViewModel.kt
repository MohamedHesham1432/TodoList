package com.example.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.db.data.db.UserDatabase
import com.example.db.data.db.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
  //  private val userDao = UserDatabase.getDatabase(application).userDao()

    private val userDao = UserDatabase.getDatabase(application).userDao()

    private val _allUsers = MutableStateFlow<List<User>>(emptyList())
    val allUsers: StateFlow<List<User>> = _allUsers

    init {
        fetchAllUsers()
    }
    private fun fetchAllUsers() {
        viewModelScope.launch {
            _allUsers.value = userDao.getAllUsers()
            println("All Users: ${_allUsers.value}")
        }
    }

    fun insert(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
            fetchAllUsers()
        }

    }
}