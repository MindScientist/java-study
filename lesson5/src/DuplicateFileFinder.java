import java.io.*;
import java.util.*;

class DuplicateFileFinder {

    private String initial_dir = "";
    // мэп для файлов (ключи - длины файлов, значения - пути к файлам)
    private Map<Long, ArrayList<String>> lengths = new HashMap<>();

    void setInitDir(String init_dir) {
        this.initial_dir = init_dir;
    }

    static int compareFiles(File f1, File f2) throws IOException {
        try (BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(f1));
             BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(f2))) {
            while (true) {
                int b1 = bis1.read();
                int b2 = bis2.read();

                if (b1 == -1 && b2 == -1) {
                    return 0;
                }
                if (b1 != b2)
                    return b1 - b2;
            }
        }
    }

    static List<File> getAllFiles(File f) {
        ArrayList<File> files = new ArrayList<>();
        File[] folders = f.listFiles(File::isDirectory);
        for (File folder : folders) {
            files.addAll(getAllFiles(folder));
        }
        File[] files1 = f.listFiles(File::isFile);
        files.addAll(Arrays.asList(files1));

        return  files;
    }

    void find() throws IOException {
        File init_dir = new File(this.initial_dir);
        if (init_dir.isDirectory()) {

            List<File> files_list = getAllFiles(init_dir);
            System.out.println(files_list);

            //File[] files_list = init_dir.listFiles(File::isFile);
            assert files_list != null;
            if (files_list.size() > 0) {
                for (File file : files_list) {
                    //File file = new File(this.initial_dir + filename);
                    Long l = file.length();

                    if (lengths.containsKey(l)) {
                        lengths.get(l).add(file.getPath());
                    } else {
                        ArrayList<String> fname = new ArrayList<>();
                        fname.add(file.getPath());
                        lengths.put(l, fname);
                    }
                }
                for (Long key : lengths.keySet()) {
                    ArrayList files = lengths.get(key);
                    // если длина массива файлов больше 1, значит у них одинаковые длины, проверяем "хеш-функцию" (сумму всех байтов)
                    if (files.size() > 1) {
//                        System.out.println("длина массива файлов больше 1, значит у них одинаковые длины, проверяем \"хеш-функцию\" (сумму всех байтов)");
//                        System.out.println(files);

                        // мэп для файлов (ключи - побайтовые суммы, значения - пути к файлам)
                        Map<Integer, ArrayList<String>> bts_sum = new HashMap<>();

                        for (Object file : files) {
                            Integer f_bts = 0;
                            try (InputStream fis = new FileInputStream(file.toString())) {
                                while (true) {
                                    int c = fis.read();
                                    f_bts += c;
                                    if (c == -1) break;
                                }

                                if (bts_sum.containsKey(f_bts)) {
                                    bts_sum.get(f_bts).add((String) file);
                                } else {
                                    ArrayList<String> fname = new ArrayList<>();
                                    fname.add((String) file);
                                    bts_sum.put(f_bts, fname);
                                }

                            } catch (IOException e) {
                                System.out.println("Не открывается файл" + file.toString());
                            }
                        }
                        for (Integer key_bts_sum : bts_sum.keySet()) {
                            ArrayList<String> file_list = bts_sum.get(key_bts_sum);
                            // если длина массива файлов больше 1, значит у них одинаковые "хеш-функции", сравниваем файлы побайтово
                            if (file_list.size() > 1) {
//                                System.out.println("длина массива файлов больше 1, значит у них одинаковые \"хеш-функции\", сравниваем файлы побайтово");
//                                System.out.println(file_list);

                               TreeSet<File> ts = new TreeSet<>((o1, o2) -> {
                                   try {
                                       return compareFiles(o1, o2);
                                   } catch (IOException e) {
                                       throw new RuntimeException(e);
                                   }
                               });

                                try {
                                    for (String filename:file_list) {
                                        File f = new File(filename);
                                        if (!ts.contains(f)) {
                                            ts.add(f);
                                        } else {
                                            File old = ts.floor(f);
                                            System.out.println("Файл " + f + " такой же как " + old);
                                        }
                                    }
                                } catch (RuntimeException e) {
                                    e.printStackTrace();
                                }

                                /*for (int i = 0; i < file_list.size(); i++) {
                                    for (int j = i + 1; j < file_list.size(); j++) {
                                        File f1 = new File(file_list.get(i).toString());
                                        File f2 = new File(file_list.get(j).toString());
                                        if (compare(f1, f2) == 0) {
                                            System.out.println("Файлы:\n" + f1 + "\nи\n" + f2 + "\nравны.");
                                        }
                                    }
                                }*/
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Указанный путь не является директорией");
        }
    }
}
