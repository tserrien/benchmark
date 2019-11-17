public class Launcher implements Runnable{

    private int[] metrics;
    private String[] params;

    public Launcher(){}

    public Launcher(String[] launchable){
        this.params = launchable;
    }

    @Override
    public void run(){
        StringBuilder cmdCall = new StringBuilder();
        cmdCall.append("cmd /C cd /d ");
        cmdCall.append("\"");
        for(int i = 0; i<params.length; i++){
            cmdCall.append(params[i]);
            if(i< (params.length-1) ) cmdCall.append(" ");
        }
        cmdCall.append("\"");
        try {
            System.out.print(cmdCall.toString());
            Runtime.getRuntime().exec(cmdCall.toString());
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
