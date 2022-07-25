package me.mehdi.transitionresources;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button login;
Button signup;
Scene mainScene;
Scene loginScene;
Scene signupScene;
TransitionSet transitionSet;
TransitionManager transitionMgr;
ViewGroup root;
Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        root = findViewById(R.id.root);
        mainScene = Scene.getSceneForLayout(root, R.layout.activity_main, context);
        loginScene = Scene.getSceneForLayout(root, R.layout.layout_login, context);
        signupScene = Scene.getSceneForLayout(root, R.layout.layout_signup, context);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);

        transitionSet = (TransitionSet) TransitionInflater.from(context).inflateTransition(R.transition.mytransitions);
        transitionMgr = TransitionInflater.from(context).inflateTransitionManager(R.transition.transition_mgr, root);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.login:
                transitionMgr.transitionTo(loginScene);
                break;
            case R.id.signup:
                transitionMgr.transitionTo(signupScene);
                break;
        }
    }
}
