# TokLite Android

This is an Android Studio project that wraps TokLite in a WebView.

## Build
1. Open this folder in Android Studio.
2. Let Gradle sync.
3. Build > Build APK(s).

## Automatic website updates
Open `app/src/main/java/com/toklite/app/MainActivity.java` and set:

`HOSTED_URL = "https://YOUR-TOKLITE-SITE.example/"`

When `HOSTED_URL` is set, the APK loads the online TokLite site. Updating the website at that same URL updates what the app displays the next time it loads.

If the URL is left blank, the APK uses the bundled local TokLite page instead.

This project does not create fake external views or bypass platform systems. The TokLite demo's bot-view button is only a local test counter.
