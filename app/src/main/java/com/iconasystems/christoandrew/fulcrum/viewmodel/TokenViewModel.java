package com.iconasystems.christoandrew.fulcrum.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.iconasystems.christoandrew.fulcrum.models.Token;
import com.iconasystems.christoandrew.fulcrum.repository.DataRepository;

public class TokenViewModel extends AndroidViewModel {
    private final DataRepository repository;
    private Token token;
    public TokenViewModel(@NonNull Application application) {
        super(application);
        this.repository = new DataRepository(application);
        token = this.repository.getToken();
    }

    public Token getToken() {
        return token;
    }

    public void insertToken(String token){
        this.repository.insertToken(token);
    }
}
