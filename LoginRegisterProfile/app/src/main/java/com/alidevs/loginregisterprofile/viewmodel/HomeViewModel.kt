package com.alidevs.loginregisterprofile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alidevs.loginregisterprofile.model.UserModel
import com.alidevs.loginregisterprofile.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel constructor(private val repository: UserRepository) : ViewModel() {

	val usersLiveData = MutableLiveData<List<UserModel>>()

	fun getAllUsers() {
		CoroutineScope(Dispatchers.IO).launch {
			val response = repository.getAllUsers()
			withContext(Dispatchers.Main) {
				if (!response.isSuccessful) {
					usersLiveData.value = null
					return@withContext
				}

				response.body()?.let { usersList ->
					usersLiveData.value = usersList.takeIf { it.isNotEmpty() }
				}
			}
		}
	}

}