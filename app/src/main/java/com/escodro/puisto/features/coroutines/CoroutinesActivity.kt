package com.escodro.puisto.features.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.escodro.puisto.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class CoroutinesActivity : AppCompatActivity() {

    lateinit var viewModel: CoroutinesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        viewModel = ViewModelProviders.of(this).get(CoroutinesViewModel::class.java)

        button_main_coroutines.setOnClickListener { viewModel.simpleCoroutinesClicked() }
        button_main_suspend.setOnClickListener { viewModel.suspendFunctionsClicked() }
        button_main_flow.setOnClickListener { viewModel.flowClicked() }

        viewModel.snackbar.observe(
            this,
            Observer { text ->
                Snackbar.make(layout_main_root, text, Snackbar.LENGTH_SHORT).show()
            })
    }
}
