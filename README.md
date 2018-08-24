# Retrofit
How to use Retrofit in java projects

#### Below method is how to use the `Retrofit`

    RequestAPI requestAPI;
    User request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestAPI = ApiClient.getClient().create(RequestAPI.class);

        requestAPI.getData(request).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                request = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

            }
        });

    }
   
   Download `ApiClient.java` and `RequestAPI.java` files.
   #### Dependencies for Retrofit and Gson past it into .gradle file
    implementation 'com.google.code.gson:gson:2.8.5'
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'


# Loopj
How to use Loopj in java projects

Download `APIManager.java` file.

#### Copy below method and paste into your `Util.java` class.

      public static boolean isNetworkAvailable(Context context) {
                    ConnectivityManager connectivityManager
                           = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    } 
 
 
`apiManager = new APIManager(getActivity());` add this line in `onCreate`
 
#### Below method is how to use the `Loopj`

      RequestParams params = new RequestParams();
              params.put("key1", value1);
              params.put("key2", value2);
              params.put("key3", "" + value3);

        apiManager.get(getContext(), Constants.URLs.API_URL, params, new APIManager.APIResponse() {
            @Override
            public void onSuccess(int statusCode, String result) {
                try {
                    if (result != null) {
                        ModelClass modelclass = new Gson().fromJson(result, ModelClass.class);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(int statusCode, String error) {
                try {
                    //Handle the api error
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNetworkError() {
                try {
                    //Handel internet Error
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

Convert String response in json and assign data to model class
  `ModelClass modelclass = new Gson().fromJson(result, ModelClass.class);`


#### Dependencies for Loopj and Gson past it into .gradle file
     implementation 'com.google.code.gson:gson:2.8.5'
     implementation 'com.loopj.android:android-async-http:1.4.9'
