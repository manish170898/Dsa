package org.dsa.Graph;

import java.util.*;

public class G42AccountsMerge {
//    https://leetcode.com/problems/accounts-merge/description/
    public static void main(String[] args) {
        List<List<String>> accounts = List.of(List.of("John","johnsmith@mail.com","john_newyork@mail.com"),List.of("John","johnsmith@mail.com","john00@mail.com"),List.of("Mary","mary@mail.com"),List.of("John","johnnybravo@mail.com"));
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        G38DisjointSetBySize ds = new G38DisjointSetBySize(accounts.size());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i< accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(map.get(mail) == null){
                    map.put(mail, i);
                }
                else{
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        List<List<String>> finalAccounts = new ArrayList<>();
        for(int i=0; i< accounts.size(); i++){
            mergedAccounts.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer>entry: map.entrySet()){
            int parentEntry = ds.findPar(entry.getValue());
            mergedAccounts.get(parentEntry).add(entry.getKey());
        }

        for (int i=0; i<accounts.size(); i++){
            if(! mergedAccounts.get(i).isEmpty()){
                String name = accounts.get(i).get(0);
                Collections.sort(mergedAccounts.get(i));
                List<String> temp = new ArrayList<>();
                mergedAccounts.get(i).add(0,name);
                finalAccounts.add(mergedAccounts.get(i));
            }
        }
        return finalAccounts;
    }
}
