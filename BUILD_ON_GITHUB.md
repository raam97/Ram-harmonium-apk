# Build AI Harmonium Guru APK from your phone

1. Create a GitHub repository.
2. Upload the contents of this project to the repository root.
3. Open the **Actions** tab.
4. Select **Build Android APK**.
5. Tap **Run workflow**.
6. Wait for the workflow to finish.
7. Open the completed workflow run.
8. Under **Artifacts**, download `AI-Harmonium-Guru-debug-apk`.
9. Extract the downloaded artifact if needed and install `app-debug.apk` on Android.

The workflow uses JDK 17, Android SDK 35 and Gradle 8.7.
This produces a debug APK for testing. For Google Play distribution, create a signed release build separately.
