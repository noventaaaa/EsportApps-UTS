package com.example.esportapps_uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.example.esportapps_uts.model.Game

import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application):AndroidViewModel(application) {
    val gameLD = MutableLiveData<ArrayList<Game>>()
    val gameLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private val VOLLEY_TAG = "volley.game"
    private var queue: RequestQueue? = null
//
    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())
//
//        val stringRequest = StringRequest(
//            Request.Method.GET,
//            "http://10.0.2.2/game.json",
//            { response ->
//                Log.d("VolleyRequest.Game", response)
//                val cleanedResponse = response.replace(" mph", "")
//                this.gameLD.value = Gson().fromJson<List<Game>>(
//                    cleanedResponse,
//                    object : TypeToken<List<Game>>() {}.type,
//                ) as ArrayList<Game>?
//            },
//            { error ->
//                Log.d("VolleyRequest.Game", error.message.toString())
//            },
//        )
//
//        stringRequest.tag = VOLLEY_TAG
//        queue?.add(stringRequest)

        gameLD.value = arrayListOf(
            Game("16055",
                "Mobile Legend",
                "Mobile Legends adalah salah satu game bergenre MOBA (Multiplayer Online Battle Arena) yang sangat populer di platform mobile. Dikembangkan oleh Moonton, game ini menghadirkan pertempuran 5v5 di mana pemain membentuk tim untuk menghancurkan markas lawan dengan mengendalikan berbagai hero yang memiliki kemampuan unik. Setiap hero dibagi dalam beberapa kategori seperti tank, marksman, mage, assassin, fighter, dan support, sehingga menciptakan strategi yang beragam dalam setiap pertandingan. Selain gameplay yang dinamis, Mobile Legends juga memiliki komunitas besar dan sering mengadakan turnamen eSports tingkat internasional, menjadikannya sebagai salah satu game mobile paling kompetitif dan diminati di dunia.",
                "https://asset.indosport.com/article/image/q/80/311815/logo_mobile_legends-169.jpg?w=750&h=423&t=123"),
            Game("13312",
                "PUBG",
                "PUBG (PlayerUnknown's Battlegrounds) adalah game battle royale yang sangat populer di mana hingga 100 pemain bertarung dalam sebuah peta besar untuk menjadi orang terakhir yang bertahan hidup. Dikembangkan oleh PUBG Corporation, game ini menawarkan gameplay yang intens dan realistis, di mana pemain harus mengumpulkan senjata, perlengkapan, dan kendaraan sambil berusaha bertahan dari serangan pemain lain serta zona permainan yang semakin menyempit. PUBG dikenal karena elemen taktis dan strategi yang dibutuhkan untuk bertahan hidup, baik bermain solo, duo, maupun dalam tim. Dengan grafis yang memukau dan pengalaman yang mendebarkan, PUBG menjadi salah satu game battle royale terlaris dan sering diadakan dalam turnamen eSports skala global.",
                "https://www.wallpaperflare.com/static/42/325/290/pubg-video-games-player-unknown-wallpaper.jpg"),
            Game("11204",
                "Valorant",
                "Valorant adalah game first-person shooter (FPS) taktis yang dikembangkan oleh Riot Games, dirilis pada tahun 2020. Game ini menggabungkan elemen penembakan cepat dengan kemampuan unik dari setiap karakter, yang disebut \"agent,\" menciptakan pengalaman gameplay yang strategis dan mendalam. Setiap agent memiliki peran dan keterampilan spesifik, seperti kemampuan untuk menembus dinding, meletakkan jebakan, atau memulihkan rekan satu tim, sehingga koordinasi dan komunikasi dalam tim menjadi kunci untuk memenangkan pertandingan. Dengan mode permainan berbasis putaran, di mana satu tim menyerang dan lainnya bertahan, Valorant memadukan elemen FPS klasik dengan inovasi yang memikat penggemar eSports dan komunitas gaming di seluruh dunia.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoqu9LGSC7JNonJWOsYndlPqRFLU-Qu6U7rg&s")
        )

        gameLoadErrorLD.value = false
        loadingLD.value = false

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(VOLLEY_TAG)
    }
}