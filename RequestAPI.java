public interface RequestAPI {

    @FormUrlEncoded
    @POST("abc.php")
    Call<User> createTask(@Field("firstname") String , @Field("lastname") String name);

}
