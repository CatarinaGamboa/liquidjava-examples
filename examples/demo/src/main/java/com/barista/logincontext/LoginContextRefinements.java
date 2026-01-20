package com.barista.logincontext;

import liquidjava.specification.StateSet;
import liquidjava.specification.StateRefinement;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;

import liquidjava.specification.ExternalRefinementsFor;

@StateSet({"created", "loggedIn", "authenticated", "loggedOut"})
@ExternalRefinementsFor("javax.security.auth.login.LoginContext")
public interface LoginContextRefinements {
    
    @StateRefinement(to="created(this)")
    public void LoginContext(String name);

    @StateRefinement(to="created(this)")
    public void LoginContext(String name, CallbackHandler callbackHandler);

    @StateRefinement(to="created(this)")
    public void LoginContext(String name, Subject subject);

    @StateRefinement(to="created(this)")
    public void LoginContext(String name, Subject subject, CallbackHandler callbackHandler);

    @StateRefinement(to="created(this)")
    public void LoginContext(String name, Subject subject, CallbackHandler callbackHandler, Configuration config);

    @StateRefinement(from="created(this) || loggedOut(this)", to="loggedIn(this)")
    public void login();

    @StateRefinement(from="authenticated(this) || loggedIn(this)", to="loggedOut(this)")
    public void logout();

    @StateRefinement(from="authenticated(this)", to="authenticated(this)")
    public Subject getSubject();
}
