package com.commonrail.mtf.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.commonrail.mtf.db.Files;
import com.commonrail.mtf.db.InjectorDb;

import com.commonrail.mtf.db.FilesDao;
import com.commonrail.mtf.db.InjectorDbDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig filesDaoConfig;
    private final DaoConfig injectorDbDaoConfig;

    private final FilesDao filesDao;
    private final InjectorDbDao injectorDbDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        filesDaoConfig = daoConfigMap.get(FilesDao.class).clone();
        filesDaoConfig.initIdentityScope(type);

        injectorDbDaoConfig = daoConfigMap.get(InjectorDbDao.class).clone();
        injectorDbDaoConfig.initIdentityScope(type);

        filesDao = new FilesDao(filesDaoConfig, this);
        injectorDbDao = new InjectorDbDao(injectorDbDaoConfig, this);

        registerDao(Files.class, filesDao);
        registerDao(InjectorDb.class, injectorDbDao);
    }
    
    public void clear() {
        filesDaoConfig.getIdentityScope().clear();
        injectorDbDaoConfig.getIdentityScope().clear();
    }

    public FilesDao getFilesDao() {
        return filesDao;
    }

    public InjectorDbDao getInjectorDbDao() {
        return injectorDbDao;
    }

}
