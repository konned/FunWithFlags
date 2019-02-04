package com.example.konrad.portfolio.ui.countries.CountryDetail

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.transition.Transition
import android.view.View
import com.example.konrad.portfolio.R
import com.example.konrad.portfolio.databinding.ActivityCountriesListBinding
import com.example.konrad.portfolio.databinding.ActivityCountryDetailBinding
import com.example.konrad.portfolio.model.Countries
import com.example.konrad.portfolio.ui.countries.CountriesListViewModel
import com.example.konrad.portfolio.utils.COUNTRY_INTENT
import com.example.konrad.portfolio.utils.Utils
import com.squareup.picasso.Callback
import kotlinx.android.synthetic.main.activity_country_detail.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.countries_item.*
import java.lang.Exception


class CountryDetailActivity : AppCompatActivity() {

    lateinit var country : Countries
    private lateinit var binding: ActivityCountryDetailBinding
    private lateinit var viewModel: CountryDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_country_detail)
        viewModel = ViewModelProviders.of(this).get(CountryDetailViewModel::class.java)
        country = intent.getExtras()?.getSerializable(COUNTRY_INTENT) as Countries
        viewModel.bind(country)
        binding.detailviewModel = viewModel
        title = country.name
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
    }

}
