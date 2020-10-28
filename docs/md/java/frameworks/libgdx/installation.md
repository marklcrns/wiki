---
title: LibGDX Installation Setup
author: Mark Lucernas
date: Oct 17, 2020
---


# Installation

Download [📄 `gdx-setup.java`](https://libgdx.badlogicgames.com/download.html)

LibGDX set up tutorials:

- [📺 Creating Multiplayer Games with LibGDX and NodeJS - Part 1](https://www.youtube.com/watch?v=uIPAaDslhPM&t=284s)
- [📄 Set up libGDX game in Android Studio](http://techduke.io/set-up-libgdx-game-in-android-studio/)
- [📄 Improving workflow with Gradle](https://github.com/libgdx/libgdx/wiki/Improving-workflow-with-Gradle#how-to-remove-gradle-ide-integration-from-your-project)

## Android

- [📄 LibGDX Tutorial - Run Project as Desktop Application in Android Studio](https://www.youtube.com/watch?v=LFs3GiP2Zkc)

### [SOLVED] `Error:Execution failed for task ':android:validateSigningDebug'.`

Run this command in `~/.android` directory

```
keytool -genkey -v -keystore debug.keystore -storepass android -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 -validity 10000
```

> This method works for Windows, Mac and Linux

Ref:

- [📄 libGDX Projects not Running on Android Studio?](https://www.reddit.com/r/libgdx/comments/85pjwt/libgdx_projects_not_running_on_android_studio/?utm_source=share&utm_medium=web2x&context=3)
- [📄 Android: Generate Release/Debug Keystores](https://coderwall.com/p/r09hoq/android-generate-release-debug-keystores)


<br>

# Resources

- [📄 `gdx-setup.java`](https://libgdx.badlogicgames.com/download.html)
- [📺 Creating Multiplayer Games with LibGDX and NodeJS - Part 1](https://www.youtube.com/watch?v=uIPAaDslhPM&t=284s)
- [📄 Set up libGDX game in Android Studio](http://techduke.io/set-up-libgdx-game-in-android-studio/)
- [📄 Improving workflow with Gradle](https://github.com/libgdx/libgdx/wiki/Improving-workflow-with-Gradle#how-to-remove-gradle-ide-integration-from-your-project)
- [📄 LibGDX Tutorial - Run Project as Desktop Application in Android Studio](https://www.youtube.com/watch?v=LFs3GiP2Zkc)
- [📄 libGDX Projects not Running on Android Studio?](https://www.reddit.com/r/libgdx/comments/85pjwt/libgdx_projects_not_running_on_android_studio/?utm_source=share&utm_medium=web2x&context=3)
- [📄 Android: Generate Release/Debug Keystores](https://coderwall.com/p/r09hoq/android-generate-release-debug-keystores)

