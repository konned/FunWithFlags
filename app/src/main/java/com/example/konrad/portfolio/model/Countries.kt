package com.example.konrad.portfolio.model

import com.squareup.moshi.Json
import java.io.Serializable


/**
 * Class which provides a model for post
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 */

data class Countries(
        @Json(name = "alpha2Code")
        val alpha2Code: String,
        @Json(name = "alpha3Code")
        val alpha3Code: String,
        @Json(name = "altSpellings")
        val altSpellings: List<String>,
        @Json(name = "area")
        val area: Double?,
        @Json(name = "borders")
        val borders: List<String>,
        @Json(name = "callingCodes")
        val callingCodes: List<String>,
        @Json(name = "capital")
        val capital: String,
        @Json(name = "cioc")
        val cioc: String,
        @Json(name = "currencies")
        val currencies: List<Currency>,
        @Json(name = "demonym")
        val demonym: String,
        @Json(name = "flag")
        val flag: String,
        @Json(name = "gini")
        val gini: Any,
        @Json(name = "languages")
        val languages: List<Language>,
        @Json(name = "latlng")
        val latlng: List<Double?>,
        @Json(name = "name")
        val name: String,
        @Json(name = "nativeName")
        val nativeName: String,
        @Json(name = "numericCode")
        val numericCode: String,
        @Json(name = "population")
        val population: Double?,
        @Json(name = "region")
        val region: String,
        @Json(name = "regionalBlocs")
        val regionalBlocs: List<RegionalBloc>,
        @Json(name = "subregion")
        val subregion: String,
        @Json(name = "timezones")
        val timezones: List<String>,
        @Json(name = "topLevelDomain")
        val topLevelDomain: List<String>,
        @Json(name = "translations")
        val translations: Translations
) : Serializable


data class Translations(
        @Json(name = "br")
        val br: String,
        @Json(name = "de")
        val de: String,
        @Json(name = "es")
        val es: String,
        @Json(name = "fa")
        val fa: String,
        @Json(name = "fr")
        val fr: String,
        @Json(name = "hr")
        val hr: String,
        @Json(name = "it")
        val `it`: String,
        @Json(name = "ja")
        val ja: String,
        @Json(name = "nl")
        val nl: String,
        @Json(name = "pt")
        val pt: String
) : Serializable

data class Currency(
        @Json(name = "code")
        val code: String,
        @Json(name = "name")
        val name: Any,
        @Json(name = "symbol")
        val symbol: Any
)  : Serializable

data class Language(
        @Json(name = "iso639_1")
        val iso6391: String,
        @Json(name = "iso639_2")
        val iso6392: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "nativeName")
        val nativeName: String
)  : Serializable

data class RegionalBloc(
        @Json(name = "acronym")
        val acronym: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "otherAcronyms")
        val otherAcronyms: List<Any>,
        @Json(name = "otherNames")
        val otherNames: List<String>
)  : Serializable