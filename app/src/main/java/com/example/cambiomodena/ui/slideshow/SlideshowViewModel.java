package com.example.cambiomodena.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Acerca de nosotros\n" +
                "\n" +
                "ANDRES FELIPE SALAZAR\n" +
                "Santiago de Cali, CEAD Palmira\n" +
                "afsalazarh@unadvirtual.edu.co\n" +
                "\n" +
                "LUIS HUMBERTO OSORIO QUICENO\n" +
                "CCAV Dosquebradas\n" +
                "lhosorio@unadvirtual.edu.co");
    }

    public LiveData<String> getText() {
        return mText;
    }
}