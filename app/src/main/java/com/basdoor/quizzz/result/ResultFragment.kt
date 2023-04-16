package com.basdoor.quizzz.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.basdoor.quizzz.R
import com.basdoor.quizzz.services.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultFragment : Fragment() {
    @Inject
    lateinit var dataManager: DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var result = view.findViewById<TextView>(R.id.score)
        result.text = getString(R.string.score, dataManager.test.score.toString())
        val restart = view.findViewById<Button>(R.id.restart)
        restart.setOnClickListener {
            dataManager.test.score = 0
            findNavController().popBackStack(R.id.loginFragment, false)
        }
    }
}