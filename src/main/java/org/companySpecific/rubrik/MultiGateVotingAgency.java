package org.companySpecific.rubrik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.Semaphore;

// Enum to represent the party affiliation
enum Party {
    DEMOCRAT, REPUBLICAN
}

// Person class to represent each person with a name and party affiliation
class Person implements Runnable {
    String name;
    Party party;
    Semaphore bathroomSemaphore;
    BathroomManager manager;

    public Person(String name, Party party, Semaphore bathroomSemaphore, BathroomManager manager) {
        this.name = name;
        this.party = party;
        this.bathroomSemaphore = bathroomSemaphore;
        this.manager = manager;
    }

    public int getBathroomTime() {
        return f(name);
    }

    private int f(String name) {
        // Function to calculate the time taken based on the name.
        // Customize this function as per requirements.
        return (name.length() % 5 + 1) * 2; // Example: (1 to 5) * 2 seconds
    }

    @Override
    public void run() {
        try {
            // Try to acquire a permit to enter the bathroom
            bathroomSemaphore.acquire();
            System.out.println(name + " (" + party + ") entered the bathroom for " + getBathroomTime() + " seconds.");

            // Simulate the bathroom time
            Thread.sleep(getBathroomTime() * 1000); // Multiply by 1000 to simulate real time in seconds

            // Release the permit after using the bathroom
            System.out.println(name + " (" + party + ") is leaving the bathroom.");
            bathroomSemaphore.release();

            // Notify the manager to manage the next entry
            if (bathroomSemaphore.availablePermits() == 3) {
                manager.notifyBathroomEmpty();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// BathroomManager class to manage the bathroom usage
class BathroomManager {
    private final int MAX_CAPACITY = 3;
    private final Semaphore bathroomSemaphore = new Semaphore(MAX_CAPACITY, true);
    private final Semaphore bathroomUpdate = new Semaphore(1, true);
    private final Queue<Person> democratQueue = new LinkedList<>();
    private final Queue<Person> republicanQueue = new LinkedList<>();

    // To keep track of the current party using the bathroom
    private Party currentParty = null;

    public Semaphore getBathroomSemaphore() {
        return bathroomSemaphore;
    }

    // Synchronized method to add a person to the appropriate queue
    public synchronized void addPerson(Person person) {
        if (person.party == Party.DEMOCRAT) {
            democratQueue.offer(person);
        } else {
            republicanQueue.offer(person);
        }
    }

    // Method to manage the bathroom access
    public void manageBathroomAccess() {
        while (!democratQueue.isEmpty() || !republicanQueue.isEmpty()) {
            if (bathroomSemaphore.availablePermits() == MAX_CAPACITY) {
                // Bathroom is empty, choose which party can enter
                synchronized (this) {
                    if (currentParty == null || bathroomSemaphore.availablePermits() == MAX_CAPACITY) {
                        if (!democratQueue.isEmpty() && (republicanQueue.isEmpty() || democratQueue.size() >= republicanQueue.size())) {
                            currentParty = Party.DEMOCRAT;
                            allowPartyToEnter(democratQueue);
                        } else if (!republicanQueue.isEmpty()) {
                            currentParty = Party.REPUBLICAN;
                            allowPartyToEnter(republicanQueue);
                        }
                    }
                }
            }
        }
    }

    // Method to allow a party to enter the bathroom
    private void allowPartyToEnter(Queue<Person> queue) {
        System.out.println("Allowing " + currentParty + "s to enter the bathroom.");
//        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CAPACITY);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < MAX_CAPACITY && !queue.isEmpty(); i++) {
            Person person = queue.poll();
            threadList.add(new Thread(person));
        }

        for(Thread thred : threadList){
            thred.start();
        }

        for (Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        executorService.shutdown();
//        while (!executorService.isTerminated()) {
//            // Wait for all threads to finish
//        }

    }

    // Synchronized method to notify when the bathroom is empty
    public void notifyBathroomEmpty() throws InterruptedException {
        bathroomUpdate.acquire();
        if (bathroomSemaphore.availablePermits() == MAX_CAPACITY) {
            currentParty = null;
        }
        bathroomUpdate.release();
    }
}

// Main class to run the simulation
public class MultiGateVotingAgency {
    public static void main(String[] args) {
        BathroomManager manager = new BathroomManager();

        // Adding some sample people to the queue
        manager.addPerson(new Person("Alice", Party.DEMOCRAT, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("Bob", Party.REPUBLICAN, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("Charlie", Party.DEMOCRAT, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("David", Party.REPUBLICAN, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("Eve", Party.DEMOCRAT, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("Frank", Party.REPUBLICAN, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("Grace", Party.DEMOCRAT, manager.getBathroomSemaphore(), manager));
        manager.addPerson(new Person("Hank", Party.REPUBLICAN, manager.getBathroomSemaphore(), manager));

        // Start the bathroom management
        new Thread(manager::manageBathroomAccess).start();
    }
}


