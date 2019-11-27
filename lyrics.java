
import java.util.*;
import java.io.*;

public class lyrics {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        HashMap<String, Integer> words = new HashMap<String, Integer>();

        File file = new File("c:\\Users\\Mel\\Desktop\\HW\\Lyrics.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = "";

        while ((st = br.readLine()) != null) {
            String[] word = st.split(" ");
            for (String w : word) {
                String wFixed = w.replaceAll("\\p{Punct}", "").toLowerCase();

                if (words.containsKey(wFixed)) {
                    int i = words.get(wFixed);
                    words.replace(wFixed, i, i + 1);
                } else {
                    words.put(wFixed, 1);
                }
            }

        }
        Map<String, Integer> m = sortByValue(words);

        for (Map.Entry entry : m.entrySet()) {
            System.out.println("Word: " + entry.getKey() + "\t" + " Count: " + entry.getValue());
        }
        br.close();

    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
           
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

}