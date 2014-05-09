package com.company.ui;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;
import org.rendersnake.RequestUtils;
import org.rendersnake.Renderable;

import com.company.ui.login.LoginForm;

public class HomePage implements Renderable {

    public void renderOn(HtmlCanvas html) throws IOException {
        
        boolean isAuthenticated = RequestUtils.getSession(html).getBoolean("authenticated", false);
        
        if (isAuthenticated) {
            html.h1().content("Hello " + RequestUtils.getSession(html).getString("user"));
        } else {
            html.render(new LoginForm());
        }
        
        html.h4().content("quickstart example app using renderSnake and Spring MVC");
    }
}
