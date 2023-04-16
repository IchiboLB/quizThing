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
import androidx.navigation.fragment.findNavController
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

        var1 = view.findViewById<RadioButton>(R.id.variant_1)
        var2 = view.findViewById<RadioButton>(R.id.variant_2)
        var3 = view.findViewById<RadioButton>(R.id.variant_3)
        allVars = view.findViewById<RadioGroup>(R.id.radio_group)

        val nxt = view.findViewById<Button>(R.id.next)
        nxt.setOnClickListener {
            nxt.isEnabled = false

            val questionCurrent = dataManager.test.voprosi[currentQuestion]
            val correctIndex = questionCurrent.otveti.indexOfFirst { otvet ->
                otvet.isCorrect == true
            }

            if(correctIndex == 0) {
                if(var1?.isChecked == true) {
                    dataManager.test.score+=10
                }
            } else if(correctIndex == 1) {
                if(var2?.isChecked == true) {
                    dataManager.test.score+=10
                }

            } else if(correctIndex == 2) {
                if(var3?.isChecked == true) {
                    dataManager.test.score+=10
                }

            }

            currentQuestion+=1
            if (currentQuestion < dataManager.test.voprosi.size) {
                displayQuestion()
            } else {
                findNavController().navigate(R.id.action_quizFragment_to_resultFragment)
            }
        }
        nxt.isEnabled = false

        var1?.setOnClickListener {
            nxt.isEnabled = true
        }
        var2?.setOnClickListener {
            nxt.isEnabled = true
        }
        var3?.setOnClickListener {
            nxt.isEnabled = true
        }




        displayQuestion()
    }

    fun displayQuestion() {
        val question = view?.findViewById<TextView>(R.id.question)
        question?.text = dataManager.test.voprosi[currentQuestion].text

        var1?.text = dataManager.test.voprosi[currentQuestion].otveti[0].text
        var2?.text = dataManager.test.voprosi[currentQuestion].otveti[1].text
        var3?.text = dataManager.test.voprosi[currentQuestion].otveti[2].text

        allVars?.clearCheck()

    }

}