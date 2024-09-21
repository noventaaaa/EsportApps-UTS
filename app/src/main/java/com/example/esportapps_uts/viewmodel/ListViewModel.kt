package com.example.esportapps_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.esportapps_uts.model.Game

class ListViewModel:ViewModel() {
    val gameLD = MutableLiveData<ArrayList<Game>>()
    val gameLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        gameLD.value = arrayListOf(
            Game("16055",
                "Mobile Legend",
                "Mobile Legends adalah salah satu game bergenre MOBA (Multiplayer Online Battle Arena) yang sangat populer di platform mobile. Dikembangkan oleh Moonton, game ini menghadirkan pertempuran 5v5 di mana pemain membentuk tim untuk menghancurkan markas lawan dengan mengendalikan berbagai hero yang memiliki kemampuan unik. Setiap hero dibagi dalam beberapa kategori seperti tank, marksman, mage, assassin, fighter, dan support, sehingga menciptakan strategi yang beragam dalam setiap pertandingan. Selain gameplay yang dinamis, Mobile Legends juga memiliki komunitas besar dan sering mengadakan turnamen eSports tingkat internasional, menjadikannya sebagai salah satu game mobile paling kompetitif dan diminati di dunia.",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.indosport.com%2Fesports%2F20211007%2Fajang-reuni-bintang-mobile-legend-di-hari-jadi-mlbb&psig=AOvVaw3qKT5zif3vL3ADHnKEjuco&ust=1727023632794000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCLCjpP691IgDFQAAAAAdAAAAABAE"),
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
}