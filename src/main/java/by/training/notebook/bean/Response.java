package by.training.notebook.bean;


public class Response {

    private boolean status;


    public Response(){}

    public Response(boolean status){
        setStatus(status);
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
