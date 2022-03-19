package com.example.atimesb.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.atimesb.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        resultText.text = viewModel.getResult().toString()

        val resultObserver = Observer<Int> {
                result -> resultText.text = result.toString()
        }

        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        equals.setOnClickListener {
            if (aNumber.text.isNotEmpty() && bNumber.text.isNotEmpty()){
                viewModel.setA(aNumber.text.toString().toInt())
                viewModel.setB(bNumber.text.toString().toInt())
            } else {
                resultText.text = "No Value"
            }
        }
    }

}