package org.example.Splitwise;

import java.util.Map;
import java.util.PriorityQueue;

public class DebtSimplification {

    public static void simplifyDebts(Map<User,Double>userBalances){
        PriorityQueue<Pair>debtors=new PriorityQueue<Pair>((a,b)-> (int) (a.amnt-b.amnt));
        PriorityQueue<Pair>creditors=new PriorityQueue<Pair>((a,b)-> (int) (b.amnt-a.amnt));

        for(Map.Entry<User,Double>entrySet:userBalances.entrySet()){
            if(entrySet.getValue() < 0){
                debtors.add(new Pair(entrySet.getKey(), entrySet.getValue()));
            }else{
                creditors.add(new Pair(entrySet.getKey(), entrySet.getValue()));
            }
        }
        while(!debtors.isEmpty() && !creditors.isEmpty()){
            Pair debtor=debtors.poll();
            Pair creditor=creditors.poll();

            double settlementAmnt=Math.min(-debtor.amnt, creditor.amnt);
            System.out.println(debtor.user.getName() + " pays " + creditor.user.getName() + " $" + settlementAmnt);

            debtor.amnt+=settlementAmnt;
            creditor.amnt-=settlementAmnt;

            if(debtor.amnt!=0)debtors.add(debtor);
            if(creditor.amnt!=0)creditors.add(creditor);

        }
    }
}
