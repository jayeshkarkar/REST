# Retrofit
How to use Retrofit in java projects
   
   Download `ApiClient.java` and `RequestAPI.java` files.
   #### Dependencies for Retrofit and Gson past it into .gradle file
    implementation 'com.google.code.gson:gson:2.8.5'
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'


# Loopj
How to use Loopj in java projects

Download `APIManager.java` file.

copy below method and paste into your `Util.java` class.

      ``` public static boolean isNetworkAvailable(Context context) {
                    ConnectivityManager connectivityManager
                            = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
      } ```
 

#### Dependencies for Loopj and Gson past it into .gradle file
     implementation 'com.google.code.gson:gson:2.8.5'
     implementation 'com.loopj.android:android-async-http:1.4.9'
