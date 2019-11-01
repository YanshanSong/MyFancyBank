
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * The class is designed to read and write json files which store data of costumers and the banker.
 */
public class JsonRW {
    private String customersJsonFilePath;
    private String bankerJsonFilePath;
    private String transactionsJsonFilePath;
    private File customersJsonFile;
    private File bankerJsonFile;
    private File transactionsJsonFile;

    public JsonRW() throws IOException {
        customersJsonFilePath = "./src/data/customers.json";
        bankerJsonFilePath = "./src/data/banker.json";
        transactionsJsonFilePath = "./src/data/transactions.json";

        customersJsonFile = new File(customersJsonFilePath);
        bankerJsonFile = new File(bankerJsonFilePath);
        transactionsJsonFile = new File(transactionsJsonFilePath);

        if(!customersJsonFile.exists()) {
            customersJsonFile.createNewFile();
        }
        if(!bankerJsonFile.exists()){
            bankerJsonFile.createNewFile();
        }
        if(!transactionsJsonFile.exists()) {
            transactionsJsonFile.createNewFile();
        }

    }


    public String readJsonFile(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String content = "";
        String line;
        while((line = br.readLine()) != null) {
            content += line;
        }
        return content;
    }


    public void writeJsonFile(String filePath, String jsonString) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(jsonString);
        fw.close();
    }

    public ArrayList<String> getCustomersNames() throws IOException {
        String customersData = readJsonFile(customersJsonFile.getPath());
        ArrayList<String> customersNames = new ArrayList<>();
        if(customersData.equals("")) {
            return customersNames;
        }else{
            JSONArray customersJsonArray = JSONArray.parseArray(customersData);
            for(int i = 0; i < customersJsonArray.size(); i++) {
                JSONObject customerJsonObject = customersJsonArray.getJSONObject(i);
                customersNames.add(customerJsonObject.getString("name"));
            }
            return customersNames;
        }
    }

    public Customer getCustomerByName(String name) throws IOException {
        String customersData = readJsonFile(customersJsonFile.getPath());
        if (customersData.equals("")) {
            return null;
        }else{
            JSONArray customersJsonArray = JSONArray.parseArray(customersData);
            for(int i = 0; i < customersJsonArray.size(); i++) {
                JSONObject customerJsonObject = customersJsonArray.getJSONObject(i);
                if(customerJsonObject.get("name").equals(name)) {
                    String customerJsonString = customerJsonObject.toJSONString();
                    Customer customer = JSONObject.parseObject(customerJsonString, Customer.class);
                    return customer;
                }
            }
            return null;
        }
    }

    public Banker getBanker() throws IOException {
        String bankerData = readJsonFile(bankerJsonFile.getPath());
        Banker banker = JSONObject.parseObject(bankerData, Banker.class);
        return banker;
    }

    public ArrayList<Transaction> getAllTransactions() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String transactionsData = readJsonFile(transactionsJsonFile.getPath());
        JSONArray transactionsJsonArray;

        if(transactionsData.equals("")) {
            return transactions;
        }else{
            transactionsJsonArray = JSONArray.parseArray(transactionsData);
        }

        for(int i = 0; i < transactionsJsonArray.size(); i++) {
            JSONObject transactionJsonObject = transactionsJsonArray.getJSONObject(i);
            String transactionJsonString = transactionJsonObject.toJSONString();
            Transaction transaction = JSONObject.parseObject(transactionJsonString, Transaction.class);
            transactions.add(transaction);
        }

        // sort
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
			public int compare(Transaction t1, Transaction t2) {
                SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = ft.parse(t1.getDate());
                    date2 = ft.parse(t2.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(date1.equals(date2)) {
                    return t2.getName().compareTo(t1.getName());
                }else{
                   if(date1.before(date2)) {
                       return 1;
                   }else{
                       return -1;
                   }
                }
            }
        });
        return transactions;
    }

    public void updateCustomers(Customer customer) throws IOException {
        String customersData = readJsonFile(customersJsonFile.getPath());
        JSONArray customersJsonArray;
        if(customersData.equals("")) {
            customersJsonArray = new JSONArray();
        }else{
            customersJsonArray = JSONArray.parseArray(customersData);
        }

        JSONObject customerJsonObject;
        for(int i = 0; i < customersJsonArray.size(); i++) {
            customerJsonObject = customersJsonArray.getJSONObject(i);
            if(customerJsonObject.get("name").equals(customer.getName())) {
                customersJsonArray.remove(customerJsonObject);
            }
        }

        String customerJsonString = JSONObject.toJSONString(customer);
        customerJsonObject = JSONObject.parseObject(customerJsonString);
        customersJsonArray.add(customerJsonObject);
        customersData = customersJsonArray.toJSONString();

        writeJsonFile(customersJsonFile.getPath(),customersData);
    }

    public void updateTransactions(Transaction transaction) throws IOException {
        String transactionsData = readJsonFile(transactionsJsonFile.getPath());
        JSONArray transactionsJsonArray;
        if(transactionsData.equals("")) {
            transactionsJsonArray = new JSONArray();
        }else{
            transactionsJsonArray = JSONArray.parseArray(transactionsData);
        }

        String transactionJsonString = JSONObject.toJSONString(transaction);
        JSONObject transactionJsonObject = JSONObject.parseObject(transactionJsonString);
        transactionsJsonArray.add(transactionJsonObject);
        transactionsData = transactionsJsonArray.toJSONString();

        writeJsonFile(transactionsJsonFile.getPath(), transactionsData);
    }

}