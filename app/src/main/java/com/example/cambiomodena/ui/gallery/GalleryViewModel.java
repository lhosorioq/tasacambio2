package com.example.cambiomodena.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta aplicación convierte el valor de una moneda en otra");
    }

    public LiveData<String> getText() {
        return mText;
    }
}