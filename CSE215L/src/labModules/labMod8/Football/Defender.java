package labModules.labMod8.Football;

import java.util.Scanner;

public class Defender extends Player {
    private int blocks;
    private int tackles;

    public Defender() {
        super();
        this.blocks = 0;
        this.tackles = 0;
    }

    public Defender(String name, String club) {
        super(name, club);
        this.blocks = 0;
        this.tackles = 0;
    }

    public void blockPlayer() {
        this.blocks++;
    }

    public void tacklePlayer() {
        this.tackles++;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getTackles() {
        return tackles;
    }

    @Override
    public void playMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter blocks FOR THE MATCH by " + getName() + ": ");
        int matchBlocks = scanner.nextInt();
        System.out.print("Enter tackles FOR THE MATCH by " + getName() + ": ");
        int matchTackles = scanner.nextInt();

        for (int i = 0; i < matchBlocks; i++) {
            blockPlayer();
        }

        for (int i = 0; i < matchTackles; i++) {
            tacklePlayer();
        }

        super.playMatch(); // Increase matches by 1
        scanner.close();
    }

    public double getBlocksPerMatch() {
        if (getMatches() == 0)
            return 0;
        return (double) blocks / getMatches();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Blocks: " + blocks);
        System.out.println("Total Tackles: " + tackles);
        System.out.printf("Blocks per Match: %.2f\n", getBlocksPerMatch());
    }
}