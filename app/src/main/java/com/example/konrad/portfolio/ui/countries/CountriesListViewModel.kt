package com.example.konrad.portfolio.ui.countries

import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.view.View
import com.example.konrad.portfolio.R
import com.example.konrad.portfolio.base.BaseViewModel
import com.example.konrad.portfolio.model.Countries
import com.example.konrad.portfolio.network.CountriesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountriesListViewModel: BaseViewModel(){
    @Inject
    lateinit var countriesApi: CountriesApi
    val countriesListAdapter: CountriesListAdapter = CountriesListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadCountries() }

    private lateinit var subscription: Disposable

    init{
        loadCountries()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadCountries(){
        subscription = countriesApi.getCountries()
//                .concatMap {
//                    dbPostList ->
//                        if(dbPostList.isEmpty())
//                            countriesApi.getCountries().concatMap {
//                                            apiPostList -> countriesDao.insertAll(*apiPostList.toTypedArray())
//                                 Observable.just(apiPostList)
//                                       }
//                        else
//                            Observable.just(dbPostList)
//                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveCountriesListStart() }
                .doOnTerminate { onRetrieveCountriesListFinish() }
                .subscribe(
                        { result -> onRetrieveCountriesListSuccess(result) },
                        { onRetrievePostListError() }
                )
    }

    private fun onRetrieveCountriesListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveCountriesListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCountriesListSuccess(countriesList:List<Countries>){
        countriesListAdapter.updatePostList(countriesList)
    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error
    }
}