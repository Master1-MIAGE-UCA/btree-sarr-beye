package fr.miage.btree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BPlusTree {

    public static void serializeTree(BPlusTree tree, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tree);
            System.out.println("Tree serialized to " + filePath);
        }
    }

    public static BPlusTree deserializeTree(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("Tree deserialized from " + filePath);
            return (BPlusTree) ois.readObject();
        }
    }

    public static void loadDataFromFile(BPlusTree tree, String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int value = Integer.parseInt(line.trim());
                tree.insert(value);
                            }
                            System.out.println("Data loaded into the tree from " + filePath);
                        }
                    }
                
                    private void insert(int value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'insert'");
                    }
                
                    public static void benchmark(BPlusTree tree, String filePath, List<Integer> valuesToSearch) throws IOException {
        long treeTotalTime = 0;
        long treeMinTime = Long.MAX_VALUE;
        long treeMaxTime = Long.MIN_VALUE;

        for (int value : valuesToSearch) {
            long startTime = System.nanoTime();
            tree.search(value);
                        long duration = System.nanoTime() - startTime;
                        treeTotalTime += duration;
                        treeMinTime = Math.min(treeMinTime, duration);
                        treeMaxTime = Math.max(treeMaxTime, duration);
        }
        System.out.println("Tree Search - Avg: " + (treeTotalTime / valuesToSearch.size()) + " ns, Min: " + treeMinTime + " ns, Max: " + treeMaxTime + " ns");
            
        long fileTotalTime = 0;
        long fileMinTime = Long.MAX_VALUE;
        long fileMaxTime = Long.MIN_VALUE;
            
        List<Integer> fileData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileData.add(Integer.parseInt(line.trim()));
            }
        }
            
                    for (int value : valuesToSearch) {
                        long startTime = System.nanoTime();
                        boolean found = fileData.contains(value);
                        long duration = System.nanoTime() - startTime;
                        fileTotalTime += duration;
                        fileMinTime = Math.min(fileMinTime, duration);
                        fileMaxTime = Math.max(fileMaxTime, duration);
                    }
                    System.out.println("File Search - Avg: " + (fileTotalTime / valuesToSearch.size()) + " ns, Min: " + fileMinTime + " ns, Max: " + fileMaxTime + " ns");
                }
            
                private void search(int value) {
                                    // TODO Auto-generated method stub
                                    throw new UnsupportedOperationException("Unimplemented method 'search'");
                }
            
    public static void main(String[] args) throws Exception {
        BPlusTree tree = new BPlusTree();

        String dataFilePath = "data.txt"; 
        loadDataFromFile(tree, dataFilePath);

        String serializedFilePath = "bplus_tree.ser";
        serializeTree(tree, serializedFilePath);
        BPlusTree deserializedTree = deserializeTree(serializedFilePath);

        List<Integer> valuesToSearch = Arrays.asList(100, 200, 300, 1000, 10000); 
        benchmark(deserializedTree, dataFilePath, valuesToSearch);
    }
}
