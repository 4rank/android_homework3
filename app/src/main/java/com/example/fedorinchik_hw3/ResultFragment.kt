package com.example.fedorinchik_hw3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ANSWER = "param1"

class ResultFragment : Fragment() {
    private var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ANSWER)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_result,
                container,
                false)
        root.findViewById<TextView>(R.id.text_answer).text = "$text баллов"
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(answer: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ANSWER, answer)
                }
            }
    }
}