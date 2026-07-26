package com.dontsu.presentation.ui.base

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(
    private val inflate: Inflate<VB>
) : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = inflate.invoke(layoutInflater, null, false)
        setContentView(binding.root)
        applyWindowInsets()
        initObservers()
        initViews()
        initListeners()
    }

    private fun applyWindowInsets() = with(binding.root) {
        val initialPaddingLeft = paddingLeft
        val initialPaddingTop = paddingTop
        val initialPaddingRight = paddingRight
        val initialPaddingBottom = paddingBottom

        ViewCompat.setOnApplyWindowInsetsListener(this) { view, windowInsets ->
            val systemBars = windowInsets.getInsets(
                WindowInsetsCompat.Type.systemBars() or
                    WindowInsetsCompat.Type.displayCutout()
            )
            val ime = windowInsets.getInsets(WindowInsetsCompat.Type.ime())

            view.updatePadding(
                left = initialPaddingLeft + systemBars.left,
                top = initialPaddingTop + systemBars.top,
                right = initialPaddingRight + systemBars.right,
                bottom = initialPaddingBottom + maxOf(systemBars.bottom, ime.bottom)
            )
            windowInsets
        }
        ViewCompat.requestApplyInsets(this)
    }

    open fun initViews() = Unit

    open fun initListeners() = Unit

    /**
     * this method will be used for Observing StateFlow<T>.
     * it’s recommended to call this API in the activity’s onCreate to avoid unexpected behaviors.
     * */
    open fun initObservers() = Unit

}
