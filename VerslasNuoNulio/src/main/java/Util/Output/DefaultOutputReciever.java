package Util.Output;

public class DefaultOutputReciever implements OutputReciever {
    @Override
    public void produce(String output) {
        System.out.println(output);
    }
}
