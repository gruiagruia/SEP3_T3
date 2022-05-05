package com.example.sep_t3.core;

import com.example.sep_t3.model.UserModel;
import com.example.sep_t3.model.UserModelManager;

public class ModelFactory {
    private UserModel userModel;

    public ModelFactory() {
        userModel = new UserModelManager();
    }

    public UserModel getAuthModel()
    {
        if(userModel == null)
        {
            userModel = new UserModelManager();
        }
        return userModel;
    }
}
