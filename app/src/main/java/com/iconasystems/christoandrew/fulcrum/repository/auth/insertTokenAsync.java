package com.iconasystems.christoandrew.fulcrum.repository.auth;

import android.os.AsyncTask;
import android.util.Log;

import com.iconasystems.christoandrew.fulcrum.db.TokenDao;
import com.iconasystems.christoandrew.fulcrum.models.Token;

public class insertTokenAsync extends AsyncTask<String, Void, Void> {
    private TokenDao asyncTokenDao;
    public insertTokenAsync(TokenDao tokenDao) {
        this.asyncTokenDao = tokenDao;
    }


    @Override
    protected Void doInBackground(String... tokens) {
        asyncTokenDao.deleteAll();
        asyncTokenDao.insert(new Token(tokens[0]));
        return null;
    }
}
