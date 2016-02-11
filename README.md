# RxJava_MVPSample
ANdroid MVP Example using RxJava. Use case: User's login

## Modules
The project consists of two module which is `app` and `core`. The `core` is a Java-only module which consists Models of the business entity and the Interactors for the business case. The `app` is the main Android app which consists of all the Views and Android Components. According to the Clean Code architecture, there are two main structure here, which is View and Presenter. View here is basically consists of the behaviour and what the View (Activity, Fragment, Holder, etc.) can do. Presenter is like the Controller in the MVC approach where they handle the interactions from the Users then passing it to the appropriate Interactor in the `core` module.
