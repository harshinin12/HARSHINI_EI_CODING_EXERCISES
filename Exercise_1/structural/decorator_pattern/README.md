# LLM AI Agent Subscription Demo – Decorator Pattern

## Overview
This project demonstrates the Decorator Design Pattern by simulating a subscription-based LLM AI agent.  
The base AI agent provides fundamental intelligence, while different subscription tiers add enhanced functionalities dynamically without modifying the core agent.

## Use Case
We have a base LLM AI agent offering core intelligence.  
Subscription tiers (Free, Go, Plus, Business, Pro) provide enhanced capabilities such as:
- Expanded messaging and file uploads  
- Faster image generation  
- Extended memory and context  
- Task/project management  
- Advanced reasoning, agent mode, video & coding tools  

Instead of creating a separate class for every combination of features, we use decorators to layer additional functionalities on top of the base AI agent dynamically at runtime.


## Why it is Decorator Pattern
1. **Base Component:**  
   - AI interface defines core functionality (accessFeatures).  
   - FreePlan implements the base intelligence.  

2. **Decorator Abstraction:**  
   - AIPlanDecorator wraps an AI object and delegates the call.  

3. **Concrete Decorators:**  
   - GoPlan, PlusPlan, BusinessPlan, ProPlan extend the decorator and add specific features dynamically.  

4. **Dynamic Composition:**  
   - You can layer decorators: e.g., new ProPlan(new GoPlan(new FreePlan())).

**Key Demonstration in code**
```java
        AI free = new FreePlan();
        System.out.println("=== Free Plan ===");
        free.accessFeatures();

        System.out.println("\n=== Go Plan ===");
        AI go = new GoPlan(new FreePlan());
        go.accessFeatures();

        System.out.println("\n=== Plus Plan ===");
        AI plus = new PlusPlan(new FreePlan());
        plus.accessFeatures();
```

## Output Screenshot
<img width="1598" height="462" alt="image" src="https://github.com/user-attachments/assets/7b254e7c-38de-437f-b7dd-000e94c2dbab" />

