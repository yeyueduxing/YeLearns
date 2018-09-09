package com.yeyue.learns.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.yeyue.learns.contract.BizhiUserContract;
import com.yeyue.learns.model.BizhiUserModel;

import dagger.Module;
import dagger.Provides;


@Module
public class BizhiUserModule {
    private BizhiUserContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public BizhiUserModule(BizhiUserContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BizhiUserContract.View provideUserView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BizhiUserContract.Model provideUserModel(BizhiUserModel model) {
        return model;
    }
}