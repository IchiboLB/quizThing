package com.basdoor.quizzz.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.basdoor.quizzz.R
import com.basdoor.quizzz.services.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class LoginFragment : Fragment() {
    @Inject
    lateinit var dataManager: DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.login)
        CheckButtonEnabled()


        button.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_quizFragment)
        }

        val userTextField = view.findViewById<TextView>(R.id.username_textField)
        userTextField.doOnTextChanged { text, start, before, count ->

            dataManager.username = text.toString()
            CheckButtonEnabled()
        }
    }

    private fun CheckButtonEnabled() {
        val button = view?.findViewById<Button>(R.id.login)
        button?.isEnabled = !dataManager.username.isEmpty()
    }

}