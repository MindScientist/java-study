import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DuplicateFileFinder {

    private String initial_dir = "";
    private Map<Double, ArrayList<String>> lengths = new HashMap<>();

    void setInitDir(String init_dir) {
        this.initial_dir = init_dir;
    }

    void find() {
        File init_dir = new File(this.initial_dir);
        if (init_dir.isDirectory()) {
            String[] files_list = init_dir.list();
            if (files_list.length > 0) {
                for (String filename : files_list) {
                    File file = new File(this.initial_dir + filename);
                    Double l = (double) file.length();
                    if (lengths.containsKey(l)) {
                        lengths.get(l).add(this.initial_dir + filename);
                    } else {
                        ArrayList<String> fname = new ArrayList<>();
                        fname.add(this.initial_dir + filename);
                        lengths.put(l, fname);
                    }

                }
                for (Double key:lengths.keySet()) {
                    ArrayList files = lengths.get(key);
                    // если длина массива файлов больше 1, значит у них одинаковые длины, проверяем хеши
                    if (files.size() > 1) {

                    }
                }
            }
        } else {
            System.out.println("Указанный путь не является директорией");
        }
    }
}
