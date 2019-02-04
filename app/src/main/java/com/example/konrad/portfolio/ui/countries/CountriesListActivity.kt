package com.example.konrad.portfolio.ui.countries

import android.app.ActivityOptions
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.konrad.portfolio.R
import com.example.konrad.portfolio.databinding.ActivityCountriesListBinding
import com.example.konrad.portfolio.model.Countries
import com.example.konrad.portfolio.ui.countries.CountryDetail.CountryDetailActivity
import com.example.konrad.portfolio.utils.extensions.OnItemClickListener
import com.example.konrad.portfolio.utils.extensions.addOnItemClickListener
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.example.konrad.portfolio.utils.COUNTRY_INTENT


class CountriesListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCountriesListBinding
    private lateinit var viewModel: CountriesListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_countries_list)
        binding.countriesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.countriesList.addItemDecoration(itemDecoration)
        viewModel = ViewModelProviders.of(this).get(CountriesListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        binding.countriesList.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val intent = Intent(this@CountriesListActivity, CountryDetailActivity::class.java)
                // To pass any data to next activity
                val countryList: List<Countries> = viewModel.countriesListAdapter.getCountryList()
                intent.putExtra(COUNTRY_INTENT, countryList.get(position))
                // start your next activity
                startActivity(intent)
                overridePendingTransition(R.anim.slide_up, R.anim.no_animation)

            }
        })
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}