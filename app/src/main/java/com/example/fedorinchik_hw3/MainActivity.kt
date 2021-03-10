package com.example.fedorinchik_hw3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


interface MyInterface {

    fun startQuestions()
    fun finishQuestions(ans: String)
    fun answerQuestion(position: Int, result: Boolean)
}

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), MyInterface {

    private val questions = arrayOf(QuestionsFragment.newInstance("Тогда поехали!\n"+"В мире 6 океанов?"), QuestionsFragment.newInstance("Капитана Немо придумал Жюль Верн?"),
            QuestionsFragment.newInstance("Мандолина – это фрукт?"), QuestionsFragment.newInstance("В геноме человека 46 хромосом?"),
            QuestionsFragment.newInstance("У мухи два глаза?"), QuestionsFragment.newInstance("Склифосовский – это поэт?"),
            QuestionsFragment.newInstance("Существует Слоновья гора?"), QuestionsFragment.newInstance("Керамическая кружка сделана из глины?"),
            QuestionsFragment.newInstance("На земном шаре 24 часовых пояса?"), QuestionsFragment.newInstance("Розовые фламинго не умеют летать?"))
    private var number=-1
    private var answer=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(FirstFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun finishQuestions(ans:String) {
        replaceFragment(ResultFragment.newInstance(ans))
    }

    override fun startQuestions() {
        replaceFragment(QuestionsFragment.newInstance("Здесь будут отбражаться вопросы, отвечать нужно да или нет. Готовы? (Это и будет первый ворос)"))
    }

    override fun answerQuestion(position: Int, result: Boolean) {
        number++
        replaceFragment(questions[number])
        if (number==0 && result){
            answer+=position
        }
        if (number==1 && !result){
            answer+=position
        }
        if (number==2 && result){
            answer+=position
        }
        if(number==3 && !result){
            answer+=position
        }
        if (number==4 && result){
            answer+=position
        }
        if (number==5 && result){
            answer+=position
        }
        if (number==6 && !result){
            answer+=position
        }
        if (number==7 && result){
            answer+=position
        }
        if (number==8 && result){
            answer+=position
        }
        if (number==9){
            if (result){
                answer+=position
            }
            val res:String= answer.toString()
            finishQuestions(res)
        }
    }
}