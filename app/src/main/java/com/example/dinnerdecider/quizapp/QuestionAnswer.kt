package com.example.dinnerdecider.quizapp

class QuestionAnswer(question: String, answers: List<String>, correctAnswer: List<String>, private val isRadio: Boolean) {

    val question: String = question
    val answers: List<String> = answers
    val correctAnswer: List<String> = correctAnswer

    fun isCorrect(submitAnswer: List<String>): Boolean{
        return submitAnswer == correctAnswer
    }
}

class Quiz{
    companion object{
        fun getQuestions(): List<QuestionAnswer>{
            val questions = arrayListOf<QuestionAnswer>()

            val question1 = QuestionAnswer("Which of the following is a valid way to define a data class in Kotlin?",
                arrayListOf(
                    "data class Person(val name: String, val age: Int)",
                    "class Person(val name: String, val age: Int): data",
                    "class Person(val name: String, val age: Int)",
                    "data class Person{val name: String, val age: Int}",
                ),
                arrayListOf(
                    "data class Person(val name: String, val age: Int)",
                ),
                true,
            )

            val question2 = QuestionAnswer("Given the following line of code, which of the following commands will print Blue? \n val colors = listOf(\"Red\", \"Green\", \"Blue\")",
                arrayListOf(
                    "println(colors[2])",
                    "println(colors.get(2))",
                    "println(colors.contains(2))",
                    "println(colors.getOrDefaultValue(index = 2, defaultValue = 10))",
                ),
                arrayListOf(
                    "println(colors[2])",
                    "println(colors.get(2))"
                ),
                false,
            )

            questions.add(question1)
            questions.add(question2)
            return questions
        }
    }
}