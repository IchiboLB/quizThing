package com.basdoor.quizzz.services

import com.basdoor.quizzz.model.Otvet
import com.basdoor.quizzz.model.Test
import com.basdoor.quizzz.model.Vopros

var vopros1 = Vopros(
    text = "Where were you last night?",
    otveti = mutableListOf(
        Otvet(
            text = "at home",
            isCorrect = true
        ),
        Otvet(
            text = "at the crime scene",
            isCorrect = false
        ),
        Otvet(
            text = "at school(I'm 38)",
            isCorrect = false
        )
    )
)

var vopros2 = Vopros(
    text = "Were you friends with the victim?",
    otveti = mutableListOf(
        Otvet(
            text = "of course",
            isCorrect = false
        ),
        Otvet(
            text = "not at all",
            isCorrect = true
        ),
        Otvet(
            text = "more than that, I was his murderer",
            isCorrect = false
        )
    )
)

var vopros3 = Vopros(
    text = "Do you know anything about this? *shows evidence*",
    otveti = mutableListOf(
        Otvet(
            text = "that's my thing!",
            isCorrect = false
        ),
        Otvet(
            text = "I saw it somewhere",
            isCorrect = false
        ),
        Otvet(
            text = "what is it?",
            isCorrect = true
        )
    )
)

var testExample = Test(
    voprosi = mutableListOf(vopros1, vopros2, vopros3),
    score = 0
)