public class APIManager {

    Context context;

    public static final int TIMEOUT = 60 * 1000;


    public APIManager(Context c) {

        this.context = c;

    }

    public interface APIResponse {

        public void onSuccess(int statusCode, String result);

        public void onFail(int statusCode, String error);

        public void onNetworkError();

    }

    public void get(Context context, String URL, RequestParams params, final APIResponse apiResponse) {

        if (!Utils.isNetworkAvailable(context)) {
            apiResponse.onNetworkError();
        } else {
            AsyncHttpClient client = new AsyncHttpClient();
            client.setTimeout(TIMEOUT);
            client.get(context, URL, params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    try {

                        String content = new String(responseBody, "UTF-8");
                        apiResponse.onSuccess(statusCode, content);

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        apiResponse.onSuccess(statusCode, "");
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    try {

                        String content = new String(responseBody, "UTF-8");
                        apiResponse.onFail(statusCode, content);

                    } catch (Exception e) {
                        e.printStackTrace();
                        apiResponse.onSuccess(statusCode, "");
                    }
                }

            });
        }

    }

    public void post(Context context, String URL, RequestParams params, final APIResponse apiResponse) {

        if (!Utils.isNetworkAvailable(context)) {
            apiResponse.onNetworkError();
        } else {
            AsyncHttpClient client = new AsyncHttpClient();
            client.setTimeout(TIMEOUT);
            client.post(context, URL, params, new AsyncHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    try {

                        String content = new String(responseBody, "UTF-8");
                        apiResponse.onSuccess(statusCode, content);

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    try {

                        String content = new String(responseBody, "UTF-8");
                        apiResponse.onFail(statusCode, content);

                    } catch (UnsupportedEncodingException ue) {
                        apiResponse.onFail(statusCode, "");
                        ue.printStackTrace();
                    } catch (Exception e) {
                        apiResponse.onFail(statusCode, "");
                        e.printStackTrace();
                    }

                }
            });
        }

    }

    public void post(Context context, String URL, StringEntity entity, final APIResponse apiResponse) {

        if (!Utils.isNetworkAvailable(context)) {
            apiResponse.onNetworkError();
        } else {
            AsyncHttpClient client = new AsyncHttpClient();
            client.setTimeout(TIMEOUT);

            client.post(context, URL, entity, "application/json", new AsyncHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    try {

                        String content = new String(responseBody, "UTF-8");
                        apiResponse.onSuccess(statusCode, content);

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    try {

                        String content = new String(responseBody, "UTF-8");
                        apiResponse.onFail(statusCode, content);

                    } catch (UnsupportedEncodingException ue) {
                        apiResponse.onFail(statusCode, "");
                        ue.printStackTrace();
                    } catch (Exception e) {
                        apiResponse.onFail(statusCode, "");
                        e.printStackTrace();
                    }

                }
            });
        }

    }

}
