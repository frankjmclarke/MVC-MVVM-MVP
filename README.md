# MVC-MVVM-MVP

Android app that creates the same listview using MVC, MVP and MVVM.

MVC is just ui, business logic and backend api in 3 seperate files.
MVP passes a view reference to the presenter, the view implementing the presenter interface. The view has a reference to the presenter.
MVVM, there are no direct references between view and viewModel. The view observes the viewModel and displays changes in viewModel.
