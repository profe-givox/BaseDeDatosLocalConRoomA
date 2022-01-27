package net.ivanvega.basededatoslocalconrooma.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.ivanvega.basededatoslocalconrooma.data.AppDatabase;
import net.ivanvega.basededatoslocalconrooma.data.User;
import net.ivanvega.basededatoslocalconrooma.data.UserDao;

import java.util.List;

public class MiContentProvider extends ContentProvider {
    /*Estructura de mi uri:
        uri -> content://net.ivanvega.basededatoslocalconrooma.provider/user  -> insert y query
        uri -> content://net.ivanvega.basededatoslocalconrooma.provider/user/#  -> uodate y delete
        uri -> content://net.ivanvega.basededatoslocalconrooma.provider/user/*  -> query, update y delete
    */

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static
    {

        sURIMatcher.addURI("net.ivanvega.basededatoslocalconrooma.provider","user", 1);
        sURIMatcher.addURI("net.ivanvega.basededatoslocalconrooma.provider","user/#", 2);
        sURIMatcher.addURI("net.ivanvega.basededatoslocalconrooma.provider","user/*", 3);
    }


    @Override
    public boolean onCreate() {

        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] strings,
                        @Nullable String s,
                        @Nullable String[] strings1,
                        @Nullable String s1) {

        AppDatabase db =
                AppDatabase.getDatabaseInstance(getContext());

        UserDao dao = db.userDao();


        switch (sURIMatcher.match(uri)){
            case 1:

                dao.getAll();
                break;
            case 2:
                break;

            case 3:
                break;

        }


        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri,
                      @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

}
