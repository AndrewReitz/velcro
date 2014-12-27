# Velcro Template Project

You have just created a new Android Application using the Velcro Template. This template is heavily
based off of [Jake Wharton's](//jakewharton.com) [u2020](//github.com/JakeWharton/u2020)

## Getting Started

To get started simply start adding dependencies to your project's `{{gradleProjectName}}.gradle`
file, and start adding code to your `MainActivity.java`.

## Libraries Included

Before diving in and using this project I suggest you check out and understand these libraries. Most
of them will do work for you automatically when you use the BaseActivity or BaseFragment.

* [Dagger](//github.com/square/dagger) Dependency Injection
* [Butter Knife](//github.com/JakeWharton/butterknife) View Injection
* [Icepick](//github.com/frankiesardo/icepick) Save and Restore State
* [Android Preferences](//github.com/InkApplications/android-preferences) Better Shared Preferences
* [Timber](//github.com/JakeWharton/timber) Better Android Logger
* [Madge](//github.com/JakeWharton/madge) Asset Debugging
* [Scalpel](//github.com/JakeWharton/scalpel) View Debugging

## Other info

This project contains checkstyles setup. To run them simply run `./gradlew check`. To configure them
to your liking just update the `codequality/checkstyle.xml`. For more information see the
[Checkstyles website](//checkstyle.sourceforge.net/).
