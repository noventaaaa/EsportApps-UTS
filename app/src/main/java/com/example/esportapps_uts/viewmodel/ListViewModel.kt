package com.example.esportapps_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.esportapps_uts.model.Game

class ListViewModel: ViewModel() {
    val gameLD = MutableLiveData<ArrayList<Game>>()

    fun refresh() {
        gameLD.value = arrayListOf(
            Game("16055",
                "Mobile Legend",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla aliquet nisl eget neque viverra bibendum. Mauris at venenatis arcu. Vestibulum lacinia vel nunc ultrices eleifend. " +
                        "Suspendisse potenti. Aliquam tortor ex, hendrerit eu eleifend a, aliquam sagittis purus. Suspendisse eget facilisis sem, at mattis urna. Cras egestas purus nec lacinia porttitor. Duis ullamcorper viverra nulla, quis ultrices nunc viverra vulputate.",
                "https://asset.indosport.com/article/image/q/80/311815/logo_mobile_legends-169.jpg?w=750&h=423"),
            Game("13312",
                "PUBG",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla aliquet nisl eget neque viverra bibendum. Mauris at venenatis arcu. Vestibulum lacinia vel nunc ultrices eleifend. Suspendisse potenti. Aliquam tortor ex, hendrerit eu eleifend a, aliquam sagittis purus. " +
                    "Suspendisse eget facilisis sem, at mattis urna. Cras egestas purus nec lacinia porttitor. Duis ullamcorper viverra nulla, quis ultrices nunc viverra vulputate.",
                "https://wallpapers.com/images/featured/pubg-logo-background-6ldzn94r2bu0r668.jpg"),
            Game("11204",
                "Valorand",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla aliquet nisl eget neque viverra bibendum. Mauris at venenatis arcu. Vestibulum lacinia vel nunc ultrices eleifend. " +
                        "Suspendisse potenti. Aliquam tortor ex, hendrerit eu eleifend a, aliquam sagittis purus. Suspendisse eget facilisis sem, at mattis urna. Cras egestas purus nec lacinia porttitor. Duis ullamcorper viverra nulla, quis ultrices nunc viverra vulputate.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoqu9LGSC7JNonJWOsYndlPqRFLU-Qu6U7rg&s")
        )

    }
}