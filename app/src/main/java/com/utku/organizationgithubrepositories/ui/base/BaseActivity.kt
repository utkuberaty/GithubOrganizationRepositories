package com.utku.organizationgithubrepositories.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.utku.organizationgithubrepositories.R
import com.utku.organizationgithubrepositories.util.TAG

/**
 * Abstract base activity for all activities, all activity extends [BaseActivity]
 * abstract viewModel forces all activities to use viewModel
 * */

abstract class BaseActivity<VB : ViewBinding>(val bindingFactory: (LayoutInflater) -> VB) :
    AppCompatActivity() {

    abstract val viewModel: ViewModel

    protected val viewBinding: VB by lazy { bindingFactory(layoutInflater) }

    /**
     * Activity lifeCycle methods, It's calls when activity create
     * Sets given viewBiding [VB] from constructor to activity setContentView automatically
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(viewBinding.root)
    }

    fun showErrorMessage(message: String): AlertDialog =
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.alert)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, _ -> dialog.dismiss() }
            .show()
}