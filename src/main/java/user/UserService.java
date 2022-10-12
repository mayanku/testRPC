package user;

import com.mayank.grpc.User;
import com.mayank.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Login");
        String username=request.getUsername();
        String password=request.getPassword();


        User.APIResponse.Builder response= User.APIResponse.newBuilder();

        if(username.equals(password)){
            response.setResponsecode(0).setResponsemessage("SUCCESS");
        }
        else{
            response.setResponsecode(100).setResponsemessage("FAILED");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
