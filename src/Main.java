import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static ArrayList<String> History = new ArrayList<>();
    static GUI gui;
    private static int total;
    private static final ArrayList<String> List = new ArrayList<>();

    private Main() throws IOException {
        init();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void lottery() {
        String temp1, temp2, temp3, temp4, temp5;
        temp1 = List.get((int) (Math.random() * total));
        temp2 = List.get((int) (Math.random() * total));
        temp3 = List.get((int) (Math.random() * total));
        temp4 = List.get((int) (Math.random() * total));
        temp5 = List.get((int) (Math.random() * total));
        GUI.settext(temp1, temp2, temp3, temp4, temp5);
    }

    private void readCSV() throws IOException {
        File csv = new File("resources/LotteryList.csv");
        BufferedReader reader = new BufferedReader(new FileReader(csv.getCanonicalFile()));
        BufferedReader br = new BufferedReader(new FileReader(csv.getCanonicalFile()));
        int Count = 0;
        while (br.readLine() != null) {
            Count++;
        }
        total = Count;
        br.close();
        while (Count != 0) {
            Count--;
            String temp = reader.readLine();
            System.out.println(temp);
            List.add(temp);
        }
        reader.close();
    }

    private void init() throws IOException {
        GUI.main(null);
        readCSV();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (History.size() != 0) {
                    History.add(History.size(), History.get(0));
                    History.remove(0);
                    GUI.updateText();
                }
            }
        }, 1000, 1000);

    }
}