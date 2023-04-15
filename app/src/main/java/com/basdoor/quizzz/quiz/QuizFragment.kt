package com.basdoor.quizzz.quiz

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.basdoor.quizzz.R
import com.basdoor.quizzz.services.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class QuizFragment : Fragment() {
    @Inject
    lateinit var dataManager: DataManager
    var currentQuestion = 0

    var var1:RadioButton? = null
    var var2:RadioButton? = null
    var var3:RadioButton? = null
    var allVars:RadioGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titlabel = view.findViewById<TextView>(R.id.welcum)
        titlabel.text = getString(R.string.welcum_quiz, dataManager.username)

        val varlay1 = view.findViewById<RadioButton>(R.id.variant_1)
        val varlay2 = view.findViewById<RadioButton>(R.id.variant_2)
        val varlay3 = view.findViewById<RadioButton>(R.id.variant_3)
        val allVarlay = view.findViewById<RadioGroup>(R.id.radio_group)

        val nxt = view.findViewById<Button>(R.id.next)
        nxt.setOnClickListener {

        }
        displayQuestion()
    }

    fun displayQuestion() {
        val question = view?.findViewById<TextView>(R.id.question)
        question?.text = dataManager.test.voprosi[currentQuestion].text
    }

}