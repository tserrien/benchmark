import java.io.File;
import java.util.Arrays;

public class Launcher implements Runnable{

    private int[] metrics;
    private static String[] params;
    private static  File file;

    public Launcher(){}

    public Launcher(String[] launchable){
        this.params = launchable;
    }

    @Override
    //techincally this method just does a nice cd, need to finish it
    public void run(){
        //System.out.println(getFileExtension());
        String fullpath = params[0];
        String[] noPath = new String[params.length - 1];
        file = new File(fullpath);

        for(int i = 1; i < params.length; i++) noPath[i - 1] = params[i];

        StringBuilder cmdCall = new StringBuilder();
        cmdCall.append("cmd /C cd /d ");
        cmdCall.append("\"");
        for(int i = 0; i<params.length; i++){
            cmdCall.append(params[i]);
            if(i< (params.length-1) ) cmdCall.append(" ");
        }
        cmdCall.append("\"");
        try {
            //System.out.print(cmdCall.toString());
            Runtime.getRuntime().exec(cmdCall.toString());
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //build Java launcher
        cmdCall.delete(0, cmdCall.length());
        cmdCall.append("cmd /C java ");
        cmdCall.append(file.getName());
        cmdCall.append(" ");
        for(int i = 0; i < noPath.length; i++) cmdCall.append(noPath[i] + " ");
        //System.out.println(cmdCall.toString());
        try {
            Runtime.getRuntime().exec(cmdCall.toString());
        }catch (Exception e){
            System.out.println("An error occurred.");
        }
    }

    /**
     * Method to determine extension of program. Will play a bigger role later in benchmarking .jar and maybe .py files.
     * Taken from the graph-coloring project refit for this usecase
     *
     * @return extension as string
     */
    private static String getFileExtension() {
        String fileName = file.getName();

        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

}
