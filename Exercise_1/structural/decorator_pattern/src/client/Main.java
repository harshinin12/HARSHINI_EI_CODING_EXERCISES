package src.client;

import src.component.FreePlan;
import src.component.AI;
import src.decorators.GoPlan;
import src.decorators.PlusPlan;
import src.decorators.BusinessPlan;
import src.decorators.ProPlan;

public class Main {
    public static void main(String[] args) {
        AI free = new FreePlan();
        System.out.println("=== Free Plan ===");
        free.accessFeatures();

        System.out.println("\n=== Go Plan ===");
        AI go = new GoPlan(new FreePlan());
        go.accessFeatures();

        System.out.println("\n=== Plus Plan ===");
        AI plus = new PlusPlan(new FreePlan());
        plus.accessFeatures();

        System.out.println("\n=== Business Plan ===");
        AI business = new BusinessPlan(new FreePlan());
        business.accessFeatures();

        System.out.println("\n=== Pro Plan ===");
        AI pro = new ProPlan(new FreePlan());
        pro.accessFeatures();
    }
}
