package com.example.application.views.login;

import com.example.application.data.service.AuthService;
import com.example.application.views.admin.AdminView;
import com.example.application.views.home.HomeView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouteConfiguration;

import com.example.application.views.main.MainView;

@Route(value = "login")
@RouteAlias(value = "")
@PageTitle("Login ")
public class LoginView extends Div {

    public LoginView(AuthService authService) {
        setId("login-view");
        var username = new TextField("Username");
        var password = new PasswordField("Password");

        add(
                new H1("Welcome"),
                username,
                password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(username.getValue(), password.getValue());
                        UI.getCurrent().navigate("home");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Wrong credentials.");
                    }


                  /*  if(username.getValue().equals("User")) {
                        RouteConfiguration.forSessionScope().setRoute("home", HomeView.class, MainView.class);

                        UI.getCurrent().navigate("home");
                    }
                    else if(username.getValue().equals("Admin")){
                        RouteConfiguration.forSessionScope().setRoute("admin", AdminView.class, MainView.class);
                        //RouteConfiguration.forSessionScope().setRoute("home", HomeView.class, MainView.class);

                        UI.getCurrent().navigate("admin");
                    }*/
                })
        );
    }

}
